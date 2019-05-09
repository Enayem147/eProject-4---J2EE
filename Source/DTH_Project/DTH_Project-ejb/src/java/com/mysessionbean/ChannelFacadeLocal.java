/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.Channel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author r0cklee147
 */
@Local
public interface ChannelFacadeLocal {

    void create(Channel channel);

    void edit(Channel channel);

    void remove(Channel channel);

    Channel find(Object id);

    List<Channel> findAll();

    List<Channel> findRange(int[] range);

    int count();
    
}
