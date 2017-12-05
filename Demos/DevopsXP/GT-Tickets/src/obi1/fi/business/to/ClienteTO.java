package obi1.fi.business.to;

import obi1.fi.business.entity.FiCdClienteCLIE;
import obi1.fi.common.to.DataTableTO;

public final class ClienteTO extends AbstractTO<FiCdClienteCLIE> {

	private String nome;
	
	private String login;
	
	public ClienteTO() {
		setResultTable(new DataTableTO("clieDsNome", "clieDsTelefone", "clieDsEmail")); 
		setEntity(new FiCdClienteCLIE());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
