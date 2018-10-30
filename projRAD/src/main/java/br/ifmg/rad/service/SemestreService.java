package br.ifmg.rad.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import br.ifmg.rad.dao.SemestreDAO;
import br.ifmg.rad.modelo.Semestre;

public class SemestreService {

	private SemestreDAO dao = new SemestreDAO();

	public void salvar(Semestre obj) {

		if ((obj == null) || (obj.getInicio() == null ) || (obj.getFim() == null ) )
			throw new ServiceException("Preencha todos os campos para salvar o Semestre .");

		dao.salvar(obj);
	}

	public List<Semestre> buscarTodos() {

		return dao.buscarTodos();

	}

	public void excluir(Semestre obj) {

		dao.excluir(obj);
	}

	public Semestre buscarPorId(Integer codigo) {

		return dao.buscarPorId(codigo);
	}

}