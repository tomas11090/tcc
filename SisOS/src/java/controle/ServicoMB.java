
package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Servico;


@ManagedBean
@SessionScoped
public class ServicoMB implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Servico servico = new Servico();
    private List<Servico> listaServicos = new ArrayList<>();
    private DAOGenerico<Servico> daoServico = new DAOGenerico<>(Servico.class);
    
    public ServicoMB(){
        //criarObjetos();
        //preencherListaServicos();
        listaServicos = daoServico.buscarTodos();
    }
    
//    private void criarObjetos(){
//        servico = new Servico();
//        listaServicos = new ArrayList<Servico>();
//        daoServico = new DAOGenerico<Servico>(Servico.class);
//    }
    
//    private void preencherListaServicos(){
//        listaServicos = daoServico.buscarTodos();
//    }
    
    public void excluir(Long id){
        daoServico.excluir(id);
        //preencherListaServicos();
        listaServicos = daoServico.buscarTodos();
    }
    
    public void inserir(){
        if(servico.getId() == null){
            daoServico.salvar(servico);
        }else{
            daoServico.alterar(servico);
        }
        //preencherListaServicos();
        servico = new Servico();
        listaServicos = daoServico.buscarTodos();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public DAOGenerico<Servico> getDaoServico() {
        return daoServico;
    }

    public void setDaoServico(DAOGenerico<Servico> daoServico) {
        this.daoServico = daoServico;
    }

    
    
}
