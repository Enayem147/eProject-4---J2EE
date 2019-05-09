<%-- 
    Document   : Package_List
    Created on : Mar 8, 2016, 11:23:34 AM
    Author     : r0cklee147
--%>

<%@page import="myModel.PackageModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body>

        <h1>Package List</h1>
        <hr/>
        <table class="flat-table">
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Set-up Box</th>
                    <th>Description</th>
                    <th>Price per Month</th>
                    <th>Discount</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <%
                    PackageModel model = new PackageModel();
                    String list = model.list();
                    out.print(list);
                %>
            </tbody>
        </table>
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
