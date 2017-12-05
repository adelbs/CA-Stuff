package obi1.fi.business.service;

import obi1.fi.business.entity.FiNgCompraCOMP;

public interface CompraService {

	FiNgCompraCOMP[] findAll(Integer idCliente);
	
}
