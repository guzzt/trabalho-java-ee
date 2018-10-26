package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.AluguelDAO;
import br.ifmg.rad.modelo.Aluguel;

public class AluguelService {

	private AluguelDAO dao 
	            = new AluguelDAO();
	
	
	public void salvar(Aluguel obj){
		
		if ( (obj == null) || 
		     (obj.getCarro() == null) ||
		     (obj.getDtPedido() == null)
		   )
		  throw new ServiceException("Carro ou data do pedido n�o informados.");
		
		/*
		 * Aqui ter�amos uma regra de negocio para
		 * verificar se o carro est� dispon�vel
		 * */
		
		dao.salvar(obj);
	}
	
	
	public List<Aluguel> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Aluguel obj) {
		
		dao.excluir(obj);
	}
	
	public Aluguel buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	
	
}
