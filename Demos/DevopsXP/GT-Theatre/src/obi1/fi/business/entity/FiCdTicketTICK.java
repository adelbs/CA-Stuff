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
@Table(name = "FI_CD_TICKET_TICK")
public class FiCdTicketTICK extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_TICK_CD_TICKET", unique = true, nullable = false)
	private Integer idTickCdTicket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EVEN_CD_EVENTO", nullable = false)
	private FiCdEventoEVEN fiCdEventoEVEN;
	
	@Column(name = "TICK_DS_DESCRICAO", length = 50)
	private String tickDsDescricao;
	
	@Column(name = "TICK_NR_VALOR")
	private Double tickNrValor;
	
	@Column(name = "TICK_NR_DISPONIVEL")
	private Integer tickNrDisponivel;
	
	public FiCdTicketTICK() { }
	
	@Override
	public Class<FiCdTicketTICK> getEntityClass() {
		return FiCdTicketTICK.class;
	}

	@Override
	public Integer getId() {
		return getIdTickCdTicket();
	}

	@Override
	public void setId(Integer id) {
		setIdTickCdTicket(id);
	}

	public Integer getIdTickCdTicket() {
		return idTickCdTicket;
	}

	public void setIdTickCdTicket(Integer idTickCdTicket) {
		this.idTickCdTicket = idTickCdTicket;
	}

	public FiCdEventoEVEN getFiCdEventoEVEN() {
		return fiCdEventoEVEN;
	}

	public void setFiCdEventoEVEN(FiCdEventoEVEN fiCdEventoEVEN) {
		this.fiCdEventoEVEN = fiCdEventoEVEN;
	}

	public String getTickDsDescricao() {
		return tickDsDescricao;
	}

	public void setTickDsDescricao(String tickDsDescricao) {
		this.tickDsDescricao = tickDsDescricao;
	}

	public Double getTickNrValor() {
		return tickNrValor;
	}

	public void setTickNrValor(Double tickNrValor) {
		this.tickNrValor = tickNrValor;
	}

	public Integer getTickNrDisponivel() {
		return tickNrDisponivel;
	}

	public void setTickNrDisponivel(Integer tickNrDisponivel) {
		this.tickNrDisponivel = tickNrDisponivel;
	}

}
