<%-- 
    Document   : Register
    Created on : Mar 5, 2016, 2:23:21 PM
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

        <title>Register</title>

    </head>
    <jsp:include page="header.jsp"/>
    <%
        myConnect.DTHConnection connect = new DTHConnection();
        PreparedStatement comm = null;
        ResultSet rs = null;
    %>
    <body id="box_body">       

        <form id="box_form" action="registerServlet" method="post">

            <h1 id="box_h1">Register</h1>

            <fieldset id="box_fieldset">
                <legend id="box_legend"><span class="number">1</span>Your basic info</legend>
                <label for="name">User Name: </label>
                <input class="box_textbox" type="text"  name="txtUsername">

                <label for="mail">Password:</label>
                <input class="box_textbox"  type="password" name="txtPassword">

                <label for="password">Confirm Password:</label>
                <input class="box_textbox"  type="password"  name="txtRePassword">

            </fieldset>


            <fieldset id="box_fieldset">
                <legend id="box_legend"><span class="number">2</span>Your profile</legend>
                <label for="name">Full Name: </label>
                <input class="box_textbox" type="text"  name="txtFullname">

                <label for="address">Address:</label>
                <textarea class="box_textbox"   name="txtAddress"></textarea>

                <label for="location">Location:</label>
                <select id="box_dropdown" name="dlLocation">      
                    <%
                        int loca_id = 0;
                        String loca_name = "";
                        Connection conn = connect.getDTHConnect();
                        comm = conn.prepareStatement("Select Location_ID,Location_Name from Location");
                        rs = comm.executeQuery();
                        while (rs.next()) {
                            loca_id = rs.getInt("Location_ID");
                            loca_name = rs.getString("Location_Name");
                    %>
                    <option value="<%=loca_id%>"><%=loca_name%></option>
                    <%
                        }
                    %>
                </select>

                <label for="name">Card Number: </label>
                <input class="box_textbox" type="number" name="txtCardNumber">

                <label for="name">Phone Number: </label>
                <input class="box_textbox" type="number"  name="txtPhone">

                <label for="name">Email: </label>
                <input class="box_textbox" type="email"  name="txtEmail">
            </fieldset>
            <button type="submit" class="signup">Register</button>
        </form>
    </body>
    <jsp:include page="footer.jsp"/>
</body>
</html>
