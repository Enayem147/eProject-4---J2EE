/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mybean.News;
import com.mysessionbean.NewsFacadeLocal;

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
public class List_News {
    NewsFacadeLocal newsFacade = lookupNewsFacadeLocal();



    public String listNew() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = "";
        List<News> listNews = newsFacade.findAll();
        for (int i = 0; i < listNews.size(); i++) {
            News n = listNews.get(i);
            str += "<form action=\"newsservlet?newsid=" + n.getNewsID() + "\" method=\"post\">"
                    + "<div class=\"post\">\n"
                    + "\n"
                    + "                <h2>" + n.getTitle() + "</h2>\n"
                    + "\n"
                    + "                <img src=\"resources/images/" + n.getImage1() + "\" alt=\"Image 01\" id=\"imgs\"/>   \n"
                    + "             <p>" + n.getIntroduction() + "</p>\n"
                    + "                <div class=\"meta\">\n"
                    + "                    <span class=\"admin\">" + n.getPostName() + "</span><span class=\"date\">" + sdf.format(n.getCreatedate()) + "</span><span class=\"comment\"><a href=\"#\">132 comments</a></span>\n"
                    + "                    <span class=\"more_but\"><button type=\"submit\" class=\"more\">Read More</button></span>\n"
                    + "                    <div class=\"cleaner\"></div>\n"
                    + "                </div> \n"
                    + "            </div>"
                    + "</form>";
        }
        return str;
    }

    private NewsFacadeLocal lookupNewsFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (NewsFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/NewsFacade!com.mysessionbean.NewsFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }



}
