package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable{
    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private DAOGenerico<Usuario> daoUsuario;
    
    public UsuarioMB(){
        criarObjetos();
        preencherListaUsuarios();
    }
    private void criarObjetos(){
        usuario = new Usuario();
        listaUsuarios = new ArrayList<Usuario>();
        daoUsuario = new DAOGenerico<Usuario>(Usuario.class);
    }
    
    private void preencherListaUsuarios(){
        listaUsuarios = daoUsuario.buscarTodos();
    }
    
    public void remover(Long id){
        daoUsuario.excluir(id);
        preencherListaUsuarios();
    }
    
    public void inserir(){
        if(usuario.getId() == null){
            daoUsuario.salvar(usuario);
        }else{
            daoUsuario.alterar(usuario);
        }
        preencherListaUsuarios();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public DAOGenerico<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(DAOGenerico<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }
    
    
    
}
