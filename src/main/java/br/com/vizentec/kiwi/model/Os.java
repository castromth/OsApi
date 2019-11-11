package br.com.vizentec.kiwi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name = "Os")
public class Os {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne
	private Equipamento equipamento;
	private String condChegada = "Sem registro";
	private String acoesTomadas = "Sem registro";
	private String condSaida = "Sem registro";
	@OneToMany
	private List<Peca> pecasUltilizadas = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private OsStatus status = OsStatus.AGUARDANDO_ATENDIMENTO;
	private LocalDateTime abertOs = LocalDateTime.now();
	private String origem;
	private Date dataLimite;
	
	
	

	@Enumerated(EnumType.STRING)
	private Contrato contrato;
	
	@OneToOne
	private Usuario responsavel;
	
	@OneToOne
	private Usuario solicitante;
	private String tempoDeTrabalho;
	
	
	public Os() {}
	
	
	
	public Os(Equipamento equipamento, String origem, Date dataLimite, Contrato contrato, Usuario responsavel,
			Usuario solicitante) {
		this.equipamento = equipamento;
		this.origem = origem;
		this.dataLimite = dataLimite;
		this.contrato = contrato;
		this.responsavel = responsavel;
		this.solicitante = solicitante;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public String getCondChegada() {
		return condChegada;
	}
	public void setCondChegada(String condChegada) {
		this.condChegada = condChegada;
	}
	public String getAcoesTomadas() {
		return acoesTomadas;
	}
	public void setAcoesTomadas(String acoesTomadas) {
		this.acoesTomadas = acoesTomadas;
	}
	public String getCondSaida() {
		return condSaida;
	}
	public void setCondSaida(String condSaida) {
		this.condSaida = condSaida;
	}
	public List<Peca> getPecasUltilizadas() {
		return pecasUltilizadas;
	}
	public void setPecasUltilizadas(List<Peca> pecasUltilizadas) {
		this.pecasUltilizadas = pecasUltilizadas;
	}
	public OsStatus getStatus() {
		return status;
	}
	public void setStatus(OsStatus status) {
		this.status = status;
	}
	public LocalDateTime getAbertOs() {
		return abertOs;
	}

	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	public String getTempoDeTrabalho() {
		return tempoDeTrabalho;
	}
	public void setTempoDeTrabalho(String tempoDeTrabalho) {
		this.tempoDeTrabalho = tempoDeTrabalho;
	}
	

}
