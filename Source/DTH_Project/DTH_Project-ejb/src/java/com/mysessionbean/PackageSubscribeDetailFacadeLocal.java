/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.PackageSubscribeDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author r0cklee147
 */
@Local
public interface PackageSubscribeDetailFacadeLocal {

    void create(PackageSubscribeDetail packageSubscribeDetail);

    void edit(PackageSubscribeDetail packageSubscribeDetail);

    void remove(PackageSubscribeDetail packageSubscribeDetail);

    PackageSubscribeDetail find(Object id);

    List<PackageSubscribeDetail> findAll();

    List<PackageSubscribeDetail> findRange(int[] range);

    int count();
    
}
