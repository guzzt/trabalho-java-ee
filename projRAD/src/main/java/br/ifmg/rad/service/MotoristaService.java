package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.MotoristaDAO;
import br.ifmg.rad.modelo.Motorista;

public class MotoristaService {

	private MotoristaDAO dao 
	            = new MotoristaDAO();
	
	
	public void salvar(Motorista obj){
		
		if ( (obj == null) || 
		     (obj.getNome().isEmpty())
		   )
		  throw new ServiceException("Nome n�o informado.");
		
		
		
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
