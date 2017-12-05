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

import obi1.fi.business.entity.FiCdUsuarioUSUA;
import obi1.fi.business.exception.FiBusinessException;
import obi1.fi.business.to.UsuarioTO;
import obi1.fi.common.exception.FiException;
import obi1.fi.common.util.Encrypt;

@Repository
@Transactional
public final class UsuarioServiceImpl extends AbstractService implements UsuarioService {

	@Autowired
	private GenericService gService;

	@Override
	public void fillTO(UsuarioTO usuarioTO) {
		StringBuffer sql = new StringBuffer();
		FiCdUsuarioUSUA fiCdUsuarioUSUA = new FiCdUsuarioUSUA();
		
		try {
			if (usuarioTO.getEntity().getId() > 0) {
				sql.append("from FiCdUsuarioUSUA USUA ").
					append("where USUA.idUsuaCdUsuario=:idUsuario");
				Query dataQuery = getEM().createQuery(sql.toString());
				dataQuery.setParameter("idUsuario", usuarioTO.getEntity().getId());
				
				fiCdUsuarioUSUA = (FiCdUsuarioUSUA) dataQuery.getSingleResult();
			}
			
			usuarioTO.setEntity(fiCdUsuarioUSUA);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
	}
	
	@Override
	public UsuarioTO findFiCdUsuarioUSUA(String usuaDsLogin, String usuaDsPwd) {
		
		StringBuffer sql;
		Query dataQuery;
		UsuarioTO resultUsuarioTO = null;
		
		try {
			//Recuperando o usuario
			sql = new StringBuffer();
			sql.append("select USUA from FiCdUsuarioUSUA USUA ").
				append("where USUA.usuaDsLogin=:usuaDsLogin and USUA.usuaDsPwd=:usuaDsPwd ");
			
			dataQuery = getEM().createQuery(sql.toString());
			dataQuery.setParameter("usuaDsLogin", usuaDsLogin);
			dataQuery.setParameter("usuaDsPwd", Encrypt.encrypt(usuaDsLogin, usuaDsPwd));
			
			FiCdUsuarioUSUA fiCdUsuarioUSUA = (FiCdUsuarioUSUA) dataQuery.getSingleResult();
			
			resultUsuarioTO = new UsuarioTO();
			resultUsuarioTO.setEntity(fiCdUsuarioUSUA);
		}
		catch (NoResultException nre) {			
			
			throw new FiBusinessException(nre, "Senha incorreta");
		}
		catch (Exception x) {		
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
			
		return resultUsuarioTO;
	}

	@Override
	public void save(UsuarioTO usuarioTO) {
		
		FiCdUsuarioUSUA usuaEntity;
		Integer idUsuario = usuarioTO.getEntity().getId();

		try {
			
			if ((idUsuario != null && idUsuario > 0) || (idUsuario != null && idUsuario == -1)) {
				usuaEntity = getEM().find(FiCdUsuarioUSUA.class, idUsuario);
			}
			else {
				usuaEntity = new FiCdUsuarioUSUA();
				idUsuario = gService.getNextId(usuaEntity);
			}
			
			PropertyUtils.copyProperties(usuaEntity, usuarioTO.getEntity());

			//Salvando  usuario
			usuaEntity.setId(idUsuario);
			getEM().merge(usuaEntity);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro salvando usuario " + x.getMessage());
		}

	}
	
	@Override
	public void fillDataQueryBaseTO(UsuarioTO usuarioTO) {
		
		try {
			List<String> criteriaList = new ArrayList<String>();
			Map<String, Object> queryParameterMap = new HashMap<String, Object>();
			
			//Construindo a clausula where com os filtros de tela
			StringBuilder whereCondition = new StringBuilder("where USUA.idUsuaCdUsuario > -1 ");
			setCriteriasQueryParameters(usuarioTO, criteriaList, queryParameterMap);
			appendSqlCriterias(whereCondition, criteriaList);

			StringBuffer sql = new StringBuffer("select USUA from FiCdUsuarioUSUA USUA ").append(whereCondition);
			StringBuffer sqlCount = new StringBuffer("select count(*) from FiCdUsuarioUSUA USUA ").append(whereCondition);
			
			Query query = getEM().createQuery(sql.toString());
			setSqlParameters(queryParameterMap, query);
			
			Query queryCount = getEM().createQuery(sqlCount.toString());
			setSqlParameters(queryParameterMap, queryCount);
		
			fillPaginateTO(usuarioTO, query, queryCount, 10);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao executar a consulta");
		}
		
	}
	
	private void setCriteriasQueryParameters(UsuarioTO usuarioTO, List<String> criteriaList, Map<String, Object> parameterMap) throws ParseException {
		
		//Nome do usuario
		if (!StringUtils.isEmpty(usuarioTO.getNomeUsua())) {
			criteriaList.add("USUA.usuaDsNome like :nomeUsuario");
			parameterMap.put("nomeUsuario", usuarioTO.getNomeUsua() + "%");
		}
		
		//Login
		if (!StringUtils.isEmpty(usuarioTO.getLogin())) {
			criteriaList.add("USUA.usuaDsLogin like :login");
			parameterMap.put("login", usuarioTO.getLogin() + "%");
		}
		
	}
}
