package ec.edu.uce.repository.modelo.report;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class RetiraVehiculo {

	private String placa;
	
	private String modelo;
	
	private String estado;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaI;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaF;
	
	private String reservadoNombre;
	
	private String reservadoApellido;

	//constructor
	public RetiraVehiculo() {
		
	}
	
	public RetiraVehiculo(String placa, String modelo, String estado, LocalDateTime fechaI, LocalDateTime fechaF,
			String reservadoNombre, String reservadoApellido) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.estado = estado;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.reservadoNombre = reservadoNombre;
		this.reservadoApellido = reservadoApellido;
	}

	//get y set
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getReservadoNombre() {
		return reservadoNombre;
	}

	public void setReservadoNombre(String reservadoNombre) {
		this.reservadoNombre = reservadoNombre;
	}

	public String getReservadoApellido() {
		return reservadoApellido;
	}

	public void setReservadoApellido(String reservadoApellido) {
		this.reservadoApellido = reservadoApellido;
	}
	
	
	
}
