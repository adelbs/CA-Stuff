package obi1.fi.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FI_CD_CLIENTE_CLIE")
public class FiCdClienteCLIE extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CLIE_CD_CLIENTE", unique = true, nullable = false)
	private Integer idClieCdCliente;

	@Column(name = "CLIE_DS_NOME", length = 50)
	private String clieDsNome;

	@Column(name = "CLIE_DS_TELEFONE", length = 50)
	private String clieDsTelefone;

	@Column(name = "CLIE_DS_EMAIL", length = 50)
	private String clieDsEmail;

	@Column(name = "CLIE_DS_NUMCARTAO", length = 50)
	private String clieDsNumcartao;

	@Column(name = "CLIE_TP_CARTAO")
	private Integer clieTpCartao;

	@Column(name = "CLIE_TP_CLIENTE")
	private Integer clieTpCliente;

	@Column(name = "CLIE_DS_LOGIN", unique = true, length = 10)
	private String clieDsLogin;

	@Column(name = "CLIE_DS_PWD", length = 100)
	private String clieDsPwd;
	
	public FiCdClienteCLIE() { }
	
	@Override
	public Class<FiCdClienteCLIE> getEntityClass() {
		return FiCdClienteCLIE.class;
	}

	@Override
	public Integer getId() {
		return getIdClieCdCliente();
	}

	@Override
	public void setId(Integer id) {
		setIdClieCdCliente(id);
	}

	public Integer getIdClieCdCliente() {
		return idClieCdCliente;
	}

	public void setIdClieCdCliente(Integer idClieCdCliente) {
		this.idClieCdCliente = idClieCdCliente;
	}

	public String getClieDsNome() {
		return clieDsNome;
	}

	public void setClieDsNome(String clieDsNome) {
		this.clieDsNome = clieDsNome;
	}

	public String getClieDsTelefone() {
		return clieDsTelefone;
	}

	public void setClieDsTelefone(String clieDsTelefone) {
		this.clieDsTelefone = clieDsTelefone;
	}

	public String getClieDsEmail() {
		return clieDsEmail;
	}

	public void setClieDsEmail(String clieDsEmail) {
		this.clieDsEmail = clieDsEmail;
	}

	public String getClieDsNumcartao() {
		return clieDsNumcartao;
	}

	public void setClieDsNumcartao(String clieDsNumcartao) {
		this.clieDsNumcartao = clieDsNumcartao;
	}

	public String getClieDsLogin() {
		return clieDsLogin;
	}

	public void setClieDsLogin(String clieDsLogin) {
		this.clieDsLogin = clieDsLogin;
	}

	public String getClieDsPwd() {
		return clieDsPwd;
	}

	public void setClieDsPwd(String clieDsPwd) {
		this.clieDsPwd = clieDsPwd;
	}

	public Integer getClieTpCartao() {
		return clieTpCartao;
	}

	public void setClieTpCartao(Integer clieTpCartao) {
		this.clieTpCartao = clieTpCartao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getClieTpCliente() {
		return clieTpCliente;
	}

	public void setClieTpCliente(Integer clieTpCliente) {
		this.clieTpCliente = clieTpCliente;
	}

}
