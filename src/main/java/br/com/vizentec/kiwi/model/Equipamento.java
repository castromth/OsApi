package br.com.vizentec.kiwi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Equipamento")
public class Equipamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Local local;
	
	
	
	
	
	public Long getId() {
		return this.id;
	}
	public Local getLocal() {
		
		
		return this.local;
		
	}

}
