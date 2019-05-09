/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mybean.Comment;
import com.mysessionbean.CommentFacadeLocal;


import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class ManageComment {
    CommentFacadeLocal commentFacade = lookupCommentFacadeLocal();




    public boolean add(int cmid, String name, String email, String comment, Timestamp date) {
        Comment cm = new Comment();
        cm.setCommentID(cmid);
        cm.setName(name);
        cm.setEmail(email);
        cm.setComment(comment);
        cm.setDate(date);
        commentFacade.create(cm);
        return true;
    }

    public boolean delete(int cmid) {
        Comment cm = new Comment(cmid);
        commentFacade.remove(cm);
        return true;
    }

    public String listComment() {
        String str = "";
        List<Comment> listCom = commentFacade.findAll();
        for (int i = 0; i < listCom.size(); i++) {
            Comment cm = listCom.get(i);
            str += "<tr>"
                    + "<td>" + cm.getCommentID() + "</td>"
                    + "<td>" + cm.getName() + "</td>"
                    + "<td>" + cm.getEmail() + "</td>"
                    + "<td>" + cm.getComment() + "</td>"
                    + "<td>" + cm.getDate()+ "</td>"
                    + "<td><a href=../deletecomment?commId=" + cm.getCommentID() + "><img src=\"../resources/images/del.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "</tr>";
        }
        return str;
    }

    private CommentFacadeLocal lookupCommentFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CommentFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/CommentFacade!com.mysessionbean.CommentFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }




}
