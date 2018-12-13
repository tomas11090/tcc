
package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Venda;


@FacesConverter("converterVenda")
public class ConverterVenda implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id !=null && !id.isEmpty()){
            DAOGenerico<Venda> dao = new DAOGenerico<Venda>(Venda.class);
            return dao.buscar(new Long(id));
        }return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            Venda venda = (Venda) o;
            return String.valueOf(venda.getId());
        }
        
        return null;   
    }
    
}
