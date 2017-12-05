package obi1.fi.business.service;

import java.util.List;

import obi1.fi.business.entity.FiCdClienteCLIE;
import obi1.fi.business.to.ClienteTO;

public interface ClienteService {

	ClienteTO findFiCdClienteCLIE(String usuaDsLogin, String usuaDsPwd);

	void save(ClienteTO clienteTO);

	void fillTO(ClienteTO clienteTO);
	
	List<FiCdClienteCLIE> getListEntityAtivos();
	
	void fillDataQueryBaseTO(ClienteTO clienteTO);
	
}
