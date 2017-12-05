package obi1.fi.business.to;

public class TicketWSTO {

	private Integer idTickCdTicket;
	
	private String tickDsDescricao;
	
	private Double tickNrValor;
	
	private Integer tickNrDisponivel;

	public Integer getIdTickCdTicket() {
		return idTickCdTicket;
	}

	public void setIdTickCdTicket(Integer idTickCdTicket) {
		this.idTickCdTicket = idTickCdTicket;
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
