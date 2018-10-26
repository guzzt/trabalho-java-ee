package br.ifmg.bruno.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.bruno.dao.FabricanteDAO;
import br.ifmg.bruno.modelo.Fabricante;

public class FabricanteService {

	private FabricanteDAO dao 
	            = new FabricanteDAO();
	
	
	public void salvar(Fabricante obj){
		
		if ( (obj == null) || 
		     (obj.getNome().isEmpty())
		   )
		  throw new ServiceException("Nome não informado.");
		
		
		
		dao.salvar(obj);
	}
	
	
	public List<Fabricante> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Fabricante obj) {
		
		dao.excluir(obj);
	}
	
	public Fabricante buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
