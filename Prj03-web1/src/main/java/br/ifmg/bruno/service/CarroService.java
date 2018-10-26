package br.ifmg.bruno.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.bruno.dao.CarroDAO;
import br.ifmg.bruno.modelo.Carro;

public class CarroService {

	private CarroDAO dao 
	            = new CarroDAO();
	
	
	public void salvar(Carro obj){
		
		if ( (obj == null) || 
			 (obj.getPlaca() == null) ||	
		     (obj.getPlaca().isEmpty()) ||
		     (obj.getModelo() == null)
		   )
		  throw new ServiceException("Placa ou modelo não informados.");
		
		
		
		dao.salvar(obj);
	}
	
	
	public List<Carro> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Carro obj) {
		
		dao.excluir(obj);
	}
	
	public Carro buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
