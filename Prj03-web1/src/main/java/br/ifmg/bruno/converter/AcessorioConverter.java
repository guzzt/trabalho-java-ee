package br.ifmg.bruno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ifmg.bruno.modelo.Acessorio;
import br.ifmg.bruno.modelo.Fabricante;
import br.ifmg.bruno.service.AcessorioService;
import br.ifmg.bruno.service.FabricanteService;

//@FacesConverter(forClass=Acessorio.class)
@FacesConverter("acessorioConverter")
public class AcessorioConverter implements Converter{

	private AcessorioService service = new AcessorioService();
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Acessorio ace = null;
		
		if ( (value != null) && (!value.isEmpty()) )
			ace = 
               service.buscarPorId(Integer.parseInt(value));		
		
		return ace;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		
		if (value != null){
			//Fabricante aux = (Fabricante)value;
			//Integer cod = aux.getCodigo();
			//return  cod.toString();
		   return 
		     String.valueOf(((Acessorio)value).getCodigo());
		}
		else 
		   return null;
	}

	
	
	
}
