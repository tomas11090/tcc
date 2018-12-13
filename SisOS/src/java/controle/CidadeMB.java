package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cidade;
import modelo.Estado;


@ManagedBean
@ViewScoped
public class CidadeMB implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade;
    private List<Cidade> listaCidades;
    private DAOGenerico<Cidade> daoCidade;
    private Estado estado;

    public CidadeMB(){
        criarObjetos();
        preencherListaCidades();
    }
    private void criarObjetos(){
        cidade = new Cidade();
        listaCidades = new ArrayList<Cidade>();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
    }
    private void preencherListaCidades(){
        listaCidades = daoCidade.buscarTodos();
    }
    
    public void remover(Long id){
        daoCidade.excluir(id);
        preencherListaCidades();
    }
    
    public void inserir(){
        if(cidade.getId() == null){
            daoCidade.salvar(cidade);
        }else{
            daoCidade.alterar(cidade);
        }
        preencherListaCidades();
        cidade = new Cidade();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public DAOGenerico<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
