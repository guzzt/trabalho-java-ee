package br.ifmg.rad.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	private final static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("PontRADPU");
	private static EntityManager em;
	
	private Conexao() {
		
	}
	
	public static EntityManager getConnection(){
		
		if (em == null)
		   em = emf.createEntityManager();
		
		return em;		   	
	}
	
	
	
}
