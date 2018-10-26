package br.ifmg.bruno.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ifmg.bruno.modelo.Fabricante;
import br.ifmg.bruno.service.FabricanteService;
import br.ifmg.bruno.util.FacesMensagens;

@ManagedBean
@SessionScoped
public class FabricanteBean implements Serializable{

	private List<Fabricante> fabricantes;
	private Fabricante fabEdicao = 
			             new Fabricante();
	private FabricanteService fabService =
			             new FabricanteService();
	
	
	public FabricanteBean() {
		
		setFabricantes(fabService.buscarTodos());
		
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabEdicao() {
		return fabEdicao;
	}

	public void setFabEdicao(Fabricante fabEdicao) {
		this.fabEdicao = fabEdicao;
	}

	public String novoFabricante(){
		fabEdicao = new Fabricante();
		return  "CadastroFabricante?faces-redirect=true";
	}
	
	public String editarFabricante(){
		return  "CadastroFabricante?faces-redirect=true";
	}	
	
	public void salvarFabricante(){
				
		try{
		fabService.salvar(fabEdicao);
		setFabricantes(fabService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirFabricante(){
		
		try{
		fabService.excluir(fabEdicao);
		setFabricantes(fabService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		fabEdicao = new Fabricante();
		
	}
	
	
}
