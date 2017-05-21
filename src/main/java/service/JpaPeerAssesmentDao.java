/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Cursist;
import domain.PeerAssesment;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author henrivdb
 */
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
