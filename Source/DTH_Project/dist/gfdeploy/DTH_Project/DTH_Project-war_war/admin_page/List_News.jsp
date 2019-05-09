<%-- 
    Document   : List_News
    Created on : Mar 8, 2016, 8:33:06 PM
    Author     : ASUS
--%>

<%@page import="Model.ManageNews"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body class="flat-table">
   
                    <h1>List News</h1>             
                
                    <table >
                        <thead>
                            <tr>
                                <th>News ID</th>
                                <th>Title</th>
                                <th>Introduction</th>
                                <th>Description 1</th>
                                <th>Image 1</th>
                                <th>Description 2</th>
                                <th>Image 2</th>
                                <th>Post Name</th>
                                <th>Delete</th>
                                <th>Edit</th>
                            </tr> 
                        </thead>
                        <tbody>
                           <%
                                ManageNews m = new ManageNews();
                                String listNews = m.listNews();
                                out.print(listNews);
                           %>
                        </tbody>
                    </table>
               
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
