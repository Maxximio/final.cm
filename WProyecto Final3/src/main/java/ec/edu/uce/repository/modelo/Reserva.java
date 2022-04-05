package ec.edu.uce.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reserva")
public class Reserva {

	@Id
	@Column(name="res_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_res")
	@SequenceGenerator(name="seq_res",sequenceName = "seq_res",allocationSize = 1)
	private Integer id;
	
	@Column(name="res_numero_reserva")
	private String numeroReserva;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="res_fecha_inicio")
	private LocalDateTime fechaInicio;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="res_fecha_fin")
	private LocalDateTime fechaFin;
	
	@Column(name="res_estado")
	private String estado;//(N,NE)
	
	@ManyToOne
	@JoinColumn(name="vehi_id")
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cobro_id")
	private Cobro cobro;

	//constructor
	public Reserva() {
		
	}
	
	public Reserva(Integer id, String numeroReserva, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estado,
			Vehiculo vehiculo, Cliente cliente, Cobro cobro) {
		super();
		this.id = id;
		this.numeroReserva = numeroReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.cobro = cobro;
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cobro getCobro() {
		return cobro;
	}

	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}
	
	
	
}
