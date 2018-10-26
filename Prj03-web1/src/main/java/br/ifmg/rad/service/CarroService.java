package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.CarroDAO;
import br.ifmg.rad.modelo.Carro;

public class CarroService {

	private CarroDAO dao 
	            = new CarroDAO();
	
	
	public void salvar(Carro obj){
		
		if ( (obj == null) || 
			 (obj.getPlaca() == null) ||	
		     (obj.getPlaca().isEmpty()) ||
		     (obj.getModelo() == null)
		   )
		  throw new ServiceException("Placa ou modelo n�o informados.");
		
		
		
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
