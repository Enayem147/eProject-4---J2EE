<%-- 
    Document   : Package_Add
    Created on : Mar 8, 2016, 11:23:25 AM
    Author     : r0cklee147
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="myConnect.DTHConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        myConnect.DTHConnection connect = new DTHConnection();
        PreparedStatement comm = null;
        ResultSet rs = null;
    %>
    ${exist}
    <jsp:include page="aheader.jsp"/>
    <body id="box_body">       
        <form id="box_form" action="./../addPackage" method="post">

            <h1 id="box_h1">Add new Package</h1>

            <fieldset id="box_fieldset">  
                <label for="id">Package ID: </label>
                <input class="box_textbox" type="text"  name="txtPackageID" placeholder="Input Package ID">

                <label for="name">Package Name: </label>
                <input class="box_textbox" type="text"  name="txtPackageName" placeholder="Input Package Name">

                <label for="setupbox">Setup Box:</label>
                <select id="box_dropdown" name="dlSetupBox" >      
                    <%
                        int set_id = 0;
                        String set_name = "";
                        Connection conn = connect.getDTHConnect();
                        comm = conn.prepareStatement("Select Set_ID,Set_Name from SetupBox");
                        rs = comm.executeQuery();
                        while (rs.next()) {
                            set_id = rs.getInt("Set_ID");
                            set_name = rs.getString("Set_Name");
                    %>
                    <option value="<%=set_id%>"><%=set_name%></option>
                    <%
                        }
                    %>

                </select>   

                <label for="descriotion">Description: </label>
                <textarea class="box_textbox"   name="txtDescription" placeholder="Input Package Description"></textarea>
                
                <label for="price">Price per Month: </label>
                <input class="box_textbox" type="number" name="txtPrice" placeholder="$">

                <label for="discount">Discount: </label>
                <input class="box_textbox" type="number"  name="txtDiscount" placeholder="%">
            </fieldset>
            <button type="submit" class="signup" href="">Add</button>
        </form>
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
