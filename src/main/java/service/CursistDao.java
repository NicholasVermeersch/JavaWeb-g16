
package service;

import domain.Cursist;


public interface CursistDao extends GenericDao<Cursist>
{        
    public Cursist getByUsername(String username);
}
