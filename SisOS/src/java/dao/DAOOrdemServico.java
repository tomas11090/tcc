
package dao;

import fabrica.Fabrica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Venda;

public class DAOOrdemServico {
    private static EntityManager entityManager = Fabrica.getFabrica().getEm();
    public List<Venda> buscarOrdemServiço(String email){
        Query query = null;
        try{
            query = entityManager.createQuery("from OrdemServico where usuario.email='" + email + "'");
        }catch(Exception e){
            e.printStackTrace();
        }
        return query.getResultList();
    }
}
