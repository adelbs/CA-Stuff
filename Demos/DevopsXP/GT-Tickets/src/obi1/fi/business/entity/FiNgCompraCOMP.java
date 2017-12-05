package obi1.fi.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FI_NG_COMPRA_COMP")
public class FiNgCompraCOMP extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_COMP_CD_COMPRA", unique = true, nullable = false)
	private Integer idCompCdCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIE_CD_CLIENTE", nullable = false)
	private FiCdClienteCLIE fiCdClienteCLIE;
	
	@Column(name = "ID_TICK_CD_TICKET")
	private Integer idTickCdTicket;
	
	@Column(name = "COMP_DH_COMPRA")
	private String compDhCompra;
	
	@Column(name = "COMP_NR_VALOR")
	private Double compNrValor;

	@Column(name = "COMP_DS_EVENTO")
	private String compDsEvento;

	@Column(name = "COMP_DH_EVENTO")
	private String compDhEvento;

	@Override
	public Class<FiNgCompraCOMP> getEntityClass() {
		return FiNgCompraCOMP.class;
	}

	@Override
	public Integer getId() {
		return getIdCompCdCompra();
	}

	@Override
	public void setId(Integer id) {
		setIdCompCdCompra(id);
	}

	public Integer getIdCompCdCompra() {
		return idCompCdCompra;
	}

	public void setIdCompCdCompra(Integer idCompCdCompra) {
		this.idCompCdCompra = idCompCdCompra;
	}

	public FiCdClienteCLIE getFiCdClienteCLIE() {
		return fiCdClienteCLIE;
	}

	public void setFiCdClienteCLIE(FiCdClienteCLIE fiCdClienteCLIE) {
		this.fiCdClienteCLIE = fiCdClienteCLIE;
	}

	public Integer getIdTickCdTicket() {
		return idTickCdTicket;
	}

	public void setIdTickCdTicket(Integer idTickCdTicket) {
		this.idTickCdTicket = idTickCdTicket;
	}

	public String getCompDhCompra() {
		return compDhCompra;
	}

	public void setCompDhCompra(String compDhCompra) {
		this.compDhCompra = compDhCompra;
	}

	public Double getCompNrValor() {
		return compNrValor;
	}

	public void setCompNrValor(Double compNrValor) {
		this.compNrValor = compNrValor;
	}

	public String getCompDsEvento() {
		return compDsEvento;
	}

	public void setCompDsEvento(String compDsEvento) {
		this.compDsEvento = compDsEvento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCompDhEvento() {
		return compDhEvento;
	}

	public void setCompDhEvento(String compDhEvento) {
		this.compDhEvento = compDhEvento;
	}

}
