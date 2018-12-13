package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Usuario;

@FacesConverter("converterUsuario")
public class ConverterUsuario implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Usuario> dao = new DAOGenerico<Usuario>(Usuario.class);
            return dao.buscarPorId(new Long(id));
        }return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Usuario usuario = (Usuario) o;
            return String.valueOf(usuario.getId());
        }return null;
    }
    
}

