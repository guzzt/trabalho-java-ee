package br.ifmg.bruno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ifmg.bruno.modelo.Fabricante;
import br.ifmg.bruno.service.FabricanteService;

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
