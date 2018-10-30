package modelo.atividades;

import modelo.Atividade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnsinoOrientacaoEstagio extends Atividade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeAluno;
	private String localEstagio;
	
	
	
	public EnsinoOrientacaoEstagio(Integer id, String nomeAluno, String localEstagio) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.localEstagio = localEstagio;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public String getLocalEstagio() {
		return localEstagio;
	}
	public void setLocalEstagio(String localEstagio) {
		this.localEstagio = localEstagio;
	}
	
}
