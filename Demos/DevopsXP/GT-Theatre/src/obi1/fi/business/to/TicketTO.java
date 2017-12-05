package obi1.fi.business.to;

import java.util.ArrayList;
import java.util.List;

import obi1.fi.business.entity.FiCdEventoEVEN;
import obi1.fi.business.entity.FiCdTicketTICK;
import obi1.fi.common.to.DataTableTO;

public final class TicketTO extends AbstractTO<FiCdTicketTICK> {

	private Integer idEvento;
	
	private String descricao;

	private List<FiCdEventoEVEN> listEventos = new ArrayList<FiCdEventoEVEN>();
	
	public TicketTO() {
		DataTableTO dataTable = new DataTableTO("fiCdEventoEVEN.evenDsTitulo", "tickDsDescricao", "tickNrValor", "tickNrDisponivel");
		dataTable.setHeader("Evento", "Descricao", "Valor", "Qtd Disponivel");
		setResultTable(dataTable);
		setEntity(new FiCdTicketTICK());
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<FiCdEventoEVEN> getListEventos() {
		return listEventos;
	}

	public void setListEventos(List<FiCdEventoEVEN> listEventos) {
		this.listEventos = listEventos;
	}

}
