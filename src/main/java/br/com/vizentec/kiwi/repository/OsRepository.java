package br.com.vizentec.kiwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.vizentec.kiwi.model.Os;

public interface OsRepository extends JpaRepository<Os, Long>, JpaSpecificationExecutor<Os> {
	
	
	

}
