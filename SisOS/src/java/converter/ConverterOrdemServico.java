
package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.OrdemServico;

@FacesConverter("converterOS")
public class ConverterOrdemServico implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id !=null && !id.isEmpty()){
            DAOGenerico<OrdemServico> dao = new DAOGenerico<OrdemServico>(OrdemServico.class);
            return dao.buscar(new Long(id));
        }return null;
    
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            OrdemServico os = (OrdemServico) o;
            return String.valueOf(os.getId());
        }
        
        return null; 
    }
    
}
