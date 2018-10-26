package br.ifmg.rad.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ifmg.rad.modelo.Fabricante;
import br.ifmg.rad.service.FabricanteService;

@FacesConverter(forClass=Fabricante.class)
public class FbricanteConverter implements Converter{

	private FabricanteService service = new FabricanteService();
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Fabricante fab = null;
		
		if ( (value != null) && (!value.isEmpty()) )
			fab = 
               service.buscarPorId(Integer.parseInt(value));		
		
		return fab;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		
		if (value != null){
			Fabricante aux = (Fabricante)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		   //return 
		   //  String.valueOf(((Fabricante)value).getCodigo());
		}
		else 
		   return null;
	}

	
	
	
}
