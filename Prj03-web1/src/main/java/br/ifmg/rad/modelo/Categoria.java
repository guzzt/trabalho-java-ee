package br.ifmg.rad.modelo;

public enum Categoria {

	HATCH_COMPACTO("Hatch compacto"),
	HATCH_MEDIO("Hatch m�dio"),
	SEDAN_COMPACTO("Sedan compacto"),
	SEDAN_MEDIO("Sedan m�dio"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO("Utili�tio");
	
	private String nome;
	
	
	private Categoria(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}
