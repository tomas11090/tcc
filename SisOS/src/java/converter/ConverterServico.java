
package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Servico;

@FacesConverter("converterServico")
public class ConverterServico implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Servico> dao = new DAOGenerico<Servico>(Servico.class);
            return dao.buscarPorId(new Long(id));
            
        }return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
         if(o!=null){
            Servico servico = (Servico) o;
            return String.valueOf(servico.getId());
        }return null;
    }
    
}
