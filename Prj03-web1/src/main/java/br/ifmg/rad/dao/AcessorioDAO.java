package br.ifmg.rad.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.rad.modelo.Acessorio;
import br.ifmg.rad.util.Conexao;

public class AcessorioDAO {

	private EntityManager em;
	
	public AcessorioDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Acessorio obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Acessorio> buscarTodos(){
		
		return em
		        .createQuery("from Acessorio")
		        .getResultList();
		
	}	
	
	
	public void excluir(Acessorio obj) {
		
		Acessorio aux = 
				em.find(Acessorio.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instru��o no momento
		em.getTransaction().commit();
	}
	
	public Acessorio buscarPorId(Integer codigo){
		
		return em.find(Acessorio.class,codigo);		
	}	
	
	
}
