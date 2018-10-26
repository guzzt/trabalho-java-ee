package br.ifmg.bruno.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.bruno.modelo.Modelo;
import br.ifmg.bruno.util.Conexao;

public class ModeloDAO {

	private EntityManager em;
	
	public ModeloDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Modelo obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Modelo> buscarTodos(){
		
		return em
		        .createQuery("from Modelo")
		        .getResultList();
		
	}	
	
	
	public void excluir(Modelo obj) {
		
		Modelo aux = 
				em.find(Modelo.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Modelo buscarPorId(Integer codigo){
		
		return em.find(Modelo.class,codigo);		
	}	
	

	public List<String> buscarModelosPorFabricante(){
		
		return em
		        .createQuery("select "
		        		   + "m.fabricante.nome "
		        		   + "from Modelo m "
		        		   + "where m.modelo = 'Uno'")
		        .getResultList();
		
		
		/* select f.nome, modelo.descricao from modelo
		 *       inner join fabricante on fabricante.codigo = modelo.codfabricante  */
		
	}	
	
	
	
}
