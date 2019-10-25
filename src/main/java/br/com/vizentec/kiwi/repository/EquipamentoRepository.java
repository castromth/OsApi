package br.com.vizentec.kiwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vizentec.kiwi.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
	

}
