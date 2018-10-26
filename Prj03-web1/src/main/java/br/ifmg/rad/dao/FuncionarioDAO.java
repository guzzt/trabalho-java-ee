package br.ifmg.rad.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.rad.modelo.Funcionario;
import br.ifmg.rad.util.Conexao;

public class FuncionarioDAO {

	private EntityManager em;
	
	public FuncionarioDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Funcionario obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Funcionario> buscarTodos(){
		
		return em
		        .createQuery("from Funcionario")
		        .getResultList();
		
	}	
	
	
	public void excluir(Funcionario obj) {
		
		Funcionario aux = 
				em.find(Funcionario.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Funcionario buscarPorId(Integer codigo){
		
		return em.find(Funcionario.class,codigo);		
	}	
	
	
}
