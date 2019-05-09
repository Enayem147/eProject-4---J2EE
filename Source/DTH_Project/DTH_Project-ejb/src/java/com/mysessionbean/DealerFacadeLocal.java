/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.Dealer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author r0cklee147
 */
@Local
public interface DealerFacadeLocal {

    void create(Dealer dealer);

    void edit(Dealer dealer);

    void remove(Dealer dealer);

    Dealer find(Object id);

    List<Dealer> findAll();

    List<Dealer> findRange(int[] range);

    int count();

    public List<Dealer> findByDeaID(String dea_id);
    
}
