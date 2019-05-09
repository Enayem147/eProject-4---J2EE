/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.Channel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author r0cklee147
 */
@Stateless
public class ChannelFacade extends AbstractFacade<Channel> implements ChannelFacadeLocal {
    @PersistenceContext(unitName = "DTH_Project-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChannelFacade() {
        super(Channel.class);
    }
    
}
