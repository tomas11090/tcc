
package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Fornecedor;


@ManagedBean
@ViewScoped
public class FornecedorMB implements Serializable{
    private Fornecedor fornecedor;
    
    private DAOGenerico<Fornecedor> daoFornecedor;
    private List<Fornecedor> listaFornecedor;
    
    public FornecedorMB(){
        fornecedor = new Fornecedor();
        daoFornecedor = new DAOGenerico<Fornecedor>(Fornecedor.class);
        listaFornecedor = new ArrayList<Fornecedor>();
        preencherListaFornecedor();
    }
    
    private void preencherListaFornecedor(){
        listaFornecedor = daoFornecedor.buscarTodos();
    }
    
    public void remover(Long id){
        daoFornecedor.excluir(id);
        preencherListaFornecedor();
    }
    
    public void inserir(){
        if(fornecedor.getId() == null){
            daoFornecedor.salvar(fornecedor);
        }else {
            daoFornecedor.alterar(fornecedor);
        }
        fornecedor = new Fornecedor();
        preencherListaFornecedor();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public DAOGenerico<Fornecedor> getDaoFornecedor() {
        return daoFornecedor;
    }

    public void setDaoFornecedor(DAOGenerico<Fornecedor> daoFornecedor) {
        this.daoFornecedor = daoFornecedor;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }
    
    
}
