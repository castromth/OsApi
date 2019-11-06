package br.com.vizentec.kiwi.model.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.vizentec.kiwi.model.Equipamento;
import br.com.vizentec.kiwi.model.Local;

@StaticMetamodel(Equipamento.class)
public class Equipamento_ {
	
	public static volatile SingularAttribute<Equipamento, Long> id;
	public static volatile SingularAttribute<Equipamento, Local> local;
	




}
