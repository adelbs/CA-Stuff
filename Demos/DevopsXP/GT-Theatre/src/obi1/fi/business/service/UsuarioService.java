package obi1.fi.business.service;

import obi1.fi.business.to.UsuarioTO;

public interface UsuarioService {

	UsuarioTO findFiCdUsuarioUSUA(String usuaDsLogin, String usuaDsPwd);

	void save(UsuarioTO usuarioTO);

	void fillTO(UsuarioTO usuarioTO);
	
	void fillDataQueryBaseTO(UsuarioTO usuarioTO);
	
}
