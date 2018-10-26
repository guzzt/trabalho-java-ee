package br.ifmg.bruno.modelo;

public enum Categoria {

	HATCH_COMPACTO("Hatch compacto"),
	HATCH_MEDIO("Hatch médio"),
	SEDAN_COMPACTO("Sedan compacto"),
	SEDAN_MEDIO("Sedan médio"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO("Utiliátio");
	
	private String nome;
	
	
	private Categoria(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}
