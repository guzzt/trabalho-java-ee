package br.ifmg.bruno.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.bruno.modelo.Fabricante;
import br.ifmg.bruno.util.Conexao;

public class FabricanteDAO {

	private EntityManager em;
	
	public FabricanteDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Fabricante obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Fabricante> buscarTodos(){
		
		return em
		        .createQuery("from Fabricante")
		        .getResultList();
		
	}	
	
	
	public void excluir(Fabricante obj) {
		
		Fabricante aux = 
				em.find(Fabricante.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Fabricante buscarPorId(Integer codigo){
		
		return em.find(Fabricante.class,codigo);		
	}	
	

	public List<String> buscarTodosNomes(){
		
		return em
		        .createQuery("select f.nome "
		        		   + "from Fabricante f "
		        		   + "where f.codigo <= 2")
		        .getResultList();
		
	}	
	
	
	
	
	
}
