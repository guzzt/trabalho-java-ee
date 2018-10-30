package modelo.atividades;

import modelo.Atividade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PesquisaCoordenacaoGrupoPesquisa extends Atividade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public PesquisaCoordenacaoGrupoPesquisa(Integer id, String nomeDoGrupo, String unidade) {
		super();
		this.id = id;
		this.nomeDoGrupo = nomeDoGrupo;
		this.unidade = unidade;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeDoGrupo;
	private String unidade;
	
	public String getNomeDoGrupo() {
		return nomeDoGrupo;
	}
	public void setNomeDoGrupo(String nomeDoGrupo) {
		this.nomeDoGrupo = nomeDoGrupo;
	}
	
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	

}
