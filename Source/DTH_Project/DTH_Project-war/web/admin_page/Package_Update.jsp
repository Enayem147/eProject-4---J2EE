<%-- 
    Document   : Package_Update
    Created on : Mar 10, 2016, 1:32:05 AM
    Author     : r0cklee147
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="myConnect.DTHConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Package</title>
    </head>
    <%
        DTHConnection connect = new DTHConnection();
        Connection conn;
        PreparedStatement comm = null;
        ResultSet rs = null;
        conn = connect.getDTHConnect();
        
        
        String pack_id = request.getParameter("packID");
        String pack_name="";
        String description="";
        double price=0.0;
        double discount=0.0;
        
        comm = conn.prepareStatement("select Package_Name , Description , Price_Per_Month , Discount from Packages where Package_ID=?");
        comm.setString(1, pack_id);
        rs = comm.executeQuery();
        if(rs.next()){
            pack_name = rs.getString(1);
            description = rs.getString(2);
            price = rs.getDouble(3);
            discount=rs.getDouble(4);
        }
        
    %>
    <jsp:include page="aheader.jsp"/>
    <body id="box_body">       
        <form id="box_form" action="./../updatePackage" method="post">

            <h1 id="box_h1">Update Package</h1>

            <fieldset id="box_fieldset">  
                <label for="id">Package ID: </label>
                <input readonly="true" class="box_textbox" type="text" value="<%=pack_id%>"  name="txtPackageID">

                <label for="name">Package Name: </label>
                <input class="box_textbox" type="text" value="<%=pack_name%>"  name="txtPackageName" >

                <label for="setupbox">Setup Box:</label>
                <select id="box_dropdown" name="dlSetupBox" >      
                    <%
                        
                        int set_id = 0;
                        String set_name = "";
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
                <textarea class="box_textbox"name="txtDescription" ><%=description%></textarea>

                <label for="price">Price per Month: </label>
                <input class="box_textbox" type="number" value="<%=price%>" name="txtPrice" >

                <label for="discount">Discount: </label>
                <input class="box_textbox" type="number" value="<%=discount%>"  name="txtDiscount" >
            </fieldset>
            <button type="submit" class="signup" href="">Save</button>
        </form>
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
