/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.Dealer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author r0cklee147
 */
@Stateless
public class DealerFacade extends AbstractFacade<Dealer> implements DealerFacadeLocal {
    @PersistenceContext(unitName = "DTH_Project-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DealerFacade() {
        super(Dealer.class);
    }
    public List<Dealer> findByDeaID(String dea_id) {
        Query query = em.createNamedQuery("Dealer.findByDeaID");
        query.setParameter("deaID", dea_id);
        return query.getResultList();
    }
    
}
