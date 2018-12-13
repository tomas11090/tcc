package util;

import dao.DAOGenerico;
import modelo.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class RetornaUsuarioLogado {
//    public static Usuario retornaLogado(){
//        DAOGenerico<Usuario> daoUsuario = new DAOGenerico<>(Usuario.class);
//        Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username;
//        if(usuarioLogado instanceof UserDetails){
//            username = ((UserDetails) usuarioLogado).getUsername();
//        }else{
//            username = usuarioLogado.toString();
//        }
//        Usuario usuario = daoUsuario.buscarCondicao("email='" + username + "'").get(0);
//        return usuario;
//    }
}
