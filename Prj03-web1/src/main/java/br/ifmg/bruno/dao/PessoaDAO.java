package br.ifmg.bruno.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifmg.bruno.modelo.Pessoa;
import br.ifmg.bruno.util.Conexao;

public class PessoaDAO {

	private EntityManager em;
	
	public PessoaDAO() {
		em = Conexao.getConnection();
	}
	
	
	public void salvar(Pessoa obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Pessoa> buscarTodos(){
		
		return em
		        .createQuery("from Pessoa",Pessoa.class)
		        .getResultList();
		
	}	
	
	
	public void excluir(Pessoa obj) {
		
		Pessoa aux = 
				em.find(Pessoa.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	
	
	public Pessoa buscarPorId(Integer codigo){
		
		return em.find(Pessoa.class,codigo);		
	}	
	
	
	
	public Pessoa buscarPorLogin(String login){
		String hql = "select u from Usuario u "+
	                 " where u.login = :login ";
		
		return (Pessoa)
  		  em.createQuery(hql,Pessoa.class)
  		    .setParameter("login", login)
  		    .getSingleResult();	
	}	
	
	
}
