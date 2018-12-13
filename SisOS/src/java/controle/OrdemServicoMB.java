
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.ItensOS;
import modelo.OrdemServico;
import util.ChamarRelatorio;

@ManagedBean
@ViewScoped
public class OrdemServicoMB {
    private OrdemServico ordemServico = new OrdemServico();
    private ItensOS itensOS = new ItensOS();
    private List<ItensOS> listaItensOS = new ArrayList<>();
    private List<OrdemServico> listaOrdemServico = new ArrayList<>();
    private DAOGenerico<OrdemServico> daoOrdemServico = new DAOGenerico<>(OrdemServico.class);
    private DAOGenerico<ItensOS> daoItensOS = new DAOGenerico<>(ItensOS.class);

    public OrdemServicoMB(){
        listaOrdemServico = daoOrdemServico.buscarTodos();
//        ordemServico = new Venda();
//        daoOrdemServico = new DAOGenerico<OrdemServico>(Venda.class);
//        listaOrdemServicos = new ArrayList<OrdemServico>();
        //preencherListaOrdemServico();
    }
    
    public void chamarRelatorio(){
        //String consulta = "SELECT * from pessoa";
        ChamarRelatorio rel = new ChamarRelatorio();
        rel.imprimeRelatorio("relOS.jasper", null, "Relatório_Ordem_de_Servico");
    }
    
    public void adicionarItem() {
		System.out.println("Dentro do Método");
		if (itensOS.getServico()!= null) {
			itensOS.setValorUnitario(itensOS.getServico().getValorOS());
			itensOS.setValorTotal(itensOS.getQuantidade() * itensOS.getValorUnitario());
			listaItensOS.add(itensOS);
			itensOS = new ItensOS();
			System.out.println("QTDLista: " + listaItensOS.size());
		}
    }
    
        public void finalizarOS() {
		Double valorFinalOS = 0.0;
		daoOrdemServico.salvar(ordemServico);
		for (ItensOS it : listaItensOS) {
			valorFinalOS += it.getValorTotal();
			it.setOrdemServico(ordemServico);
			daoItensOS.salvar(it);
                        
                        //Produto produto = itensVenda.getProduto();
                        //produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - it.getQuantidade());
                        //daoItensOS.alterar(it);
		}
		ordemServico.setValorTotalOrdemServico(valorFinalOS);
		daoOrdemServico.alterar(ordemServico);

		listaOrdemServico = daoOrdemServico.buscarTodos();// Instancia novamente para preencher a lista
		System.out.println("Tamanho da lista" + listaOrdemServico.size());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Ordem de Serviço Realizada Com Sucesso!!", ""));

		novaOS();
    }
        
    public void removerItem(ItensOS itemRemover) {
       
	listaItensOS.remove(itemRemover);
    }

    public void novaOS() {
            ordemServico = new OrdemServico();
            listaItensOS = new ArrayList<>();
            itensOS = new ItensOS();
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public ItensOS getItensOS() {
        return itensOS;
    }

    public void setItensOS(ItensOS itensOS) {
        this.itensOS = itensOS;
    }

    public List<ItensOS> getListaItensOS() {
        return listaItensOS;
    }

    public void setListaItensOS(List<ItensOS> listaItensOS) {
        this.listaItensOS = listaItensOS;
    }

    public List<OrdemServico> getListaOrdemServico() {
        return listaOrdemServico;
    }

    public void setListaOrdemServico(List<OrdemServico> listaOrdemServico) {
        this.listaOrdemServico = listaOrdemServico;
    }

    public DAOGenerico<OrdemServico> getDaoOrdemServico() {
        return daoOrdemServico;
    }

    public void setDaoOrdemServico(DAOGenerico<OrdemServico> daoOrdemServico) {
        this.daoOrdemServico = daoOrdemServico;
    }

    public DAOGenerico<ItensOS> getDaoItensOS() {
        return daoItensOS;
    }

    public void setDaoItensOS(DAOGenerico<ItensOS> daoItensOS) {
        this.daoItensOS = daoItensOS;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.ordemServico);
        hash = 61 * hash + Objects.hashCode(this.itensOS);
        hash = 61 * hash + Objects.hashCode(this.listaItensOS);
        hash = 61 * hash + Objects.hashCode(this.listaOrdemServico);
        hash = 61 * hash + Objects.hashCode(this.daoOrdemServico);
        hash = 61 * hash + Objects.hashCode(this.daoItensOS);
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
        final OrdemServicoMB other = (OrdemServicoMB) obj;
        if (!Objects.equals(this.ordemServico, other.ordemServico)) {
            return false;
        }
        if (!Objects.equals(this.itensOS, other.itensOS)) {
            return false;
        }
        if (!Objects.equals(this.listaItensOS, other.listaItensOS)) {
            return false;
        }
        if (!Objects.equals(this.listaOrdemServico, other.listaOrdemServico)) {
            return false;
        }
        if (!Objects.equals(this.daoOrdemServico, other.daoOrdemServico)) {
            return false;
        }
        if (!Objects.equals(this.daoItensOS, other.daoItensOS)) {
            return false;
        }
        return true;
    }
    
    

}
