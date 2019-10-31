package br.com.vizentec.kiwi.controller.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OsSearch {
	private String osName;
	private List<String> contratos = new ArrayList<String>();
	private Date dataI;
	private Date dataF;
	private String local;
	private String status;
	private String origem;
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public List<String> getContratos() {
		return contratos;
	}
	public void setContratos(List<String> contratos) {
		this.contratos = contratos;
	}
	public Date getDataI() {
		return dataI;
	}
	public void setDataI(Date dataI) {
		this.dataI = dataI;
	}
	public Date getDataF() {
		return dataF;
	}
	public void setDataF(Date dataF) {
		this.dataF = dataF;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	

}
