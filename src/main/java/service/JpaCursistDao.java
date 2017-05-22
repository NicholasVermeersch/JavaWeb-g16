
package service;

import domain.Cursist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("cursistDao")
public class JpaCursistDao extends GenericDaoJpa<Cursist> implements CursistDao {

    public JpaCursistDao() {
        super(Cursist.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Cursist getByUsername(String username) {
        TypedQuery<Cursist> query
                = em.createNamedQuery(
                        "Cursist.getByUsername", Cursist.class);
        query.setParameter(
                "username", username);
        return query.getResultList().get(0);
    }

}
