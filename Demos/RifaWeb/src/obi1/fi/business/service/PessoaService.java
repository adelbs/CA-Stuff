package obi1.fi.business.service;

import obi1.fi.business.entity.FiCdPessoaPESS;
import obi1.fi.business.to.PessoaTO;

public interface PessoaService {

	PessoaTO findFiCdPessoaPESS(String pessDsEmail);

	void save(PessoaTO pessoaTO);

	void fillTO(PessoaTO pessoaTO);
	
	FiCdPessoaPESS getWinner();
	
	void fillDataQueryBaseTO(PessoaTO pessoaTO);

	void delete(PessoaTO pessoaTO);
	
}
