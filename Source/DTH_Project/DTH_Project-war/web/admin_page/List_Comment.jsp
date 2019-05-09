<%-- 
    Document   : List_Comment
    Created on : Mar 9, 2016, 5:01:30 PM
    Author     : ASUS
--%>

<%@page import="Model.ManageComment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body class="flat-table">
        <h1>List Comment</h1>             

        <table >
            <thead>
                <tr>
                    <th>Commnet ID</th>
                    <th>Name</th>
                    <th>Email </th>
                    <th>Comment </th>
                    <th>Date </th>                    
                    <th>Delete</th>
                    
                </tr> 
            </thead>
            <tbody>
                <%
                    ManageComment m = new ManageComment();
                    String listCom = m.listComment();
                    out.print(listCom);
                %>
            </tbody>
        </table>
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
