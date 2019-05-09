/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myModel;

import com.mybean.Event;
import com.mysessionbean.EventFacadeLocal;
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
public class List_Event {
    EventFacadeLocal eventFacade = lookupEventFacadeLocal();

    
    public String listEvent(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = "";
        List<Event> listevent = eventFacade.findAll();
        for (int i = 0; i < listevent.size(); i++) {
            Event e = listevent.get(i);
            str += "<form action=\"eventservlet?eventID="+e.getEventID()+"\" method=\"post\">"
                    + "<div class=\"post\">\n"
                    + "\n"
                    + "                <h2>"+e.getEventName()+"</h2>\n"
                    + "\n"
                    + "                <img src=\"resources/images/" + e.getEventImage()+ "\" alt=\"Image 01\" id=\"imgs\"/>   \n"
                    + "             <h4><p>" +e.getDescription()+ "</h4></p>\n"
                    + "                <div class=\"meta\">\n"
                    + "                    <span class=\"admin\">Admin</span><span class=\"date\">" + sdf.format(e.getDateStart()) + "</span><span class=\"comment\"><a href=\"#\">132 comments</a></span>\n"
                    
                    + "                    <span class=\"more_but\"><button type=\"submit\" class=\"more\">Read More</button></span>\n"
                    + "                    <div class=\"cleaner\"></div>\n"
                    + "                </div> \n"
                    + "            </div>"
                    + "</form>";
        }
            return str;
    }

    private EventFacadeLocal lookupEventFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (EventFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/EventFacade!com.mysessionbean.EventFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    

    
    
}
