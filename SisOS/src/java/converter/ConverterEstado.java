package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Estado;

@FacesConverter("converterEstado")
public class ConverterEstado implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Estado> dao = new DAOGenerico<Estado>(Estado.class);
            return dao.buscarPorId(new Long(id));
        }return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Estado estado = (Estado) o;
            return String.valueOf(estado.getId());
        }return null;
    }
    
}
