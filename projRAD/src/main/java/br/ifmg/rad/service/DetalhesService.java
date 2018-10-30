package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.DetalhesDAO;
import br.ifmg.rad.modelo.Detalhes;

public class DetalhesService {

	private DetalhesDAO dao = new DetalhesDAO();

	public void salvar(Detalhes obj) {

		if ((obj == null) || (obj.getAtividade() == null ))
			throw new ServiceException("Atividade não informada.");

		dao.salvar(obj);
	}

	public List<Detalhes> buscarTodos() {

		return dao.buscarTodos();

	}

	public void excluir(Detalhes obj) {

		dao.excluir(obj);
	}

	public Detalhes buscarPorId(Integer codigo) {

		return dao.buscarPorId(codigo);
	}

}
