package br.ifmg.rad.modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MOTORISTA")
public class Motorista extends Pessoa{

	private String cnh;

	
	
	
	public Motorista(Integer codigo, String nome, Date dtNascimento, String cpf, Sexo sexo, Date dtCriacao,
			String cnh) {
		super(codigo, nome, dtNascimento, cpf, sexo, dtCriacao);
		this.cnh = cnh;
	}

	public Motorista() {
		
	}
	
	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	@Override
	public String toString() {
		
		return super.toString() +
				 "CNH: "+getCnh();
	}
}
