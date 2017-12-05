package obi1.fi.business.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import obi1.fi.business.entity.FiCdEventoEVEN;
import obi1.fi.business.to.EventoTO;
import obi1.fi.common.exception.FiException;

@Repository
@Transactional
public final class EventosServiceImpl extends AbstractService implements EventosService {

	@Autowired
	private GenericService gService;

	@Override
	public void fillTO(EventoTO eventoTO) {
		StringBuffer sql = new StringBuffer();
		FiCdEventoEVEN fiCdEventoEVEN = new FiCdEventoEVEN();
		
		try {
			if (eventoTO.getEntity().getId() > 0) {
				sql.append("from FiCdEventoEVEN EVEN ").
					append("where EVEN.idEvenCdEvento=:idEvento");
				Query dataQuery = getEM().createQuery(sql.toString());
				dataQuery.setParameter("idEvento", eventoTO.getEntity().getId());
				
				fiCdEventoEVEN = (FiCdEventoEVEN) dataQuery.getSingleResult();
			}
			
			eventoTO.setEntity(fiCdEventoEVEN);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
	}
	
	@Override
	public void save(EventoTO eventoTO) {
		
		FiCdEventoEVEN evenEntity;
		Integer idEvento = eventoTO.getEntity().getId();

		try {
			
			if ((idEvento != null && idEvento > 0) || (idEvento != null && idEvento == -1)) {
				evenEntity = getEM().find(FiCdEventoEVEN.class, idEvento);
			}
			else {
				evenEntity = new FiCdEventoEVEN();
				idEvento = gService.getNextId(evenEntity);
			}
			
			PropertyUtils.copyProperties(evenEntity, eventoTO.getEntity());

			evenEntity.setId(idEvento);
			getEM().merge(evenEntity);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro salvando usuario " + x.getMessage());
		}

	}
	
	@Override
	public void fillDataQueryBaseTO(EventoTO eventoTO) {
		
		try {
			List<String> criteriaList = new ArrayList<String>();
			Map<String, Object> queryParameterMap = new HashMap<String, Object>();
			
			//Construindo a clausula where com os filtros de tela
			StringBuilder whereCondition = new StringBuilder("where EVEN.idEvenCdEvento > -1 ");
			setCriteriasQueryParameters(eventoTO, criteriaList, queryParameterMap);
			appendSqlCriterias(whereCondition, criteriaList);

			StringBuffer sql = new StringBuffer("select EVEN from FiCdEventoEVEN EVEN ").append(whereCondition);
			StringBuffer sqlCount = new StringBuffer("select count(*) from FiCdEventoEVEN EVEN ").append(whereCondition);
			
			Query query = getEM().createQuery(sql.toString());
			setSqlParameters(queryParameterMap, query);
			
			Query queryCount = getEM().createQuery(sqlCount.toString());
			setSqlParameters(queryParameterMap, queryCount);
		
			//PARA DERBY COLOCAR O MAXIMO 1000, PARA MYSQL COLOCAR 10
			fillPaginateTO(eventoTO, query, queryCount, 10);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao executar a consulta");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FiCdEventoEVEN> findAll() {
		
		List<FiCdEventoEVEN> result = null;
		
		try {
			StringBuffer sql = new StringBuffer("select EVEN from FiCdEventoEVEN EVEN ");			
			Query query = getEM().createQuery(sql.toString());
			
			result = query.getResultList();
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao executar a consulta");
		}
		
		return result;
	}
	
	private void setCriteriasQueryParameters(EventoTO eventoTO, List<String> criteriaList, Map<String, Object> parameterMap) throws ParseException {
		
		if (eventoTO.getIdEvento() != null && eventoTO.getIdEvento() > 0) {
			criteriaList.add("EVEN.id = :idEvento");
			parameterMap.put("idEvento", eventoTO.getIdEvento());
		}
		
		if (!StringUtils.isEmpty(eventoTO.getTpEvento())) {
			criteriaList.add("EVEN.evenCdTipo like :tpEvento");
			parameterMap.put("tpEvento", eventoTO.getTpEvento());
		}
		
		if (!StringUtils.isEmpty(eventoTO.getTitulo())) {
			criteriaList.add("EVEN.evenDsTitulo like :titulo");
			parameterMap.put("titulo", "%"+ eventoTO.getTitulo() + "%");
		}
		
		if (!StringUtils.isEmpty(eventoTO.getLocal())) {
			criteriaList.add("EVEN.evenDsLocal like :local");
			parameterMap.put("local", eventoTO.getLocal() + "%");
		}
		
	}

}
