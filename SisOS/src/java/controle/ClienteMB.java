
package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cliente;
import util.ChamarRelatorio;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable{
    private Cliente cliente;

    private DAOGenerico<Cliente> daoCliente;

    private List<Cliente> listaClientes;
    //private String nomeCliente="";
    
    public ClienteMB() {
        cliente = new Cliente();
        daoCliente = new DAOGenerico<Cliente>(Cliente.class);
        listaClientes = new ArrayList<Cliente>();
        preencherListasCliente();
    }
    
    private void preencherListasCliente() {
        listaClientes = daoCliente.buscarTodos();
    }
    
    public void remover(Long id) {
        daoCliente.excluir(id);
        preencherListasCliente();
    }
    
    public void chamarRelatorio(){
        //String consulta = "SELECT * from pessoa";
        ChamarRelatorio rel = new ChamarRelatorio();
        rel.imprimeRelatorio("relCliente.jasper", null, "Relatório_Clientes");
    }
//        public void chamarRelatorio() {
//		String consulta = "SELECT * from pessoa";
//		HashMap param = new HashMap<>();
//		param.put("TITULO_RELATORIOS", "Relatório de Clientes");
//		ChamarRelatorio.relatorio(consulta, "relCliente", 
//				"relCliente", param);
//	}
//        
//        public void chamarRelatorioConexao() {
//		//String consulta = "SELECT *from Estado";
//		HashMap param = new HashMap<>();
//		param.put("NOME_CLIENTES", nomeCliente);
//		ChamarRelatorio.relatorioConexao("relatorio_clientes", 
//				"relatorio_clientes", param);
//	}
        
    public void inserir() {
        if (cliente.getId() == null) {
            daoCliente.salvar(cliente);
        } else {
            daoCliente.alterar(cliente);
        }
        cliente = new Cliente();
        preencherListasCliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DAOGenerico<Cliente> getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(DAOGenerico<Cliente> daoCliente) {
        this.daoCliente = daoCliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

//    public String getNomeCliente() {
//        return nomeCliente;
//    }
//
//    public void setNomeCliente(String nomeCliente) {
//        this.nomeCliente = nomeCliente;
//    }
    
    
    
    
}
