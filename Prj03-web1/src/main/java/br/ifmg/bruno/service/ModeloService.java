package br.ifmg.bruno.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.bruno.dao.ModeloDAO;
import br.ifmg.bruno.modelo.Modelo;

public class ModeloService {

	private ModeloDAO dao 
	            = new ModeloDAO();
	
	
	public void salvar(Modelo obj){
		
		if ( (obj == null) || 
		     (obj.getDescricao().isEmpty())
		   )
		  throw new ServiceException("Nome n�o informado.");
		
		
		
		dao.salvar(obj);
	}
	
	
	public List<Modelo> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Modelo obj) {
		
		dao.excluir(obj);
	}
	
	public Modelo buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
