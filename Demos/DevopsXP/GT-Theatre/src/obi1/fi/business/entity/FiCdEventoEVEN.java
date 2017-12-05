package obi1.fi.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FI_CD_EVENTO_EVEN")
public class FiCdEventoEVEN extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_EVEN_CD_EVENTO", unique = true, nullable = false)
	private Integer idEvenCdEvento;

	@Column(name = "EVEN_CD_TIPO", length = 50)
	private String evenCdTipo;

	@Column(name = "EVEN_DS_TITULO", length = 50)
	private String evenDsTitulo;
	
	@Column(name = "EVEN_DS_DESCRICAO", length = 255)
	private String evenDsDescricao;
	
	@Column(name = "EVEN_DH_EVENTO", length = 50)
	private String evenDhEvento;
	
	@Column(name = "EVEN_DS_LOCAL", length = 50)
	private String evenDsLocal;
	
	public FiCdEventoEVEN() { }
	
	@Override
	public Class<FiCdEventoEVEN> getEntityClass() {
		return FiCdEventoEVEN.class;
	}

	@Override
	public Integer getId() {
		return getIdEvenCdEvento();
	}

	@Override
	public void setId(Integer id) {
		setIdEvenCdEvento(id);
	}

	public Integer getIdEvenCdEvento() {
		return idEvenCdEvento;
	}

	public void setIdEvenCdEvento(Integer idEvenCdEvento) {
		this.idEvenCdEvento = idEvenCdEvento;
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

	public String getEvenCdTipo() {
		return evenCdTipo;
	}

	public void setEvenCdTipo(String evenCdTipo) {
		this.evenCdTipo = evenCdTipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
