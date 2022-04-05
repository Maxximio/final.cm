package ec.edu.uce.repository.modelo.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reporte_vehiculos_vip")
public class ReportVehiculosVip {

	@Id
	@Column(name="reve_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reve")
	@SequenceGenerator(name="seq_reve",sequenceName = "seq_reve",allocationSize = 1)
	private Integer id;
	
	@Column(name = "reve_placa")
	private String placa;

	@Column(name = "reve_modelo")
	private String modelo;

	@Column(name = "reve_marca")
	private String marca;

	@Column(name = "reve_valor_total")
	private BigDecimal valorT;

	@Column(name = "reve_subtotal")
	private BigDecimal valorI;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "reve_fecha")
	private LocalDateTime fecha;

	//constructores
	public ReportVehiculosVip() {

	}

	public ReportVehiculosVip(Integer id, String placa, String modelo, String marca, BigDecimal valorT,
			BigDecimal valorI, LocalDateTime fecha) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.valorT = valorT;
		this.valorI = valorI;
		this.fecha = fecha;
	}

	// set y get
	public String getPlaca() {
		return placa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getValorT() {
		return valorT;
	}

	public void setValorT(BigDecimal valorT) {
		this.valorT = valorT;
	}

	public BigDecimal getValorI() {
		return valorI;
	}

	public void setValorI(BigDecimal valorI) {
		this.valorI = valorI;
	}



	public LocalDateTime getFecha() {
		return fecha;
	}



	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
