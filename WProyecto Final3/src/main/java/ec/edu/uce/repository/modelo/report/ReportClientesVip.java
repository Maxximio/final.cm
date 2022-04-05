package ec.edu.uce.repository.modelo.report;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="reporte_clientes_vip")
public class ReportClientesVip {

	@Id
	@Column(name="recli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_recli")
	@SequenceGenerator(name="seq_recli",sequenceName = "seq_recli",allocationSize = 1)
	private Integer id;
	
	@Column(name="recli_cedula")
	private String cedula;
	
	@Column(name="recli_nombre")
	private String nombre;
	
	@Column(name="recli_apellido")
	private String apellido;
	
	@Column(name="recli_valor_total")
	private BigDecimal valorT;
	
	@Column(name="recli_valor_iva")
	private BigDecimal valorI;

	//constructor
	public ReportClientesVip() {
		
	}

	public ReportClientesVip(Integer id, String cedula, String nombre, String apellido, BigDecimal valorT,
			BigDecimal valorI) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.valorT = valorT;
		this.valorI = valorI;
	}



	//set y get
	public String getCedula() {
		return cedula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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
}
