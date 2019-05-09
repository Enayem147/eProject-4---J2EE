<%-- 
    Document   : Event_List
    Created on : Mar 10, 2016, 7:12:31 PM
    Author     : r0cklee147
--%>

<%@page import="myModel.List_Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="header.jsp"/>
    <body>
        <div id="content">
           <%
                List_Event l = new List_Event();
                String list = l.listEvent();
                out.print(list);
           %>
           <img src="resources/d1.jpg" alt=""/>

            <div class="pagging">
                <ul>
                    <li><a href="#">Previous</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </div>
            <div class="cleaner"></div>
        </div>

        <div id="sidebar">
            <ul class="templatemo_list">
            <input class="news_textbox" type="text"  name="txtSearch">
            
            <button type="submit">Search</button>
            </ul>

            <div class="cleaner h30"></div>
        </div> <!-- end of sidebar -->
        <div class="cleaner"></div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
