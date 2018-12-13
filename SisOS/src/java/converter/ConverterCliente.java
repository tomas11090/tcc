
package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Cliente;


@FacesConverter("converterCliente")
public class ConverterCliente implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Cliente> dao = new DAOGenerico<Cliente>(Cliente.class);
            return dao.buscarPorId(new Long(id));
        }return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Cliente cliente = (Cliente) o;
            return String.valueOf(cliente.getId());
        }return null;
    }
    
}