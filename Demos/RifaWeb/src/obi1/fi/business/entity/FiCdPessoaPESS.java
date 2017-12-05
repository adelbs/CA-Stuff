package obi1.fi.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FI_CD_PESSOA_PESS")
public class FiCdPessoaPESS extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_PESS_CD_PESSOA", unique = true, nullable = false)
	private Integer idPessCdPessoa;	

	@Column(name = "PESS_DS_NOME", length = 150)
	private String pessDsNome;

	@Column(name = "PESS_DS_TELEFONE", length = 50)
	private String pessDsTelefone;

	@Column(name = "PESS_DS_EMAIL", length = 150)
	private String pessDsEmail;

	@Column(name = "PESS_DS_EMPRESA", length = 150)
	private String pessDsEmpresa;

	@Column(name = "PESS_IN_SORTEADO", length = 1)
	private String pessInSorteado;

	public FiCdPessoaPESS() { }
	
	@Override
	public Class<FiCdPessoaPESS> getEntityClass() {
		return FiCdPessoaPESS.class;
	}

	@Override
	public Integer getId() {
		return getIdPessCdPessoa();
	}

	@Override
	public void setId(Integer id) {
		setIdPessCdPessoa(id);
	}

	public Integer getIdPessCdPessoa() {
		return idPessCdPessoa;
	}

	public void setIdPessCdPessoa(Integer idPessCdPessoa) {
		this.idPessCdPessoa = idPessCdPessoa;
	}

	public String getPessDsNome() {
		return pessDsNome;
	}

	public void setPessDsNome(String pessDsNome) {
		this.pessDsNome = pessDsNome;
	}

	public String getPessDsTelefone() {
		return pessDsTelefone;
	}

	public void setPessDsTelefone(String pessDsTelefone) {
		this.pessDsTelefone = pessDsTelefone;
	}

	public String getPessDsEmail() {
		return pessDsEmail;
	}

	public void setPessDsEmail(String pessDsEmail) {
		this.pessDsEmail = pessDsEmail;
	}

	public String getPessDsEmpresa() {
		return pessDsEmpresa;
	}

	public void setPessDsEmpresa(String pessDsEmpresa) {
		this.pessDsEmpresa = pessDsEmpresa;
	}

	public String getPessInSorteado() {
		return pessInSorteado;
	}

	public void setPessInSorteado(String pessInSorteado) {
		this.pessInSorteado = pessInSorteado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
