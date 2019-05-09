<%-- 
    Document   : Update_Event
    Created on : Mar 6, 2016, 12:00:58 PM
    Author     : ASUS
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Connect.ConnectDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Connect.ConnectDb connect = new ConnectDb();
    PreparedStatement pst = null;
    ResultSet rs = null;
%>
<%
    int eventId = 0;
    String eventname = "";
    String des = "";   
    String img = "";
    String date1 = "";
    String date2 = "";
    String reward = "";
    
    
    
    if (request.getParameter("eventId") != null ) {
        eventId = Integer.parseInt(request.getParameter("eventId"));
        
    }
    
    Connection connUpdate = connect.connectMyWebDb();
    pst = connUpdate.prepareStatement("Select Event_ID, Event_Name,Description,Event_Image,Date_Start,Date_End,Reward from Event where Event_ID = ?");
    pst.setInt(1, eventId);
    rs = pst.executeQuery();
    if (rs.next()) {
        eventname = rs.getString("Event_Name");
        des = rs.getString("Description");
        img = rs.getString("Event_Image");
        date1 = rs.getString("Date_Start");
        date2 = rs.getString("Date_End");
        reward = rs.getString("Reward");
        

    }
    session.setAttribute("id", eventId);

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
        <title>Update Events</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#datepicker1").datepicker();
            });
        </script>
        <script>
            $(function () {
                $("#datepicker2").datepicker();
            });
        </script>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body id="box_body">       

        <form id="box_form" action="./../updateevent" enctype="multipart/form-data"  method="post">

            <h1 id="box_h1">Update Event</h1>
            <fieldset id="box_fieldset">

                <label for="event">Event Name: </label>
                <input value="<%=eventname%>" class="box_textbox" type="text"  name="txtEventName">

                <label for="decription">Decription:</label>
                <textarea value=""  class="box_textbox"   name="txtDecription"><%=des%></textarea>

                <label for="datestard">Date Start:</label>
                <input value="<%=date1%>" class="box_textbox" type="text" id="datepicker1" name="txtStart">

                <label for="dateend">Date End:</label>
                <input value="<%=date2%>" class="box_textbox" type="text" id="datepicker2" name="txtEnd">

                <label for="image">Image:</label>
                <input value="<%=img%>" name="image" class="box_textbox" type="file"/>

                <label for="reward">Reward:</label>
                <select id="box_dropdown" name="dlReward">   
                    <option value="1">Choose Discount</option>
                    <option value="2">Discount 10%</option>
                    <option value="3">Discount 20%</option>
                    <option value="4">Discount 30%</option>
                    <option value="5">Discount 50%</option>
                </select>

            </fieldset>
            <input class="signup" type="submit" value="Update" />
        </form>
    </body>
    <jsp:include page="afooter.jsp"/>

</body>
</html>
