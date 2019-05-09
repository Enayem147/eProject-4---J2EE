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
public class News_Detail {
    NewsFacadeLocal newsFacade = lookupNewsFacadeLocal();



    public String detialNews(int news_id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = "";
        List<News> detail = newsFacade.findByNewsID(news_id);
        for (int i = 0; i < detail.size(); i++) {
            News n = detail.get(i);
            str += "<div id=\"templatemo_main\">\n"
                    + "	<div id=\"content\">\n"
                    + "    	<div class=\"post\">\n"
                    + "            	\n"
                    + "            <h2>" + n.getTitle() + "</h2>\n"
                    + "                    \n"
                    + "           <h4> <p align=\"justify\">" + n.getIntroduction() + "</p></h4>\n"
                    + "            <img id=\"img_detail\" src=\"resources/images/" + n.getImage1() + "\" width=\"600\" height=\"300\" alt=\"Image 01\" id=\"imgs\"/>   \n"
                    + "            <p align=\"justify\">" + n.getDescription1() + "</p>\n"
                    + "            <img id=\"img_detail\" src=\"resources/images/" + n.getImage2() + "\" width=\"600\" height=\"300\" alt=\"Image 01\" id=\"imgs\" />   \n"
                    + "            <p align=\"justify\">" + n.getDescription2() + "</p>\n"
                    + "          	\n"
                    + "            <div class=\"meta\">\n"
                    + "                <span class=\"admin\">" + n.getPostName() + "</span><span class=\"date\">" + sdf.format(n.getCreatedate()) + "</span><span class=\"comment\"><a href=\"#\">256 comments</a></span>\n"
                    + "                \n"
                    + "                <div class=\"cleaner\"></div>\n"
                    + "            </div> \n"
                    + "        </div>";

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
