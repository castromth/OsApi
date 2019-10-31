package br.com.vizentec.kiwi.repository.specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.vizentec.kiwi.controller.search.OsSearch;
import br.com.vizentec.kiwi.model.Contrato;
import br.com.vizentec.kiwi.model.Equipamento;
import br.com.vizentec.kiwi.model.Local;
import br.com.vizentec.kiwi.model.Os;
import br.com.vizentec.kiwi.model.OsStatus;
import br.com.vizentec.kiwi.model.User;
import br.com.vizentec.kiwi.model.metamodel.Equipamento_;
import br.com.vizentec.kiwi.model.metamodel.Os_;


public class OsSpecification implements Specification<Os> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7856867290749800819L;
	private OsSearch critera;
	
	
	public OsSpecification(OsSearch osSearch) {
		critera = osSearch;
	}


	@Override
	public Predicate toPredicate(Root<Os> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		Path<Long> osName = root.get(Os_.id);
		Path<Contrato> osContrato = root.get(Os_.contrato);
		Path<User> responsavel = root.get(Os_.responsavel);
		Path<Date> data = root.get(Os_.dataLimite);
		Path<Equipamento> equipamento = root.get(Os_.equipemanto);
		Path<Local> local = equipamento.get(Equipamento_.local);
		Path<OsStatus> status = root.get(Os_.status);
		Path<String> origem = root.get(Os_.origem);
		
		final List<Predicate> predicates = new ArrayList<Predicate>();
		if(critera.getOsName() != null)
			predicates.add(cb.equal(osName,critera.getOsName()));
		if(critera.getOrigem() != null)
			predicates.add(cb.equal(origem, critera.getOrigem()));
		if(critera.getStatus() != null)
			predicates.add(cb.equal(status, critera.getStatus()));
		if(critera.getLocal() != null)
			predicates.add(cb.equal(local, critera.getLocal()));
		if(critera.getDataI() != null && critera.getDataF() != null)
		    predicates.add(cb.between(data, critera.getDataI(), critera.getDataF()));
//		if(critera.getContratos() != null)
//			predicates.add(cb.isMember(osContrato));
		
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}



}
