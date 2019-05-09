<%-- 
    Document   : List_Event
    Created on : Mar 10, 2016, 9:02:44 PM
    Author     : r0cklee147
--%>

<%@page import="Model.ManageEvent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="aheader.jsp"/>
   <body>
        <h1>List Event</h1>             

        <table class="flat-table" >
            <thead>
                <tr>
                    <th>Event ID</th>
                    <th>Event Name</th>
                    <th>Description </th>
                    <th>Image </th>
                    <th>Date Start</th>
                    <th>Date End</th>
                    <th>Reward</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr> 
            </thead>
            <tbody>
                <%
                    ManageEvent m = new ManageEvent();
                    String listEvent = m.listEvent();
                    out.print(listEvent);
                %>
            </tbody>
        </table>
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
