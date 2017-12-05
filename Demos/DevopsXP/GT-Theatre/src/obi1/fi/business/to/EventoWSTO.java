package obi1.fi.business.to;

public class EventoWSTO {

	private Integer idEvenCdEvento;

	private String evenCdTipo;

	private String evenDsTitulo;
	
	private String evenDsDescricao;
	
	private String evenDhEvento;
	
	private String evenDsLocal;

	private TicketWSTO[] tickets;
	
	public Integer getIdEvenCdEvento() {
		return idEvenCdEvento;
	}

	public void setIdEvenCdEvento(Integer idEvenCdEvento) {
		this.idEvenCdEvento = idEvenCdEvento;
	}

	public String getEvenCdTipo() {
		return evenCdTipo;
	}

	public void setEvenCdTipo(String evenCdTipo) {
		this.evenCdTipo = evenCdTipo;
	}

	public String getEvenDsTitulo() {
		return evenDsTitulo;
	}

	public void setEvenDsTitulo(String evenDsTitulo) {
		this.evenDsTitulo = evenDsTitulo;
	}

	public String getEvenDsDescricao() {
		return evenDsDescricao;
	}

	public void setEvenDsDescricao(String evenDsDescricao) {
		this.evenDsDescricao = evenDsDescricao;
	}

	public String getEvenDhEvento() {
		return evenDhEvento;
	}

	public void setEvenDhEvento(String evenDhEvento) {
		this.evenDhEvento = evenDhEvento;
	}

	public String getEvenDsLocal() {
		return evenDsLocal;
	}

	public void setEvenDsLocal(String evenDsLocal) {
		this.evenDsLocal = evenDsLocal;
	}

	public TicketWSTO[] getTickets() {
		return tickets;
	}

	public void setTickets(TicketWSTO[] tickets) {
		this.tickets = tickets;
	}

}
