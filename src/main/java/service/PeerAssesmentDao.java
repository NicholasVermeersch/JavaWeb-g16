
package service;

import domain.PeerAssesment;
import java.util.List;


public interface PeerAssesmentDao extends GenericDao<PeerAssesment> {

    List<PeerAssesment> getByCursistId(long id);
}
