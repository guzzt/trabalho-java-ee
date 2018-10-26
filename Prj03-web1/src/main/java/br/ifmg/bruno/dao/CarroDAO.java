package br.ifmg.bruno.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.bruno.modelo.Carro;
import br.ifmg.bruno.util.Conexao;

public class CarroDAO {

	private EntityManager em;
	
	public CarroDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Carro obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Carro> buscarTodos(){
		
		return em
		        .createQuery("from Carro")
		        .getResultList();
		
	}	
	
	
	public void excluir(Carro obj) {
		
		Carro aux = 
				em.find(Carro.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Carro buscarPorId(Integer codigo){
		
		return em.find(Carro.class,codigo);		
	}	
	
	
}
