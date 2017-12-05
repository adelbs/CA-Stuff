package obi1.fi.business.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import obi1.fi.business.entity.FiCdClienteCLIE;
import obi1.fi.business.exception.FiBusinessException;
import obi1.fi.business.to.ClienteTO;
import obi1.fi.common.exception.FiException;
import obi1.fi.common.util.Encrypt;

@Repository
@Transactional
public final class ClienteServiceImpl extends AbstractService implements ClienteService {

	@Autowired
	private GenericService gService;

	@Override
	public void fillTO(ClienteTO clienteTO) {
		StringBuffer sql = new StringBuffer();
		FiCdClienteCLIE fiCdClienteCLIE = new FiCdClienteCLIE();
		
		try {
			if (clienteTO.getEntity().getId() > 0) {
				sql.append("from FiCdClienteCLIE CLIE ").
					append("where CLIE.idClieCdCliente=:idCliente");
				Query dataQuery = getEM().createQuery(sql.toString());
				dataQuery.setParameter("idCliente", clienteTO.getEntity().getId());
				
				fiCdClienteCLIE = (FiCdClienteCLIE) dataQuery.getSingleResult();
			}
			
			clienteTO.setEntity(fiCdClienteCLIE);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
	}
	
	@Override
	public ClienteTO findFiCdClienteCLIE(String clieDsLogin, String clieDsPwd) {
		
		StringBuffer sql;
		Query dataQuery;
		ClienteTO resultClienteTO = null;
		
		try {
			//Recuperando o usuario
			sql = new StringBuffer();
			sql.append("select CLIE from FiCdClienteCLIE CLIE ").
				append("where CLIE.clieDsLogin=:clieDsLogin and CLIE.clieDsPwd=:clieDsPwd ");
			
			dataQuery = getEM().createQuery(sql.toString());
			dataQuery.setParameter("clieDsLogin", clieDsLogin);
			dataQuery.setParameter("clieDsPwd", Encrypt.encrypt(clieDsLogin.toUpperCase(), clieDsPwd.toUpperCase()));
			
			FiCdClienteCLIE fiCdClienteCLIE = (FiCdClienteCLIE) dataQuery.getSingleResult();
			
			resultClienteTO = new ClienteTO();
			resultClienteTO.setEntity(fiCdClienteCLIE);
		}
		catch (NoResultException nre) {			
			
			throw new FiBusinessException(nre, "Senha incorreta");
		}
		catch (Exception x) {		
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
			
		return resultClienteTO;
	}

	@Override
	public void save(ClienteTO clienteTO) {
		
		FiCdClienteCLIE clieEntity;
		Integer idCliente = clienteTO.getEntity().getId();

		try {
			
			if ((idCliente != null && idCliente > 0) || (idCliente != null && idCliente == -1)) {
				clieEntity = getEM().find(FiCdClienteCLIE.class, idCliente);
			}
			else {
				clieEntity = new FiCdClienteCLIE();
				idCliente = gService.getNextId(clieEntity);
			}
			
			PropertyUtils.copyProperties(clieEntity, clienteTO.getEntity());

			//Salvando  usuario
			clieEntity.setId(idCliente);
			clieEntity.setClieDsPwd(Encrypt.encrypt(clieEntity.getClieDsNome().toUpperCase(), clieEntity.getClieDsPwd().toUpperCase()));
			getEM().merge(clieEntity);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro salvando usuario " + x.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FiCdClienteCLIE> getListEntityAtivos() {

		StringBuffer sql = new StringBuffer();
		List<FiCdClienteCLIE> result;

		try {
			sql.append(" from FiCdClienteCLIE CLIE ");
			Query query = getEM().createQuery(sql.toString());
			result = query.getResultList();
		} 
		catch (Exception x) {
			throw new FiException(x, "Erro ao buscar lista de clientes!");
		}

		return result;
	}
	
	@Override
	public void fillDataQueryBaseTO(ClienteTO clienteTO) {
		
		try {
			List<String> criteriaList = new ArrayList<String>();
			Map<String, Object> queryParameterMap = new HashMap<String, Object>();
			
			//Construindo a clausula where com os filtros de tela
			StringBuilder whereCondition = new StringBuilder("where CLIE.idClieCdCliente > -1 ");
			setCriteriasQueryParameters(clienteTO, criteriaList, queryParameterMap);
			appendSqlCriterias(whereCondition, criteriaList);

			StringBuffer sql = new StringBuffer("select CLIE from FiCdClienteCLIE CLIE ").append(whereCondition);
			StringBuffer sqlCount = new StringBuffer("select count(*) from FiCdClienteCLIE CLIE ").append(whereCondition);
			
			Query query = getEM().createQuery(sql.toString());
			setSqlParameters(queryParameterMap, query);
			
			Query queryCount = getEM().createQuery(sqlCount.toString());
			setSqlParameters(queryParameterMap, queryCount);
		
			fillPaginateTO(clienteTO, query, queryCount, 10);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao executar a consulta");
		}
		
	}
	
	private void setCriteriasQueryParameters(ClienteTO clienteTO, List<String> criteriaList, Map<String, Object> parameterMap) throws ParseException {
		
		if (!StringUtils.isEmpty(clienteTO.getNome())) {
			criteriaList.add("CLIE.clieDsNome like :nomeCliente");
			parameterMap.put("nomeCliente", clienteTO.getNome() + "%");
		}
		
		//Login
		if (!StringUtils.isEmpty(clienteTO.getLogin())) {
			criteriaList.add("CLIE.clieDsLogin like :login");
			parameterMap.put("login", clienteTO.getLogin() + "%");
		}
		
	}

}
