/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.PeerAssesment;
import java.util.List;

/**
 *
 * @author henrivdb
 */
public interface PeerAssesmentDao extends GenericDao<PeerAssesment> {

    List<PeerAssesment> getByCursistId(long id);
}
