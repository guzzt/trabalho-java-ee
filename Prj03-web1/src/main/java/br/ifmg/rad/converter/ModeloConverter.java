package br.ifmg.rad.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ifmg.rad.modelo.Fabricante;
import br.ifmg.rad.modelo.Modelo;
import br.ifmg.rad.service.FabricanteService;
import br.ifmg.rad.service.ModeloService;

@FacesConverter(forClass=Modelo.class)
public class ModeloConverter implements Converter{

	private ModeloService service = new ModeloService();
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Modelo mod = null;
		
		if ( (value != null) && (!value.isEmpty()) )
			mod = 
               service.buscarPorId(Integer.parseInt(value));		
		
		return mod;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		
		if (value != null){
			//Fabricante aux = (Fabricante)value;
			//Integer cod = aux.getCodigo();
			//return  cod.toString();
		   return 
		     String.valueOf(((Modelo)value).getCodigo());
		}
		else 
		   return null;
	}

	
	
	
}
