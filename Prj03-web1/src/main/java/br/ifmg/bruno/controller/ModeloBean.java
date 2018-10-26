package br.ifmg.bruno.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ifmg.bruno.modelo.Categoria;

import br.ifmg.bruno.modelo.Fabricante;
import br.ifmg.bruno.modelo.Modelo;
import br.ifmg.bruno.service.FabricanteService;
import br.ifmg.bruno.service.ModeloService;
import br.ifmg.bruno.util.FacesMensagens;

@ManagedBean
@SessionScoped
public class ModeloBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Modelo> modelos;
	private List<Fabricante> fabricantes;
	private List<Categoria> categorias;
	private Modelo modEdicao = 
			             new Modelo();
	private FabricanteService fabService =
			             new FabricanteService();
	private ModeloService modService =
            new ModeloService();
	
	public ModeloBean() {
		
		setModelos(modService.buscarTodos());
		setFabricantes(fabService.buscarTodos());
		setCategorias(Arrays.asList(Categoria.values()));
	}
	
	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Modelo getModEdicao() {
		return modEdicao;
	}

	public void setModEdicao(Modelo modEdicao) {
		this.modEdicao = modEdicao;
	}

	public String novoModelo(){
		modEdicao = new Modelo();
		return  "CadastroModelo?faces-redirect=true";
	}
	
	public String editarModelo(){
		return  "CadastroModelo?faces-redirect=true";
	}	
	
	public void salvarModelo(){
				
		try{
		modService.salvar(modEdicao);
		setModelos(modService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirModelo(){
		
		try{
		modService.excluir(modEdicao);
		setModelos(modService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		modEdicao = new Modelo();
		
	}
	
	
}
