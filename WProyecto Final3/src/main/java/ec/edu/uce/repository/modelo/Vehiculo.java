package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;
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
@Table(name="vehiculo")
public class Vehiculo {

	@Id
	@Column(name="vehi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehi")
	@SequenceGenerator(name="seq_vehi",sequenceName = "seq_vehi",allocationSize = 1)
	private Integer id;
	
	@Column(name="vehi_placa")
	private String placa;
	
	@Column(name="vehi_modelo")
	private String modelo;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="vehi_anio_fabricacion")
	private LocalDate anioFab;
	
	@Column(name="vehi_estado")
	private String estado;
	
	@Column(name="vehi_valor")
	private BigDecimal valorDia;
	
	@Column(name="vehi_pais_fabricacion")
	private String pais;
	
	@Column(name="vehi_cilindraje")
	private String cilindraje;
	
	@Column(name="vehi_marca")
	private String marca;
	
	@Column(name="vehi_avaluo")
	private BigDecimal avaluo;
	
	@OneToMany(mappedBy = "vehiculo",cascade=CascadeType.ALL)
	private List<Reserva> reserva;

	//constructores
	public Vehiculo() {
		
	}

	public Vehiculo(Integer id, String placa, String modelo, LocalDate anioFab, String estado, BigDecimal valorDia,
			String pais, String cilindraje, String marca, BigDecimal avaluo, List<Reserva> reserva) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.anioFab = anioFab;
		this.estado = estado;
		this.valorDia = valorDia;
		this.pais = pais;
		this.cilindraje = cilindraje;
		this.marca = marca;
		this.avaluo = avaluo;
		this.reserva = reserva;
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public LocalDate getAnioFab() {
		return anioFab;
	}

	public void setAnioFab(LocalDate anioFab) {
		this.anioFab = anioFab;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorDia() {
		return valorDia;
	}

	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

}
