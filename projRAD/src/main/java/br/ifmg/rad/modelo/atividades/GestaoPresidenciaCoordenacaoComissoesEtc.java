package br.ifmg.rad.modelo.atividades;

import br.ifmg.rad.modelo.Atividade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GestaoPresidenciaCoordenacaoComissoesEtc extends Atividade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GestaoPresidenciaCoordenacaoComissoesEtc() {}
	
	public GestaoPresidenciaCoordenacaoComissoesEtc(Integer id, String descricaoDoCargo, String periodoDoMandato,
			String portaria) {
		super();
		this.id = id;
		this.descricaoDoCargo = descricaoDoCargo;
		this.periodoDoMandato = periodoDoMandato;
		this.portaria = portaria;
	}
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descricaoDoCargo;
	private String periodoDoMandato;
	private String portaria;
	
	public String getDescricaoDoCargo() {
		return descricaoDoCargo;
	}
	public void setDescricaoDoCargo(String descricaoDoCargo) {
		this.descricaoDoCargo = descricaoDoCargo;
	}
	
	public String getPeriodoDoMandato() {
		return periodoDoMandato;
	}
	public void setPeriodoDoMandato(String periodoDoMandato) {
		this.periodoDoMandato = periodoDoMandato;
	}
	
	public String getPortaria() {
		return portaria;
	}
	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

}
