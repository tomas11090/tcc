
package controle;

import dao.DAOGenerico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.ItensVenda;
import modelo.Venda;
import modelo.Produto;
import modelo.Usuario;
import util.ChamarRelatorio;
import util.RetornaUsuarioLogado;


@ManagedBean
@ViewScoped
public class VendaMB {
    private Venda venda = new Venda();
    private ItensVenda itensVenda = new ItensVenda();
    private List<ItensVenda> listaItensVenda = new ArrayList<>();
    private List<Venda> listaVendas = new ArrayList<>();
    private DAOGenerico<Venda> daoVenda = new DAOGenerico<>(Venda.class);
    private DAOGenerico<ItensVenda> daoItensVenda = new DAOGenerico<>(ItensVenda.class);
    
     
  
    
    public VendaMB(){
        listaVendas = daoVenda.buscarTodos();
//        ordemServico = new Venda();
//        daoOrdemServico = new DAOGenerico<OrdemServico>(Venda.class);
//        listaOrdemServicos = new ArrayList<OrdemServico>();
        //preencherListaOrdemServico();
    }
    
    public void chamarRelatorio(){
        //String consulta = "SELECT * from pessoa";
        ChamarRelatorio rel = new ChamarRelatorio();
        rel.imprimeRelatorio("relVenda.jasper", null, "Relatório_Venda");
    }
    
    public void adicionarItem() {
		System.out.println("Dentro do Método");
		if (itensVenda.getProduto() != null) {
			itensVenda.setValorUnitario(itensVenda.getProduto().getValorVenda());
			itensVenda.setValorTotal(itensVenda.getQuantidade() * itensVenda.getValorUnitario());
			listaItensVenda.add(itensVenda);
			itensVenda = new ItensVenda();
			System.out.println("QTDLista: " + listaItensVenda.size());
		}
    }
    
    public void finalizarVenda() {
		Double valorFinalVenda = 0.0;
		daoVenda.salvar(venda);
		for (ItensVenda it : listaItensVenda) {
			valorFinalVenda += it.getValorTotal();
			it.setVenda(venda);
			daoItensVenda.salvar(it);
                        
                        Produto produto = itensVenda.getProduto();
                        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - it.getQuantidade());
                        //daoItensOS.alterar(it);
		}
		venda.setValorTotalVenda(valorFinalVenda);
		daoVenda.alterar(venda);

		listaVendas = daoVenda.buscarTodos();// Instancia novamente para preencher a lista
		System.out.println("Tamanho da lista" + listaVendas.size());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Venda Realizada Com Sucesso!!", ""));

		novaVenda();
    }
    
    public void removerItem(ItensVenda itemRemover) {
	listaItensVenda.remove(itemRemover);
    }

    public void novaVenda() {
            venda = new Venda();
            listaItensVenda = new ArrayList<>();
            itensVenda = new ItensVenda();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
    }

    public List<ItensVenda> getListaItensVenda() {
        return listaItensVenda;
    }

    public void setListaItensVenda(List<ItensVenda> listaItensVenda) {
        this.listaItensVenda = listaItensVenda;
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(List<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }

    public DAOGenerico<Venda> getDaoVenda() {
        return daoVenda;
    }

    public void setDaoVenda(DAOGenerico<Venda> daoVenda) {
        this.daoVenda = daoVenda;
    }

    public DAOGenerico<ItensVenda> getDaoItensVenda() {
        return daoItensVenda;
    }

    public void setDaoItensVenda(DAOGenerico<ItensVenda> daoItensVenda) {
        this.daoItensVenda = daoItensVenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.venda);
        hash = 29 * hash + Objects.hashCode(this.itensVenda);
        hash = 29 * hash + Objects.hashCode(this.listaItensVenda);
        hash = 29 * hash + Objects.hashCode(this.listaVendas);
        hash = 29 * hash + Objects.hashCode(this.daoVenda);
        hash = 29 * hash + Objects.hashCode(this.daoItensVenda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaMB other = (VendaMB) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.itensVenda, other.itensVenda)) {
            return false;
        }
        if (!Objects.equals(this.listaItensVenda, other.listaItensVenda)) {
            return false;
        }
        if (!Objects.equals(this.listaVendas, other.listaVendas)) {
            return false;
        }
        if (!Objects.equals(this.daoVenda, other.daoVenda)) {
            return false;
        }
        if (!Objects.equals(this.daoItensVenda, other.daoItensVenda)) {
            return false;
        }
        return true;
    }

      
}
