/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mybean.Event;
import com.mysessionbean.EventFacadeLocal;


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
public class ManageEvent {
    EventFacadeLocal eventFacade = lookupEventFacadeLocal();




    public boolean add(int eventid, String eventname, String description, String image, Timestamp datestart, Timestamp dateend, String reward) {
        Event event = new Event();
        event.setEventID(eventid);
        event.setEventName(eventname);
        event.setDescription(description);
        event.setEventImage(image);
        event.setDateStart(datestart);
        event.setDateEnd(dateend);
        event.setReward(reward);
        eventFacade.create(event);

        return true;
    }

    public boolean update(int eventid, String eventname, String description, String image, Timestamp datestart, Timestamp dateend, String reward) {
        Event event = new Event();
        event.setEventID(eventid);
        event.setEventName(eventname);
        event.setDescription(description);
        event.setEventImage(image);
        event.setDateStart(datestart);
        event.setDateEnd(dateend);
        event.setReward(reward);
        eventFacade.edit(event);

        return true;
    }

    public boolean delete(int eventid) {
        Event event = new Event(eventid);
        eventFacade.remove(event);
        return true;
    }

    /**
     *
     * @return
     */
    public String listEvent() {
        String str = "";
        List<Event> listEvent = eventFacade.findAll();
        for (int i = 0; i < listEvent.size(); i++) {
            Event ev = listEvent.get(i);
            str += "<tr>"
                    + "<td>" + ev.getEventID() + "</td>"
                    + "<td>" + ev.getEventName() + "</td>"
                    + "<td>" + ev.getDescription()+ "</td>"
                    + "<td><img src=\"../resources/images/" + ev.getEventImage() + "\"width=\"200\" height=\"100\" alt=\"Image 01\" id=\"imgs\"/></td>"
                    + "<td>" + ev.getDateStart() + "</td>"
                    + "<td>" + ev.getDateEnd() + "</td>"
                    + "<td>" + ev.getReward() + "</td>"
                    + "<td><a href=Update_Event.jsp?eventId=" + ev.getEventID() + "><img src=\"../resources/images/edit.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "<td><a href=deleteevent?eventId=" + ev.getEventID() + "><img src=\"../resources/images/del.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "</tr>";
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
