package br.com.vizentec.kiwi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vizentec.kiwi.model.Os;

public class OsDto {
	
	private Long id;
	private String condChegada;
	private String condSaida;
	private String acoesTomadas;
	private String equipLocal;
	private String equipId;
	private String contrato;
	private String status;
	private String solicitante;
	private String responsavel;
	private String dataLimite;
	private String dataCriancao;
	
	
	public OsDto (Os os) {
		this.condChegada = os.getCondChegada();
		this.condSaida = os.getCondSaida();
		this.acoesTomadas = os.getAcoesTomadas();
		this.equipLocal = os.getEquipamento().getLocal().toString();
		this.equipId = os.getEquipamento().getId().toString();
		this.contrato = os.getContrato().name();
		this.status = os.getStatus().name();
		this.solicitante = os.getSolicitante().getName();
		this.responsavel = os.getResponsavel().getName();
		this.dataLimite = os.getDataLimite().toString();
		this.dataCriancao = os.getAbertOs().toString();
		
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCondChegada() {
		return condChegada;
	}


	public void setCondChegada(String condChegada) {
		this.condChegada = condChegada;
	}


	public String getCondSaida() {
		return condSaida;
	}


	public void setCondSaida(String condSaida) {
		this.condSaida = condSaida;
	}


	public String getAcoesTomadas() {
		return acoesTomadas;
	}


	public void setAcoesTomadas(String acoesTomadas) {
		this.acoesTomadas = acoesTomadas;
	}


	public String getEquipLocal() {
		return equipLocal;
	}


	public void setEquipLocal(String equipLocal) {
		this.equipLocal = equipLocal;
	}


	public String getEquipId() {
		return equipId;
	}


	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}


	public String getContrato() {
		return contrato;
	}


	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSolicitante() {
		return solicitante;
	}


	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getDataLimite() {
		return dataLimite;
	}


	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}


	public String getDataCriancao() {
		return dataCriancao;
	}


	public void setDataCriancao(String dataCriancao) {
		this.dataCriancao = dataCriancao;
	}
	
	public static List<OsDto> converter(List<Os> oss){
		
		return oss.stream().map(OsDto::new).collect(Collectors.toList());
	}
}
