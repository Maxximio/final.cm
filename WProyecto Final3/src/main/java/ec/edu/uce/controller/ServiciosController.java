package ec.edu.uce.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.repository.modelo.Cliente;
import ec.edu.uce.repository.modelo.Cobro;
import ec.edu.uce.repository.modelo.Reserva;
import ec.edu.uce.repository.modelo.Vehiculo;
import ec.edu.uce.repository.modelo.report.AnioMes;
import ec.edu.uce.repository.modelo.report.IngresoReserva;
import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;
import ec.edu.uce.repository.modelo.report.RetiraVehiculo;
import ec.edu.uce.service.ICobroService;
import ec.edu.uce.service.IGestorService;

@Controller
@RequestMapping("/sistema")
public class ServiciosController {

	@Autowired
	private IGestorService gestorService;

	@Autowired
	private ICobroService cobService;

/////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/ingresoCliente")
	public String obtenerPaginaIngresoDatosClienteCliente(Cliente cliente) {
		return "clienteNuevo";

	}

	@PostMapping("/insertarc")
	public String insertarClientec(Cliente cliente, BindingResult result, Model modelo) {

		this.gestorService.registroCliente(cliente.getCedula(), cliente.getNombre(), cliente.getApellido(),
				cliente.getFechaNac(), cliente.getGenero());

		return "indexCliente";

	}

/////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/ingresoClienteE")
	public String obtenerPaginaIngresoDatosClienteEmpleado(Cliente cliente) {
		return "clienteNuevoE";

	}

	@PostMapping("/insertare")
	public String insertarClientee(Cliente cliente, BindingResult result, Model modelo) {

		this.gestorService.registroClienteComoEmpleado(cliente.getCedula(), cliente.getNombre(), cliente.getApellido(),
				cliente.getFechaNac(), cliente.getGenero());

		return "indexCliente";

	}

/////////////////////////////////////////////////////////////////////////////////////		
	@GetMapping("/ingresoVehiculo")
	public String obtenerPaginaIngresoDatosVehiculo(Vehiculo vehiculo) {
		return "vehiculoNuevo";

	}

	@PostMapping("/insertarveh")
	public String insertarVehiculo(Vehiculo vehiculo, BindingResult result, Model modelo) {

		this.gestorService.ingresarVehiculo(vehiculo.getPlaca(), vehiculo.getModelo(), vehiculo.getMarca(),
				vehiculo.getAnioFab(), vehiculo.getPais(), vehiculo.getCilindraje(), vehiculo.getAvaluo(),
				vehiculo.getValorDia());

		return "indexVehiculo";

	}
/////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/disponible")
	public String obtenerPaginaVehiculoMM(Vehiculo vehiculo) {
		return "datosVehiculo";

	}

	@GetMapping("/buscarDisponibles")
	public String buscarDisponibles(Vehiculo vehiculo, BindingResult result, Model modelo) {

		List<Vehiculo> listaVehiculos = this.gestorService.vehiculosDisponibles(vehiculo.getModelo(),
				vehiculo.getMarca());

		modelo.addAttribute("vehiculos", listaVehiculos);

		return "listaDisponibles";
	}

/////////////////////////////////////////////////////////////////////////////////////		
	@GetMapping("/buscaPlaca")
	public String obtenerPaginaIngresoPlaca(Vehiculo vehiculo) {
		return "vehiculoBuscarPlaca";

	}

	@GetMapping("/mostrarVpP")
	public String buscarVehiculo(Vehiculo vehiculo, BindingResult result, Model modelo) {

		Vehiculo veh = this.gestorService.buscarVehiculo(vehiculo.getPlaca());

		modelo.addAttribute("vehicular", veh);

		return "mostrarVehiculo";

	}
/////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/reservar")
	public String obtenerPaginaFormReserva(IngresoReserva ingresoReserva) {
		return "procesandoReservacion";
	}

	@PostMapping("/reservacion")
	public String PaginaReservaS(Cobro cobro, IngresoReserva ingresoReserva, BindingResult result, Model modelo) {

		Cobro cobro1 = this.gestorService.reservar(ingresoReserva.getPlaca(), ingresoReserva.getCedula(),
				ingresoReserva.getFechaI(), ingresoReserva.getFechaF());

		modelo.addAttribute("cobros", cobro1);
		modelo.addAttribute("id", cobro1.getId());

		return "mostrarPrecios";

	}

	@PostMapping("/concretar")
	public String concretado(Cobro cobro, Model modelo) {
		return "ingresaTarjeta";

	}

	@GetMapping("/finalizar")
	public String finalizando(Cobro cobro, BindingResult result, Model modelo) {
		Cobro cob = this.cobService.buscarTarjetaService("cache");
		cob.setTerjeta(cobro.getTerjeta());
		cobService.actualizarService(cob);

		return "indexReserva";

	}

/////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/retiro")
	public String obtenerPaginaRetiro(Reserva reserva) {
		return "retirando";

	}

	@GetMapping("/procesoRetiro")
	public String Retirando(Reserva reserva, BindingResult result, Model modelo) {

		RetiraVehiculo retiros = this.gestorService.retirarVehiculo(reserva.getNumeroReserva());

		modelo.addAttribute("retiros", retiros);

		return "mostrarRetiro";

	}
/////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/reporteReserva")
	public String obtenerPaginaReporte(Reserva reserva) {

		return "ingresaFechas";

	}

	@GetMapping("/reporte")
	public String generarReporte(Reserva reserva, BindingResult result, Model modelo) {

		List<Reserva> reservas = this.gestorService.reporteReserva(reserva.getFechaInicio(), reserva.getFechaFin());

		modelo.addAttribute("reservas", reservas);

		return "ReporteReservas";
	}

/////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/reporteClientesVip")
	public String generarReporteCliVip(BindingResult result, Model modelo) {

		List<ReportClientesVip> clientes = this.gestorService.reporteClientesVip();

		modelo.addAttribute("reservas", clientes);

		return "ReporteCli";
	}
/////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/reporteReserva")
	public String obtenerPaginaReportVehi(AnioMes aniomes) {

		return "ingresaFechas2";

	}

	@GetMapping("/reportev")
	public String generarReporteVevip(AnioMes aniomes, BindingResult result, Model modelo) {

		List<ReportVehiculosVip> vehiculos = this.gestorService.reporteVehiculosVip(aniomes.getAnio(),aniomes.getMes());

		modelo.addAttribute("vehiculos", vehiculos);

		return "ReporteVehi";
	}

}
