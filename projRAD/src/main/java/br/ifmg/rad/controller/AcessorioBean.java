package br.ifmg.rad.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ifmg.rad.modelo.Acessorio;
import br.ifmg.rad.service.AcessorioService;
import br.ifmg.rad.util.FacesMensagens;

@ManagedBean
@SessionScoped
public class AcessorioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private List<Acessorio> acessorios;
	private Acessorio aceEdicao = 
			             new Acessorio();
	private AcessorioService aceService =
            new AcessorioService();
	
	public AcessorioBean() {
	
		setAcessorios(aceService.buscarTodos());
	}
	


	public List<Acessorio> getAcessorios() {
		return acessorios;
	}



	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}



	public Acessorio getAceEdicao() {
		return aceEdicao;
	}



	public void setAceEdicao(Acessorio aceEdicao) {
		this.aceEdicao = aceEdicao;
	}



	public AcessorioService getAceService() {
		return aceService;
	}



	public void setAceService(AcessorioService aceService) {
		this.aceService = aceService;
	}



	public String novoAcessorio(){
		aceEdicao = new Acessorio();
		return  "CadastroAcessorio?faces-redirect=true";
	}
	
	public String editarAcessorio(){
		return  "CadastroAcessorio?faces-redirect=true";
	}	
	
	public void salvarAcessorio(){
				
		try{
		aceService.salvar(aceEdicao);
		setAcessorios(aceService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirAcessorio(){
		
		try{
		aceService.excluir(aceEdicao);
		setAcessorios(aceService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		aceEdicao = new Acessorio();
		
	}
	
	
}
