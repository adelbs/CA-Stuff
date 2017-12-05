package obi1.fi.business.to;

import obi1.fi.business.entity.FiCdUsuarioUSUA;
import obi1.fi.common.to.DataTableTO;

public final class UsuarioTO extends AbstractTO<FiCdUsuarioUSUA> {

	private String nomeUsua;
	
	private String login;
	
	public UsuarioTO() {
		DataTableTO dataTable = new DataTableTO("usuaDsNome", "usuaDsLogin");
		dataTable.setHeader("Nome", "Login");
		setResultTable(dataTable);
		setEntity(new FiCdUsuarioUSUA());
	}

	public String getNomeUsua() {
		return nomeUsua;
	}

	public void setNomeUsua(String nomeUsua) {
		this.nomeUsua = nomeUsua;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
