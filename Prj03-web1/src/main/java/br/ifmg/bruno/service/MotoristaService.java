package br.ifmg.bruno.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.bruno.dao.MotoristaDAO;
import br.ifmg.bruno.modelo.Motorista;

public class MotoristaService {

	private MotoristaDAO dao 
	            = new MotoristaDAO();
	
	
	public void salvar(Motorista obj){
		
		if ( (obj == null) || 
		     (obj.getNome().isEmpty())
		   )
		  throw new ServiceException("Nome não informado.");
		
		
		
		dao.salvar(obj);
	}
	
	
	public List<Motorista> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Motorista obj) {
		
		dao.excluir(obj);
	}
	
	public Motorista buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
