/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.Packages;
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
public class PackagesFacade extends AbstractFacade<Packages> implements PackagesFacadeLocal {
    @PersistenceContext(unitName = "DTH_Project-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PackagesFacade() {
        super(Packages.class);
    }
    public List<Packages> findByPackageID(String pack_id) {
        Query query = em.createNamedQuery("Packages.findByPackageID");
        query.setParameter("packageID", pack_id);
        return query.getResultList();
    }
}
