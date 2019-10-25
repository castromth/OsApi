package br.com.vizentec.kiwi.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.vizentec.kiwi.model.Os;
import br.com.vizentec.kiwi.repository.EquipamentoRepository;

public class OsForm {
	
	@NotNull @NotEmpty
	private String origem;
	@NotNull @NotEmpty
	private String sumario;
	@NotNull @NotEmpty
	private String descricao;
	@NotNull @NotEmpty
	private String contrato;
	@NotNull @NotEmpty
	private String responsavel;
	@NotNull @NotEmpty
	private String local;
	@NotNull @NotEmpty
	private String equiId;
	private String dataLimite;
	
	
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEquiId() {
		return equiId;
	}
	public void setEquiId(String equiId) {
		this.equiId = equiId;
	}
	public String getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	
	public static Os converter(@RequestBody OsForm form, EquipamentoRepository equiRepo) {
		Os os = OsForm.converter(form, equiRepo);
		return os;
	}

}
