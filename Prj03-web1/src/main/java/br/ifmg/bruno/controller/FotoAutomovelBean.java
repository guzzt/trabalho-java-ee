package br.ifmg.bruno.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.ifmg.bruno.modelo.Carro;



@ManagedBean
@SessionScoped
public class FotoAutomovelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carro automovelSelecionado;

	
	public FotoAutomovelBean() {

	}

	
	   public StreamedContent getFoto() {
			
	    	StreamedContent foto=null;
	    	String nomeImagem = "DEFAULT.png";
			if (this.automovelSelecionado != null && this.automovelSelecionado.getFoto() != null
					&& this.automovelSelecionado.getFoto().length > 0) {
				
				byte[] imagem = this.automovelSelecionado.getFoto();
				foto = new DefaultStreamedContent(new ByteArrayInputStream(imagem), "image/jpg", "carro.jpg");
				handlePicture(imagem);
				nomeImagem = "teste.png";
			}

			try {
				foto = (DefaultStreamedContent) 
						recuperarFotoDisco(nomeImagem);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("ERRO AO BUSCAR A IMAGEM!!!");
			}
			
			return foto;
		}	
	
	
	
	public Carro getAutomovelSelecionado() {
		return automovelSelecionado;
	}

	public void setAutomovelSelecionado(Carro automovelSelecionado) {
		this.automovelSelecionado = automovelSelecionado;
	}

	//--------------------------
	public static void handlePicture(byte[] imageToHandle) {
        String nomeFoto = String.format("%s.png","teste");
 
        try {
            salvarNoDisco(ImageIO.read(
            		new ByteArrayInputStream(imageToHandle)), nomeFoto);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 
    private static void salvarNoDisco(BufferedImage fotoSalvar, String nomeFoto) throws IOException{
        String FOLDER = "/temp/";
    	
    	File f = new File(FOLDER);
 
        if(!f.exists()){
            f.mkdirs(); f.setReadable(true); f.setWritable(true);
        }
 
        ImageIO.write(fotoSalvar, "png", new File(FOLDER + nomeFoto));
    }
 
    public static StreamedContent recuperarFotoDisco(String fotoNome) throws FileNotFoundException{
    	 String FOLDER = "/temp/";
    	try {
            return new DefaultStreamedContent(new FileInputStream(new File(FOLDER + fotoNome)), "image/png");
        } catch (IOException e) {
            e.printStackTrace();
 
            return new DefaultStreamedContent(new FileInputStream(new File(FOLDER + "DEFAULT.png")), "image/png");
        }
    }	
	
	
}
