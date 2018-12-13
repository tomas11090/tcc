
package modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;


@Entity
public class Cliente extends Pessoa{
    
    private Date dataCadastro = new Date();

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.dataCadastro);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        return true;
    }
    
    
    
}
