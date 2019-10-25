package br.com.vizentec.kiwi.models;

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




@Entity
public class Os {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    private Equipamento equip;
    private String desc;
    private String condCheg;
    private String acoes;
    private String condSaida;
    
    @OneToMany()
    private List<Peca> pecas = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private StatusOs status = StatusOs.AGUARDANDO_ATENDIMENTO;
    private Date dataAbert;
    private String origem;
    private Date dataLimite;
    private String contrato;
    private User responsavel;
    
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Equipamento getEquip() {
		return equip;
	}
	public void setEquip(Equipamento equip) {
		this.equip = equip;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCondCheg() {
		return condCheg;
	}
	public void setCondCheg(String condCheg) {
		this.condCheg = condCheg;
	}
	public String getAcoes() {
		return acoes;
	}
	public void setAcoes(String acoes) {
		this.acoes = acoes;
	}
	public String getCondSaida() {
		return condSaida;
	}
	public void setCondSaida(String condSaida) {
		this.condSaida = condSaida;
	}

	public StatusOs getStatus() {
		return status;
	}
	public void setStatus(StatusOs status) {
		this.status = status;
	}
	public Date getDataAbert() {
		return dataAbert;
	}
	public void setDataAbert(Date dataAbert) {
		this.dataAbert = dataAbert;
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
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public User getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(User responsavel) {
		this.responsavel = responsavel;
	}
	public User getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(User solicitante) {
		this.solicitante = solicitante;
	}
	private User solicitante;
    
    
    
    

}
