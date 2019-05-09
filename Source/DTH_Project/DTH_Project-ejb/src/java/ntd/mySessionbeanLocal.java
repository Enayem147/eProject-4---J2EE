/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntd;

import javax.ejb.Local;

/**
 *
 * @author r0cklee147
 */
@Local
public interface mySessionbeanLocal {
    Integer getNewsid();

    Integer getEventid();
    
    Integer getCommentid();
}
