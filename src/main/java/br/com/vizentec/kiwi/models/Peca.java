package br.com.vizentec.kiwi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Peca {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
