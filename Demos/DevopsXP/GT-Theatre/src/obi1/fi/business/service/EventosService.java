package obi1.fi.business.service;

import java.util.List;

import obi1.fi.business.entity.FiCdEventoEVEN;
import obi1.fi.business.to.EventoTO;

public interface EventosService {

	void save(EventoTO eventoTO);

	void fillTO(EventoTO eventoTO);
	
	void fillDataQueryBaseTO(EventoTO eventoTO);

	List<FiCdEventoEVEN> findAll();
	
}
