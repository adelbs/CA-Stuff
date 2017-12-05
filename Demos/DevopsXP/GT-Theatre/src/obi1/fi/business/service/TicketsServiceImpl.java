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

import obi1.fi.business.entity.FiCdTicketTICK;
import obi1.fi.business.to.TicketTO;
import obi1.fi.common.exception.FiException;

@Repository
@Transactional
public final class TicketsServiceImpl extends AbstractService implements TicketsService {

	@Autowired
	private GenericService gService;

	@Override
	public void fillTO(TicketTO ticketTO) {
		StringBuffer sql = new StringBuffer();
		FiCdTicketTICK fiCdTicketTICK = new FiCdTicketTICK();
		
		try {
			if (ticketTO.getEntity().getId() > 0) {
				sql.append("select TICK from FiCdTicketTICK TICK ").
					append("inner join TICK.fiCdEventoEVEN EVEN ").
					append("where TICK.idTickCdTicket=:idTicket");
				Query dataQuery = getEM().createQuery(sql.toString());
				dataQuery.setParameter("idTicket", ticketTO.getEntity().getId());
				
				fiCdTicketTICK = (FiCdTicketTICK) dataQuery.getSingleResult();
			}
			
			ticketTO.setEntity(fiCdTicketTICK);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
	}
	
	@Override
	public void save(TicketTO ticketTO) {
		
		FiCdTicketTICK tickEntity;
		Integer idTicket = ticketTO.getEntity().getId();

		try {
			
			if ((idTicket != null && idTicket > 0) || (idTicket != null && idTicket == -1)) {
				tickEntity = getEM().find(FiCdTicketTICK.class, idTicket);
			}
			else {
				tickEntity = new FiCdTicketTICK();
				idTicket = gService.getNextId(tickEntity);
			}
			
			PropertyUtils.copyProperties(tickEntity, ticketTO.getEntity());

			//Salvando  usuario
			tickEntity.setId(idTicket);
			getEM().merge(tickEntity);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro salvando usuario " + x.getMessage());
		}

	}
	
	@Override
	public void fillDataQueryBaseTO(TicketTO ticketTO) {
		
		try {
			List<String> criteriaList = new ArrayList<String>();
			Map<String, Object> queryParameterMap = new HashMap<String, Object>();
			
			//Construindo a clausula where com os filtros de tela
			StringBuilder whereCondition = new StringBuilder("where TICK.idTickCdTicket > -1 ");
			setCriteriasQueryParameters(ticketTO, criteriaList, queryParameterMap);
			appendSqlCriterias(whereCondition, criteriaList);

			StringBuffer sql = new StringBuffer("select TICK from FiCdTicketTICK TICK inner join TICK.fiCdEventoEVEN EVEN ").append(whereCondition);
			StringBuffer sqlCount = new StringBuffer("select count(*) from FiCdTicketTICK TICK inner join TICK.fiCdEventoEVEN EVEN ").append(whereCondition);
			
			Query query = getEM().createQuery(sql.toString());
			setSqlParameters(queryParameterMap, query);
			
			Query queryCount = getEM().createQuery(sqlCount.toString());
			setSqlParameters(queryParameterMap, queryCount);
		
			//PARA DERBY COLOCAR O MAXIMO 1000, PARA MYSQL COLOCAR 10
			fillPaginateTO(ticketTO, query, queryCount, 10);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao executar a consulta");
		}
		
	}
	
	private void setCriteriasQueryParameters(TicketTO ticketTO, List<String> criteriaList, Map<String, Object> parameterMap) throws ParseException {
		
		if (ticketTO.getIdEvento() != null && ticketTO.getIdEvento() > 0) {
			criteriaList.add("TICK.fiCdEventoEVEN.idEvenCdEvento = :idEvento");
			parameterMap.put("idEvento", ticketTO.getIdEvento());
		}
		
		if (!StringUtils.isEmpty(ticketTO.getDescricao())) {
			criteriaList.add("TICK.tickDsDescricao like :descricao");
			parameterMap.put("descricao", ticketTO.getDescricao() + "%");
		}
		
	}
}
