package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Produto;
import util.ChamarRelatorio;



@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Produto produto = new Produto();
    private List<Produto> listaProduto = new ArrayList<>();
    private DAOGenerico<Produto> daoProduto = new DAOGenerico<>(Produto.class);
    
    public ProdutoMB(){
        listaProduto = daoProduto.buscarTodos();
        
    }
    public void chamarRelatorio(){
        //String consulta = "SELECT * from pessoa";
        ChamarRelatorio rel = new ChamarRelatorio();
        rel.imprimeRelatorio("relProduto.jasper", null, "Relatório_Produto");
    }
    
    public void inserir() {
		if (produto.getId() == null) {
			daoProduto.salvar(produto);
		} else {
			daoProduto.alterar(produto);
		}
		produto = new Produto();
		listaProduto = daoProduto.buscarTodos();
	}
	
	public void excluir(Long id){
		daoProduto.excluir(id);
		listaProduto = daoProduto.buscarTodos();
	}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public DAOGenerico<Produto> getDaoProduto() {
        return daoProduto;
    }

    public void setDaoProduto(DAOGenerico<Produto> daoProduto) {
        this.daoProduto = daoProduto;
    }
        
        
    
    
    
}
