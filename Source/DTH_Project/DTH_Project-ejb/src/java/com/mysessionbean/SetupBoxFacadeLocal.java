/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysessionbean;

import com.mybean.SetupBox;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author r0cklee147
 */
@Local
public interface SetupBoxFacadeLocal {

    void create(SetupBox setupBox);

    void edit(SetupBox setupBox);

    void remove(SetupBox setupBox);

    SetupBox find(Object id);

    List<SetupBox> findAll();

    List<SetupBox> findRange(int[] range);

    int count();

    public List<SetupBox> findBySetId(int set_id);
    
}
