/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connect.ConnectDb;
import com.mybean.News;
import com.mysessionbean.NewsFacadeLocal;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ManageNews {
    NewsFacadeLocal newsFacade = lookupNewsFacadeLocal();



    public boolean add(int newsid, String introduction, String title, String description1, String image1, String description2, String image2, String postname, Timestamp createdate) {
        News news = new News();
        news.setNewsID(newsid);
        news.setIntroduction(introduction);
        news.setTitle(title);
        news.setDescription1(description1);
        news.setImage1(image1);
        news.setDescription2(description2);
        news.setImage2(image2);
        news.setPostName(postname);
        news.setCreatedate(createdate);
        newsFacade.create(news);
        return true;
    }

    public boolean update(int newsid, String introduction, String title, String description1, String image1, String description2, String image2, String postname, Timestamp createdate) {
        News news = new News(newsid);
        news.setIntroduction(introduction);
        news.setTitle(title);
        news.setDescription1(description1);
        news.setImage1(image1);
        news.setDescription2(description2);
        news.setImage2(image2);
        news.setPostName(postname);
        news.setCreatedate(createdate);
        newsFacade.edit(news);
        
        return true;
    }

    public boolean delete(int newid) {
        News news = new News(newid);
        newsFacade.remove(news);
        return true;
    }

    public String listNews() {
        String str = "";
        List<News> listNews = newsFacade.findAll();
        for (int i = 0; i < listNews.size(); i++) {
            News ns = listNews.get(i);
            str += "<tr>"
                    + "<td>" + ns.getNewsID() + "</td>"
                    + "<td>" + ns.getTitle() + "</td>"
                    + "<td>" + ns.getIntroduction() + "</td>"
                    + "<td>" + ns.getDescription1() + "</td>"
                    + "<td><img src=\"../resources/images/" + ns.getImage1() + "\"width=\"200\" height=\"100\" alt=\"Image 01\" id=\"imgs\"/></td>"
                    + "<td>" + ns.getDescription2() + "</td>"
                    + "<td><img src=\"../resources/images/" + ns.getImage2() + "\"width=\"200\" height=\"100\" alt=\"Image 01\" id=\"imgs\"/></td>"
                    + "<td>" + ns.getPostName() + "</td>"
                    + "<td>" + ns.getCreatedate() + "</td>"
                    + "<td><a href=Update_News.jsp?newsId=" + ns.getNewsID() + "><img src=\"../resources/images/edit.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "<td><a href=deletenews?newsId=" + ns.getNewsID() + "><img src=\"../resources/images/del.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "</tr>";
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
