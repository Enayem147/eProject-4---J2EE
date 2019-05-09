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
public class Event_Detail {
    EventFacadeLocal eventFacade = lookupEventFacadeLocal();



    public String detialEvent(int event_id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = "";
        List<Event> detail = eventFacade.findByEventID(event_id);
        for (int i = 0; i < detail.size(); i++) {
            Event e = detail.get(i);
            str += "<div id=\"templatemo_main\">\n"
                    + "	<div id=\"content\">\n"
                    + "    	<div class=\"post\">\n"
                    + "            	\n"
                    + "            <h2>" + e.getEventName() + "</h2>\n"
                    + "                    \n"
                    + "            <img id=\"img_detail\" src=\"resources/images/" + e.getEventImage() + "\" alt=\"Image 01\" id=\"imgs\"/>   \n"
                    + "            <p align=\"justify\">" + e.getDescription()+ "</p>\n"
                    + "          <h3>  <p align=\"justify\">Date Start:   " + sdf.format(e.getDateStart()) + "</p></h3>\n"
                    + "          <h3>  <p align=\"justify\">Date End:     " + sdf.format(e.getDateEnd()) + "</p></h3>\n"
                    + "          	\n"
                    + "             <h4><p>" +e.getReward() + "</h4></p>\n"
                    + "            <div class=\"meta\">\n"
                    + "                <span class=\"admin\">Admin</span><span class=\"date\">" + sdf.format(e.getDateStart()) + "</span><span class=\"comment\"><a href=\"#\">256 comments</a></span>\n"
                    + "                \n"
                    + "                <div class=\"cleaner\"></div>\n"
                    + "            </div> \n"
                    + "        </div>";

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
