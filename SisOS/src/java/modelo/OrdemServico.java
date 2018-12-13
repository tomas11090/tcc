
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class OrdemServico implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Cliente cliente;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dtOrdemServico = new Date();
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dtEncerramentoOrdemServico = new Date();
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dtVencimento = new Date();
    
    private Double precoOrdemServico;
    private Double valorTotalOrdemServico;
    
    @ManyToOne
    private Usuario usuario;
    
    private String observacao;
    
    private String status;

    public OrdemServico(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDtOrdemServico() {
        return dtOrdemServico;
    }

    public void setDtOrdemServico(Date dtOrdemServico) {
        this.dtOrdemServico = dtOrdemServico;
    }

    public Date getDtEncerramentoOrdemServico() {
        return dtEncerramentoOrdemServico;
    }

    public void setDtEncerramentoOrdemServico(Date dtEncerramentoOrdemServico) {
        this.dtEncerramentoOrdemServico = dtEncerramentoOrdemServico;
    }

    public Double getPrecoOrdemServico() {
        return precoOrdemServico;
    }

    public void setPrecoOrdemServico(Double precoOrdemServico) {
        this.precoOrdemServico = precoOrdemServico;
    }

    public Double getValorTotalOrdemServico() {
        return valorTotalOrdemServico;
    }

    public void setValorTotalOrdemServico(Double valorTotalOrdemServico) {
        this.valorTotalOrdemServico = valorTotalOrdemServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.cliente);
        hash = 13 * hash + Objects.hashCode(this.dtOrdemServico);
        hash = 13 * hash + Objects.hashCode(this.dtEncerramentoOrdemServico);
        hash = 13 * hash + Objects.hashCode(this.dtVencimento);
        hash = 13 * hash + Objects.hashCode(this.precoOrdemServico);
        hash = 13 * hash + Objects.hashCode(this.valorTotalOrdemServico);
        hash = 13 * hash + Objects.hashCode(this.usuario);
        hash = 13 * hash + Objects.hashCode(this.observacao);
        hash = 13 * hash + Objects.hashCode(this.status);
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
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.dtOrdemServico, other.dtOrdemServico)) {
            return false;
        }
        if (!Objects.equals(this.dtEncerramentoOrdemServico, other.dtEncerramentoOrdemServico)) {
            return false;
        }
        if (!Objects.equals(this.dtVencimento, other.dtVencimento)) {
            return false;
        }
        if (!Objects.equals(this.precoOrdemServico, other.precoOrdemServico)) {
            return false;
        }
        if (!Objects.equals(this.valorTotalOrdemServico, other.valorTotalOrdemServico)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
}
