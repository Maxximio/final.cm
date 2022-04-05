package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;
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
@Table(name="cobro")
public class Cobro {

	@Id
	@Column(name="cobro_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cobro")
	@SequenceGenerator(name="seq_cobro",sequenceName = "seq_cobro",allocationSize = 1)
	private Integer id;

	@Column(name="cobro_tarjeta")
	private String terjeta;
	
	@Column(name="cobro_valor_sub")
	private BigDecimal subTotal;
	
	@Column(name="cobro_valor_iva")
	private BigDecimal iva;
	
	@Column(name="cobro_valor_total")
	private BigDecimal total;
	
	@Column(name="cobro_estado")
	private String estado;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="cobro_fecha_cobro")
	private LocalDateTime fechaCobro;
	
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;
	
	@OneToOne(mappedBy = "cobro", cascade = CascadeType.ALL)
	private Reserva reserva;

	//constructor
	public Cobro() {
		
	}
	
	public Cobro(Integer id, String terjeta, BigDecimal subTotal, BigDecimal iva, BigDecimal total, String estado,
			LocalDateTime fechaCobro, Cliente cliente, Reserva reserva) {
		super();
		this.id = id;
		this.terjeta = terjeta;
		this.subTotal = subTotal;
		this.iva = iva;
		this.total = total;
		this.estado = estado;
		this.fechaCobro = fechaCobro;
		this.cliente = cliente;
		this.reserva = reserva;
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTerjeta() {
		return terjeta;
	}

	public void setTerjeta(String terjeta) {
		this.terjeta = terjeta;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(LocalDateTime fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
