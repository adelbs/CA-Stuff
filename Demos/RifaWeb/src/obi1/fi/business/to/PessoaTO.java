package obi1.fi.business.to;

import obi1.fi.business.entity.FiCdPessoaPESS;
import obi1.fi.common.to.DataTableTO;

public final class PessoaTO extends AbstractTO<FiCdPessoaPESS> {

	//Atributos para utilização do filtro
	private String pessDsNome;

	private String pessDsEmail;

	private String pessDsEmpresa;
	
	private String message;
	
	private Integer qty;
	
	private static int errorFase = 0;
	
	public PessoaTO() {
		setResultTable(new DataTableTO("pessDsNome", "pessDsTelefone", "pessDsEmail", "pessDsEmpresa")); 
		setEntity(new FiCdPessoaPESS());
	}

	public String getPessDsNome() {
		return pessDsNome;
	}

	public void setPessDsNome(String pessDsNome) {
		this.pessDsNome = pessDsNome;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public static int getErrorFase() {
		return errorFase;
	}

	public static void setErrorFase(int errorFase) {
		PessoaTO.errorFase = errorFase;
	}

}
