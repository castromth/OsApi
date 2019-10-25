package br.com.vizentec.kiwi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Local")
public class Local {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	
	
	
	
	public String toString() {
		return "";
	}
}
