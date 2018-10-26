package br.ifmg.bruno.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

import br.ifmg.bruno.service.ModeloService;
import br.ifmg.bruno.modelo.Acessorio;
import br.ifmg.bruno.modelo.Carro;
import br.ifmg.bruno.modelo.Modelo;
import br.ifmg.bruno.service.AcessorioService;
import br.ifmg.bruno.service.CarroService;
import br.ifmg.bruno.util.FacesMensagens;

@ManagedBean
@SessionScoped
public class CarroBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Carro> carros;
	private List<Modelo> modelos;
	private List<Acessorio> acessorios;
	private Carro carEdicao = 
			             new Carro();
	private ModeloService modService =
			             new ModeloService();
	private AcessorioService aceService =
                         new AcessorioService();	
	private CarroService carService =
                         new CarroService();
	
	private UploadedFile fotoAutomovel;

	
	public CarroBean() {
		
		setCarros(carService.buscarTodos());
		setModelos(modService.buscarTodos());
		setAcessorios(aceService.buscarTodos());
	}
	
	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Carro getCarEdicao() {
		return carEdicao;
	}

	public void setCarEdicao(Carro carEdicao) {
		this.carEdicao = carEdicao;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}


	public Carro getModEdicao() {
		return carEdicao;
	}

	public void setModEdicao(Carro carEdicao) {
		this.carEdicao = carEdicao;
	}


	
	
	public UploadedFile getFotoAutomovel() {
		return fotoAutomovel;
	}

	public void setFotoAutomovel(UploadedFile fotoAutomovel) {
		this.fotoAutomovel = fotoAutomovel;
	}

	public String novoCarro(){
		carEdicao = new Carro();
		return  "CadastroCarro?faces-redirect=true";
	}
	
	public String editarCarro(){
		return  "CadastroCarro?faces-redirect=true";
	}	
	
	public void salvarCarro(){
				
		try{
			
	    if (this.fotoAutomovel != null &&
	    		this.fotoAutomovel.getContents().length>0)
	    	carEdicao.setFoto(fotoAutomovel.getContents());
			
		carService.salvar(carEdicao);
		setCarros(carService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirCarro(){
		
		try{
		carService.excluir(carEdicao);
		setCarros(carService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		carEdicao = new Carro();
		
	}
	
	
}
