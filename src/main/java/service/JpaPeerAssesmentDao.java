
package service;

import domain.Cursist;
import domain.PeerAssesment;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("peerAssesmentDao")
public class JpaPeerAssesmentDao extends GenericDaoJpa<PeerAssesment> implements PeerAssesmentDao {

    public JpaPeerAssesmentDao() {
        super(PeerAssesment.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeerAssesment> getByCursistId(long id) {
        TypedQuery<PeerAssesment> query
                = em.createNamedQuery(
                        "PeerAssesment.getById", PeerAssesment.class);
        query.setParameter(
                "id", id);
        return query.getResultList();
    }

}
