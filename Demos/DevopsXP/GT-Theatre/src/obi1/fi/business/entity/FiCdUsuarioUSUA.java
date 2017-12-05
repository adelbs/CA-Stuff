package obi1.fi.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FI_CD_USUARIO_USUA")
public class FiCdUsuarioUSUA extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_USUA_CD_USUARIO", unique = true, nullable = false)
	private Integer idUsuaCdUsuario;	

	@Column(name = "USUA_DS_NOME", length = 50)
	private String usuaDsNome;

	@Column(name = "USUA_DS_LOGIN", unique = true, length = 10)
	private String usuaDsLogin;

	@Column(name = "USUA_DS_PWD", length = 100)
	private String usuaDsPwd;
	
	public FiCdUsuarioUSUA() { }
	
	public FiCdUsuarioUSUA(Integer idUsuaCdUsuario, String usuaDsNome, String usuaDsLogin, String usuaDsPwd) {
		this.idUsuaCdUsuario = idUsuaCdUsuario;
		this.usuaDsNome = usuaDsNome;
		this.usuaDsLogin = usuaDsLogin;
		this.usuaDsPwd = usuaDsPwd;
	}
	
	@Override
	public Class<FiCdUsuarioUSUA> getEntityClass() {
		return FiCdUsuarioUSUA.class;
	}

	@Override
	public Integer getId() {
		return getIdUsuaCdUsuario();
	}

	@Override
	public void setId(Integer id) {
		setIdUsuaCdUsuario(id);
	}
	
	public Integer getIdUsuaCdUsuario() {
		return idUsuaCdUsuario;
	}

	public void setIdUsuaCdUsuario(Integer idUsuaCdUsuario) {
		this.idUsuaCdUsuario = idUsuaCdUsuario;
	}

	public String getUsuaDsNome() {
		return usuaDsNome;
	}

	public void setUsuaDsNome(String usuaDsNome) {
		this.usuaDsNome = usuaDsNome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsuaDsLogin() {
		return usuaDsLogin;
	}

	public void setUsuaDsLogin(String usuaDsLogin) {
		this.usuaDsLogin = usuaDsLogin;
	}

	public String getUsuaDsPwd() {
		return usuaDsPwd;
	}

	public void setUsuaDsPwd(String usuaDsPwd) {
		this.usuaDsPwd = usuaDsPwd;
	}

}
