package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.AcessorioDAO;
import br.ifmg.rad.modelo.Acessorio;

public class AcessorioService {

	private AcessorioDAO dao 
	            = new AcessorioDAO();
	
	
	public void salvar(Acessorio obj){
		
		if ( (obj == null) || 
		     (obj.getDescricao().isEmpty())
		   )
		  throw new ServiceException("Nome n�o informado.");
		
		
		
		dao.salvar(obj);
	}
	
	
	public List<Acessorio> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Acessorio obj) {
		
		dao.excluir(obj);
	}
	
	public Acessorio buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
