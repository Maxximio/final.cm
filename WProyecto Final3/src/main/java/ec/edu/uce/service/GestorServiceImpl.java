package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.Aplicativo;
import ec.edu.uce.repository.modelo.Cliente;
import ec.edu.uce.repository.modelo.Cobro;
import ec.edu.uce.repository.modelo.Reserva;
import ec.edu.uce.repository.modelo.Vehiculo;
import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;
import ec.edu.uce.repository.modelo.report.RetiraVehiculo;
import ec.edu.uce.service.report.IReportService;

@Service
public class GestorServiceImpl implements IGestorService {

	@Autowired
	private IClienteService clienService;

	@Autowired
	private IVehiculoService vehiService;

	@Autowired
	private IReservaService reserService;

	@Autowired
	private ICobroService cobService;

	@Autowired
	private IReportService reporService;
	
	private static final Logger log = LoggerFactory.getLogger(GestorServiceImpl.class);

	private List<Cobro> cobrolista;

	@Override
	public List<Vehiculo> vehiculosDisponibles(String modelo,String marca) {
		
		List<Vehiculo> listaDisponibles = this.vehiService.buscarModeloMarcaService(modelo, marca);

		List<Vehiculo> collect = listaDisponibles
				.stream()
				.filter(li -> li.getEstado() == "D")
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	@Transactional
	public Cobro reservar(String placa, String cedula, LocalDateTime fechaInicio, LocalDateTime fechaFin) {

		Vehiculo veh = this.vehiService.buscarPlacaService(placa);
		Cliente cli = this.clienService.buscarCedulaService(cedula);
		
		log.info(fechaInicio+"   es la fecha de inicio");
		
		if (veh.getEstado().equals("D")) {

			log.info("Ingreso al if");
			
			Reserva rese = new Reserva();
			rese.setCliente(cli);
			rese.setVehiculo(veh);

			rese.setEstado("NE");
			rese.setFechaInicio(fechaInicio);
			rese.setFechaFin(fechaFin);

			Random random = new Random();
			int ran = random.nextInt((10000 - 1) + 1) + 1;
			String numero = String.valueOf(ran);

			rese.setNumeroReserva(numero);

			reserService.insertarService(rese);

			long dias = DAYS.between(fechaInicio, fechaFin);
			BigDecimal d = BigDecimal.valueOf(dias);

			BigDecimal subTotal = veh.getValorDia().multiply(d);
			BigDecimal total = subTotal.multiply(new BigDecimal(1.12));
			BigDecimal iva = total.subtract(subTotal);

			Cobro cob = new Cobro();
			cob.setReserva(rese);
			cob.setCliente(cli);
			cob.setSubTotal(subTotal);
			cob.setIva(iva);
			cob.setTotal(total);
			cob.setEstado("NE");
			cob.setTerjeta("cache");
			cob.setFechaCobro(fechaFin.plusDays(2));// se paga hasta 2 dias despues de usar

			log.info("cob esta con "+cob.getFechaCobro());
			cobService.insertarService(cob);
			
			this.ingresarRegistros(cli, veh, cob);
			
			rese.setCobro(cob);
			reserService.actualizarService(rese);
			
			return cob;
		} else {

			log.info("No genera lista");

		}
		return null;
	}
	
//	public List<Cobro> mostrarCobro(LocalDateTime fI,LocalDateTime fF){
//		
//		long dias = DAYS.between(fI, fF);
//		BigDecimal d = BigDecimal.valueOf(dias);
//
//		BigDecimal subTotal = veh.getValorDia().multiply(d);
//		BigDecimal total = subTotal.multiply(new BigDecimal(1.12));
//		BigDecimal iva = total.subtract(subTotal);
//		
//		Cobro cobro =new Cobro();
//		cobro.get
//		
//		return null;
//		
//	}

	@Override
	@Transactional
	public void concretarReserva(String temporal, String tarjeta) {
		Cobro cob = this.cobService.buscarTarjetaService(temporal);

		if (tarjeta != null) {
			cob.setTerjeta(tarjeta);

			cobService.actualizarService(cob);
			Reserva rese = cob.getReserva();

			Vehiculo veh = rese.getVehiculo();
			Cliente cli = rese.getCliente();

			this.ingresarRegistros(cli, veh, cob);

		} else {
			cobService.borrarService(temporal);
			reserService.borrarService(temporal);
			// imprimir un error

		}
	}

	public void ingresarRegistros(Cliente cli, Vehiculo veh, Cobro cob) {
		ReportClientesVip repocli = new ReportClientesVip();
		repocli.setNombre(cli.getNombre());
		repocli.setApellido(cli.getApellido());
		repocli.setCedula(cli.getCedula());
		repocli.setValorI(cob.getIva());
		repocli.setValorT(cob.getTotal());
		reporService.insertarReCliService(repocli);

		ReportVehiculosVip reve = new ReportVehiculosVip();
		reve.setMarca(veh.getMarca());
		reve.setModelo(veh.getModelo());
		reve.setPlaca(veh.getPlaca());
		reve.setValorI(cob.getSubTotal());
		reve.setValorT(cob.getTotal());
		reve.setFecha(cob.getFechaCobro().minusDays(2));//el mismo dia del final de la reservacion
		reporService.insertarReVeService(reve);
	}

	@Override
	public void registroCliente(String cedula, String nombre, String Apellido, LocalDate fechaN, String genero) {
		Cliente cli = new Cliente();
		cli.setCedula(cedula);
		cli.setNombre(nombre);
		cli.setApellido(Apellido);
		cli.setFechaNac(fechaN);
		cli.setGenero(genero);
		cli.setRegistro("C");

		clienService.insertarService(cli);
	}

	@Override
	public void registroClienteComoEmpleado(String cedula, String nombre, String Apellido, LocalDate fechaN,
			String genero) {

		Cliente cli = new Cliente();
		cli.setCedula(cedula);
		cli.setNombre(nombre);
		cli.setApellido(Apellido);
		cli.setFechaNac(fechaN);
		cli.setGenero(genero);
		cli.setRegistro("E");

		clienService.insertarService(cli);
	}

	@Override
	@Transactional
	public void ingresarVehiculo(String placa, String modelo, String marca, LocalDate AnioFab, String pais,
			String cilindraje, BigDecimal avaluo, BigDecimal valorDia) {

		Vehiculo veh = new Vehiculo();
		veh.setPlaca(placa);
		veh.setModelo(modelo);
		veh.setMarca(marca);
		veh.setAnioFab(AnioFab);
		veh.setPais(pais);
		veh.setCilindraje(cilindraje);
		veh.setAvaluo(avaluo);
		veh.setValorDia(valorDia);
		veh.setEstado("D");

		vehiService.insertarService(veh);

	}

	@Override
	public Vehiculo buscarVehiculo(String placa) {

		Vehiculo veh = this.vehiService.buscarPlacaService(placa);
		return veh;
	}

	@Override
	@Transactional
	public RetiraVehiculo retirarVehiculo(String numeroReserva) {
		Reserva res = this.reserService.buscarNumeroService(numeroReserva);

		Cliente cli = res.getCliente();
		Vehiculo veh = res.getVehiculo();

		List<RetiraVehiculo> miRetiro = null;

		RetiraVehiculo ret = new RetiraVehiculo();

		ret.setPlaca(veh.getPlaca());
		ret.setModelo(veh.getModelo());
		ret.setEstado("E");
		ret.setFechaI(res.getFechaInicio());
		ret.setFechaF(res.getFechaFin());
		ret.setReservadoNombre(cli.getNombre());
		ret.setReservadoApellido(cli.getApellido());

		res.setEstado("E");
		reserService.actualizarService(res);

		veh.setEstado("ND");
		vehiService.actualizarService(veh);

		return ret;
	}

	@Override
	public void retiroSinReserva() {
		// Combina 1,2,7
	}

	@Override
	public List<Reserva> reporteReserva(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		List<Reserva> reporte = this.reserService.buscarTodosService();

		List<Reserva> collect = reporte.stream()
				.filter(li -> li.getFechaInicio().isAfter(fechaInicio) && li.getFechaFin().isBefore(fechaFin))
				.collect(Collectors.toList());

		return collect;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<ReportClientesVip> reporteClientesVip() {
		List<ReportClientesVip> reporte = this.reporService.buscarTodosCliService();

		List<ReportClientesVip> collect = reporte.stream().sorted((o1, o2) -> o1.getValorT().compareTo(o2.getValorT()))
				.collect(Collectors.toList());

		Collections.reverse(collect);

		return collect;
	}

	@Override
	public List<ReportVehiculosVip> reporteVehiculosVip(int mes,int anio) {

		LocalDateTime mifecha=LocalDateTime.of(anio, mes, 0, 0, 0);
		
		List<ReportVehiculosVip> reporte = this.reporService.buscarTodosVehService();
		
		List<ReportVehiculosVip> collect = reporte.stream().filter(li->li.getFecha().isAfter(mifecha))
				.sorted((o1, o2) -> o1.getValorT().compareTo(o2.getValorT()))
				.collect(Collectors.toList());

		Collections.reverse(collect);

		return collect;
	}

}
