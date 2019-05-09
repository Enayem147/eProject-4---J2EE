/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.SetupBox;
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
public class SetupBoxFacade extends AbstractFacade<SetupBox> implements SetupBoxFacadeLocal {

    @PersistenceContext(unitName = "DTH_Project-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SetupBoxFacade() {
        super(SetupBox.class);
    }

    public List<SetupBox> findBySetId(int set_id) {
        Query query = em.createNamedQuery("SetupBox.findBySetID");
        query.setParameter("setID", set_id);
        return query.getResultList();
    }

}
