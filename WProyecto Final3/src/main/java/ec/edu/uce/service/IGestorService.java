package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.repository.modelo.Cobro;
import ec.edu.uce.repository.modelo.Reserva;
import ec.edu.uce.repository.modelo.Vehiculo;
import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;
import ec.edu.uce.repository.modelo.report.RetiraVehiculo;

public interface IGestorService {

	public List <Vehiculo> vehiculosDisponibles(String marca,String modelo);//1
	
	public Cobro reservar(String placa,String cedula,LocalDateTime fechaInicio,//2
			LocalDateTime fechaFin);
	
	public void registroCliente (String cedula,String nombre,String Apellido,LocalDate fechaN,
			String genero);//3
	
	public void registroClienteComoEmpleado (String cedula,String nombre,String Apellido,
			LocalDate fechaN,String genero);//4
	
	public void ingresarVehiculo(String placa,String modelo, String marca,LocalDate AnioFab,
			String pais,String cilindraje,BigDecimal avaluo,BigDecimal valorDia);//5
	
	public Vehiculo buscarVehiculo(String placa);//6
	
	public RetiraVehiculo retirarVehiculo(String numeroReserva);//7
	
	public void retiroSinReserva();//8
	
	public List<Reserva> reporteReserva(LocalDateTime fechaInicio,LocalDateTime fechaFin);//9
	
	public List<ReportClientesVip> reporteClientesVip();//10
	
	public List<ReportVehiculosVip> reporteVehiculosVip(int mes, int anio);//11

	
	
	void concretarReserva(String temporal, String tarjeta);

	
	
}
