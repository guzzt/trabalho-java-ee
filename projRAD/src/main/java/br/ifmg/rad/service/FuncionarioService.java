package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.FuncionarioDAO;
import br.ifmg.rad.modelo.Funcionario;

public class FuncionarioService {

	private FuncionarioDAO dao 
	            = new FuncionarioDAO();
	
	
	public void salvar(Funcionario obj){
		
		if ( (obj == null) || 
		     (obj.getNome().isEmpty())
		   )
		  throw new ServiceException("Nome n�o informado.");
		
		
		
		dao.salvar(obj);
	}
	
	
	public List<Funcionario> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Funcionario obj) {
		
		dao.excluir(obj);
	}
	
	public Funcionario buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
