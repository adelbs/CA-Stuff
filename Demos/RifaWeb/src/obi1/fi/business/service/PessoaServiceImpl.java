package obi1.fi.business.service;

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

import obi1.fi.business.entity.FiCdPessoaPESS;
import obi1.fi.business.to.PessoaTO;
import obi1.fi.common.exception.FiException;

@Repository
@Transactional
public final class PessoaServiceImpl extends AbstractService implements PessoaService {

	@Autowired
	private GenericService gService;

	@Override
	public void fillTO(PessoaTO pessoaTO) {
		StringBuffer sql = new StringBuffer();
		FiCdPessoaPESS fiCdPessoaPESS = new FiCdPessoaPESS();
		
		try {
			if (pessoaTO.getEntity().getId() != null && pessoaTO.getEntity().getId() > 0) {
				sql.append("from FiCdPessoaPESS PESS ").
					append("where PESS.idPessCdPessoa=:idPessoa");
				Query dataQuery = getEM().createQuery(sql.toString());
				dataQuery.setParameter("idPessoa", pessoaTO.getEntity().getId());
				
				fiCdPessoaPESS = (FiCdPessoaPESS) dataQuery.getSingleResult();
			}
			
			pessoaTO.setEntity(fiCdPessoaPESS);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o cadastro");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PessoaTO findFiCdPessoaPESS(String pessDsEmail) {
		
		StringBuffer sql;
		Query dataQuery;
		List<FiCdPessoaPESS> resultList;
		PessoaTO resultPessoaTO = null;
		
		try {
			//Recuperando o usuário
			sql = new StringBuffer();
			sql.append("from FiCdPessoaPESS ").
				append("where pessDsEmail = :pessDsEmail");
			
			dataQuery = getEM().createQuery(sql.toString());
			dataQuery.setParameter("pessDsEmail", pessDsEmail.toUpperCase());
			
			resultList = dataQuery.getResultList();
			
			resultPessoaTO = new PessoaTO();
			resultPessoaTO.setQty(resultList.size());
			if (resultList.size() > 0)
				resultPessoaTO.setEntity(resultList.get(0));
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o cadastro");
		}
			
		return resultPessoaTO;
	}

	@Override
	public void save(PessoaTO pessoaTO) {
		
		FiCdPessoaPESS pessEntity;
		Integer idPessoa = pessoaTO.getEntity().getId();

		try {
			
			if ((idPessoa != null && idPessoa > 0) || (idPessoa != null && idPessoa == -1)) {
				pessEntity = getEM().find(FiCdPessoaPESS.class, idPessoa);
			}
			else {
				if (findFiCdPessoaPESS(pessoaTO.getEntity().getPessDsEmail()).getQty().intValue() > 0)
					throw new FiException("Pessoa ja cadastrada. Tente novamente.");
				
				pessEntity = new FiCdPessoaPESS();
				idPessoa = gService.getNextId(pessEntity);
			}
			
			PropertyUtils.copyProperties(pessEntity, pessoaTO.getEntity());

			//Salvando  usuário
			pessEntity.setId(idPessoa);
			pessEntity.setPessDsEmail(pessEntity.getPessDsEmail().toUpperCase());
			pessEntity.setPessDsEmpresa(pessEntity.getPessDsEmpresa().toUpperCase());
			pessEntity.setPessDsNome(pessEntity.getPessDsNome().toUpperCase());
			pessEntity.setPessDsTelefone(pessEntity.getPessDsTelefone().toUpperCase());
			getEM().merge(pessEntity);
		}
		catch (Exception x) {
			throw new FiException(x, x.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public FiCdPessoaPESS getWinner() {

		StringBuffer sql = new StringBuffer();
		List<FiCdPessoaPESS> result;
		FiCdPessoaPESS winner;
		
		try {
			sql.append(" from FiCdPessoaPESS PESS ");
			Query query = getEM().createQuery(sql.toString());
			result = query.getResultList();
			
			double number = Math.random() * result.size();
			winner = result.get(new Double(number).intValue());
			
		} 
		catch (Exception x) {
			throw new FiException(x, "Erro ao buscar lista de cadastros!");
		}

		return winner;
	}

	@Override
	public void delete(PessoaTO baseTO) {
		try {
			FiCdPessoaPESS entity = getEM().find(baseTO.getEntity().getEntityClass(), baseTO.getEntity().getId());
			getEM().remove(entity);
		}
		catch (Exception x) {
			throw new FiException(x, "Erro excluindo "
					+ ((baseTO == null) ? "(null)" : baseTO.getClass().toString()));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fillDataQueryBaseTO(PessoaTO pessoaTO) {
		
		try {
			List<String> criteriaList = new ArrayList<String>();
			Map<String, Object> queryParameterMap = new HashMap<String, Object>();
			
			//Construindo a clausula where com os filtros de tela
			StringBuilder whereCondition = new StringBuilder("where PESS.idPessCdPessoa > -1 ");
			
			if (!StringUtils.isEmpty(pessoaTO.getPessDsNome())) {
				criteriaList.add("PESS.pessDsNome like :pessDsNome");
				queryParameterMap.put("pessDsNome", pessoaTO.getPessDsNome().toUpperCase() + "%");
			}
			
			if (!StringUtils.isEmpty(pessoaTO.getPessDsEmail())) {
				criteriaList.add("PESS.pessDsEmail like :pessDsEmail");
				queryParameterMap.put("pessDsEmail", pessoaTO.getPessDsEmail().toUpperCase() + "%");
			}
			
			if (!StringUtils.isEmpty(pessoaTO.getPessDsEmpresa())) {
				criteriaList.add("PESS.pessDsEmpresa like :pessDsEmpresa");
				queryParameterMap.put("pessDsEmpresa", pessoaTO.getPessDsEmpresa().toUpperCase() + "%");
			}

			
			appendSqlCriterias(whereCondition, criteriaList);

			StringBuffer sql = new StringBuffer("from FiCdPessoaPESS PESS ").append(whereCondition);
			
			Query query = getEM().createQuery(sql.toString());
			setSqlParameters(queryParameterMap, query);
			
			pessoaTO.getResultTable().setValues(query.getResultList());
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao executar a consulta");
		}
	}
}
