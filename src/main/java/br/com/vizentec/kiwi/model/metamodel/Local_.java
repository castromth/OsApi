package br.com.vizentec.kiwi.model.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.vizentec.kiwi.model.Local;

@StaticMetamodel(Local.class)
public class Local_ {
	public static volatile SingularAttribute<Local, Long> id;
	public static volatile SingularAttribute<Local, String> local;

}
