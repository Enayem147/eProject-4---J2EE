/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.Packages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author r0cklee147
 */
@Local
public interface PackagesFacadeLocal {

    void create(Packages packages);

    void edit(Packages packages);

    void remove(Packages packages);

    Packages find(Object id);

    List<Packages> findAll();

    List<Packages> findRange(int[] range);

    int count();

    public List<Packages> findByPackageID(String pack_id);
    
}
