package br.com.vizentec.kiwi.model.metamodel;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.vizentec.kiwi.model.Contrato;
import br.com.vizentec.kiwi.model.Equipamento;
import br.com.vizentec.kiwi.model.Os;
import br.com.vizentec.kiwi.model.OsStatus;
import br.com.vizentec.kiwi.model.Peca;
import br.com.vizentec.kiwi.model.User;

@StaticMetamodel(Os.class)
public class Os_ {
	public static volatile SingularAttribute<Os, Long> id;
	public static volatile SingularAttribute<Os, Equipamento> equipemanto;
	public static volatile SingularAttribute<Os, String> condChegada;
	public static volatile SingularAttribute<Os, String> condSaida;
	public static volatile SingularAttribute<Os, List<Peca>> pecas;
	public static volatile SingularAttribute<Os, OsStatus> status;
	public static volatile SingularAttribute<Os, LocalDateTime> abertOs;
	public static volatile SingularAttribute<Os, String> origem;
	public static volatile SingularAttribute<Os, Date> dataLimite;
	public static volatile SingularAttribute<Os, Contrato> contrato;
	public static volatile SingularAttribute<Os, User> responsavel;
	public static volatile SingularAttribute<Os, User> solicitante;
	public static volatile SingularAttribute<Os, String> tempoDeTrabalho;
}
