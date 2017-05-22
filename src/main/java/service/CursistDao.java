/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Cursist;

/**
 *
 * @author henrivdb
 */
public interface CursistDao extends GenericDao<Cursist>
{        
    public Cursist getByUsername(String username);
}
