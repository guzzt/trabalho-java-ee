package br.ifmg.bruno.modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FUNCIONARIO")
public class Funcionario extends Pessoa{

	private String matricula;


	public Funcionario(Integer codigo, String nome, Date dtNascimento, String cpf, Sexo sexo, Date dtCriacao,
			String matricula) {
		super(codigo, nome, dtNascimento, cpf, sexo, dtCriacao);
		this.matricula = matricula;
	}

	public Funcionario() {

	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		
		return super.toString() +
				 "Matrícula: "+getMatricula();
	}
}
