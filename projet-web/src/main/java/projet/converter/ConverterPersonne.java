package projet.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import projet.jsf.data.Personne;

@Named
@RequestScoped
public class ConverterPersonne implements Converter<Personne> {

	// Actions

	@SuppressWarnings("unchecked")
	@Override
	public Personne getAsObject(FacesContext context, UIComponent uic, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		List<Personne> items = null;
		for (UIComponent c : uic.getChildren()) {
			if (c instanceof UISelectItems) {
				items = (List<Personne>) ((UISelectItems) c).getValue();
				break;
			}
		}

		// var id = Integer.valueOf("x"+value);
		var id = Integer.valueOf(value);
		for (Personne item : items) {
			if (item.getIdPersonne().equals(id)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Personne item) {

		if (item == null) {
			return "";
		}
		return String.valueOf(item.getIdPersonne());
	}
}
