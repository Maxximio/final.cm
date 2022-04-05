package ec.edu.uce.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clie")
	@SequenceGenerator(name="seq_clie",sequenceName = "seq_clie",allocationSize = 1)
	private Integer id;
		
	@Column(name="clie_nombre")
	private String nombre;
	
	@Column(name="clie_apellido")
	private String apellido;
	
	@Column(name="clie_cedula")
	private String cedula;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="clie_fecha_nacimiento")
	private LocalDate fechaNac;
	
	@Column(name="clie_genero")
	private String genero;
	
	@Column(name="clie_registro")
	private String registro;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private List<Reserva> reserva;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private List<Cobro> cobro;

	//constructores
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nombre, String apellido, String cedula, LocalDate fechaNac, String genero,
			String registro, List<Reserva> reserva, List<Cobro> cobro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.registro = registro;
		this.reserva = reserva;
		this.cobro = cobro;
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public List<Cobro> getCobro() {
		return cobro;
	}

	public void setCobro(List<Cobro> cobro) {
		this.cobro = cobro;
	}
	
	
	
}
