package br.com.vizentec.kiwi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.vizentec.kiwi.model.Os;
import br.com.vizentec.kiwi.model.OsStatus;
import br.com.vizentec.kiwi.repository.OsRepository;

public class AttOsForm {
	
	@NotNull @NotEmpty
	private String condChegada;
	@NotNull @NotEmpty
	private String condSaida;
	@NotNull @NotEmpty
	private String acoesTomadas;
	@NotNull @NotEmpty
	private OsStatus status;
	
	public void setCondChegada(String condchegada) {
		this.condChegada = condchegada;
	}
	public String getCondChegada() {
		return this.condChegada;
	}
	
	public void setCondSaida(String condSaida) {
		this.condSaida = condSaida;
	}
	
	public String getCondSaida() {
		return this.condSaida;
	}
	
	public String getAcoesTomadas() {
		return this.acoesTomadas;
	}
	
	public void setAcoesTomadas(String acoesTomadas) {
		this.acoesTomadas = acoesTomadas;
	}
	
	public void setStatus(OsStatus status) {
		this.status = status;
	}
	public OsStatus getStatus() {
		return this.status;
	}
	
	public Os atualiza(Long id,OsRepository repo) {
		Os os = repo.getOne(id);
		os.setAcoesTomadas(this.acoesTomadas);
		os.setCondChegada(this.condChegada);
		os.setCondSaida(this.condSaida);
		os.setStatus(this.status);
		return os;
	}

}
