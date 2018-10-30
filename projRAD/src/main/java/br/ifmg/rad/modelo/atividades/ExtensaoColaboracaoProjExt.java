package modelo.atividades;

import modelo.Atividade;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExtensaoColaboracaoProjExt extends Atividade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExtensaoColaboracaoProjExt(Integer id, String tituloProjeto, Date vigenciaDe, Date vigenciaAte,
			String instituicaoDeFomento, String coordenador, ArrayList<String> alunos_curso) {
		super();
		this.id = id;
		this.tituloProjeto = tituloProjeto;
		this.vigenciaDe = vigenciaDe;
		this.vigenciaAte = vigenciaAte;
		this.instituicaoDeFomento = instituicaoDeFomento;
		this.coordenador = coordenador;
		this.alunos_curso = alunos_curso;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String tituloProjeto;
	private Date vigenciaDe;
	private Date vigenciaAte;
	
	private String instituicaoDeFomento;
	private String coordenador;
	
	private ArrayList<String> alunos_curso;
	
	public String getTituloProjeto() {
		return tituloProjeto;
	}
	public void setTituloProjeto(String tituloProjeto) {
		this.tituloProjeto = tituloProjeto;
	}
	public Date getVigenciaDe() {
		return vigenciaDe;
	}
	public void setVigenciaDe(Date vigenciaDe) {
		this.vigenciaDe = vigenciaDe;
	}
	public Date getVigenciaAte() {
		return vigenciaAte;
	}
	public void setVigenciaAte(Date vigenciaAte) {
		this.vigenciaAte = vigenciaAte;
	}

	public ArrayList<String> getAlunos_curso() {
		return alunos_curso;
	}
	public void setAlunos_curso(ArrayList<String> alunos_curso) {
		this.alunos_curso = alunos_curso;
	}
	public String getInstituicaoDeFomento() {
		return instituicaoDeFomento;
	}
	public void setInstituicaoDeFomento(String instituicaoDeFomento) {
		this.instituicaoDeFomento = instituicaoDeFomento;
	}
	public String getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

}
