package obi1.fi.business.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import obi1.fi.business.entity.FiNgCompraCOMP;
import obi1.fi.common.exception.FiException;

@Repository
@Transactional
public class CompraServiceImpl extends AbstractService implements CompraService {

	@SuppressWarnings("unchecked")
	@Override
	public FiNgCompraCOMP[] findAll(Integer idCliente) {
		StringBuffer sql = new StringBuffer();
		List<FiNgCompraCOMP> resultList = null;
		
		try {
			sql.append("from FiNgCompraCOMP COMP ").
				append("where COMP.fiCdClienteCLIE.id=:idCliente ");
			
			Query dataQuery = getEM().createQuery(sql.toString());
			dataQuery.setParameter("idCliente", idCliente);
				
			resultList = dataQuery.getResultList();
		}
		catch (Exception x) {
			throw new FiException(x, "Erro ao tentar localizar o Usuario");
		}
		
		return resultList.toArray(new FiNgCompraCOMP[0]);
	}
	
}
