/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mybean.Comment;
import com.mysessionbean.CommentFacadeLocal;

import java.text.SimpleDateFormat;
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
public class List_Comment {
    CommentFacadeLocal commentFacade = lookupCommentFacadeLocal();



    public String listComment() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = "";
        List<Comment> listComment = commentFacade.findAll();
        for (int i = 0; i < listComment.size(); i++) {
            Comment n = listComment.get(i);
            str += "<li>\n"
                    + "                            <div class=\"comment_box commentbox1\">\n"
                    + "                                    \n"
                    + "                                <div class=\"gravatar\">\n"
                    + "                                    <img class=\"image_frame\" src=\"resources/images/avator.png\" alt=\"author 6\" />\n"
                    + "                                </div>\n"
                    + "                                \n"
                    + "                                <div class=\"comment_text\">\n"
                    + "                                    <div class=\"comment_author\">"+n.getName()+"<span class=\"date\">"+n.getDate()+"</span> </div>\n"
                    + "                                    <p>"+n.getComment()+"</p>\n"
                    + "                                  <div class=\"reply\"><a href=\"#\">Reply</a></div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"cleaner\"></div>\n"
                    + "                            </div> \n"
                    + "                        </li>";
                    
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
