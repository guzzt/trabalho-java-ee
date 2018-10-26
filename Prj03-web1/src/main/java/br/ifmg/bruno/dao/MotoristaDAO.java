package br.ifmg.bruno.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.bruno.modelo.Motorista;
import br.ifmg.bruno.util.Conexao;

public class MotoristaDAO {

	private EntityManager em;
	
	public MotoristaDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Motorista obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Motorista> buscarTodos(){
		
		return em
		        .createQuery("from Motorista")
		        .getResultList();
		
	}	
	
	
	public void excluir(Motorista obj) {
		
		Motorista aux = 
				em.find(Motorista.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Motorista buscarPorId(Integer codigo){
		
		return em.find(Motorista.class,codigo);		
	}	
	
	
}
