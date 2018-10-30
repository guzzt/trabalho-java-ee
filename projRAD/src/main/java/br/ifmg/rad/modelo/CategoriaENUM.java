package br.ifmg.rad.modelo;

public enum CategoriaENUM {

	AULAS(1),
	PROJETOS(2);
	
	private int categoria ;
	
	private CategoriaENUM(int categoria) {
		this.categoria = categoria ;
	}
	
	public int getCategoria() {
		return this.categoria ;
	}
	
	
	
}
