package br.ifmg.bruno.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.bruno.modelo.Aluguel;
import br.ifmg.bruno.util.Conexao;

public class AluguelDAO {

	private EntityManager em;
	
	public AluguelDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Aluguel obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Aluguel> buscarTodos(){
		
		return em
		        .createQuery("from Aluguel")
		        .getResultList();
		
	}	
	
	
	public void excluir(Aluguel obj) {
		
		Aluguel aux = 
				em.find(Aluguel.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Aluguel buscarPorId(Integer codigo){
		
		return em.find(Aluguel.class,codigo);		
	}	
	
	
}
