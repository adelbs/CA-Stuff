package obi1.fi.business.to;

import obi1.fi.business.entity.FiCdEventoEVEN;
import obi1.fi.common.to.DataTableTO;

public final class EventoTO extends AbstractTO<FiCdEventoEVEN> {

	private Integer idEvento;
	
	private String titulo;
	
	private String local;

	private String tpEvento;
	
	public EventoTO() {
		DataTableTO dataTable = new DataTableTO("evenCdTipo", "evenDsTitulo", "evenDhEvento", "evenDsLocal");
		dataTable.setHeader("Tipo", "Titulo", "Data", "Local");
		setResultTable(dataTable);
		setEntity(new FiCdEventoEVEN());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTpEvento() {
		return tpEvento;
	}

	public void setTpEvento(String tpEvento) {
		this.tpEvento = tpEvento;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

}
