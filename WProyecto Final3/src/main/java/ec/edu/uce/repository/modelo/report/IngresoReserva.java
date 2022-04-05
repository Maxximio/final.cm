package ec.edu.uce.repository.modelo.report;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class IngresoReserva {

	private String placa;
	
	private String cedula;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaI;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaF;

	public IngresoReserva() {
		
	}
	


	public IngresoReserva(String placa, String cedula, LocalDateTime fechaI, LocalDateTime fechaF) {
		super();
		this.placa = placa;
		this.cedula = cedula;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
	}



	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public LocalDateTime getFechaI() {
		return fechaI;
	}

	public void setFechaI(LocalDateTime fechaI) {
		this.fechaI = fechaI;
	}

	public LocalDateTime getFechaF() {
		return fechaF;
	}

	public void setFechaF(LocalDateTime fechaF) {
		this.fechaF = fechaF;
	}
	
	
	
}
