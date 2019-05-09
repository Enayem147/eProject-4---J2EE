/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.News;
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
public class NewsFacade extends AbstractFacade<News> implements NewsFacadeLocal {

    @PersistenceContext(unitName = "DTH_Project-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }

    public List<News> findByNewsID(int newsid) {
        Query qs = em.createNamedQuery("News.findByNewsID");
        qs.setParameter("newsID", newsid);
        return qs.getResultList();
    }

}
