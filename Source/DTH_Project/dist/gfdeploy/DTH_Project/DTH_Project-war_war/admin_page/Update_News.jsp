<%-- 
    Document   : Update_News
    Created on : Mar 6, 2016, 11:59:25 AM
    Author     : ASUS
--%>

<%@page import="Connect.ConnectDb"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Connect.ConnectDb connect = new ConnectDb();
    PreparedStatement pst = null;
    ResultSet rs = null;
%>
<%
    int newsId = 0;
    String title = "";
    String intro = "";
    String des1 = "";
    String img1 = "";
    String des2 = "";
    String img2 = "";
    String postname = "";
    
    
    
    if (request.getParameter("newsId") != null ) {
        newsId = Integer.parseInt(request.getParameter("newsId"));
        
    }
    
    Connection connUpdate = connect.connectMyWebDb();
    pst = connUpdate.prepareStatement("Select News_ID, Introduction,Title,Description1,Image1,Description2,Image2,Post_Name from News where News_ID = ?");
    pst.setInt(1, newsId);
    rs = pst.executeQuery();
    if (rs.next()) {
        title = rs.getString("Introduction");
        intro = rs.getString("Title");
        des1 = rs.getString("Description1");
        img1 = rs.getString("Image1");
        des2 = rs.getString("Description2");
        img2 = rs.getString("Image2");
        postname = rs.getString("Post_Name");

    }
    session.setAttribute("id", newsId);

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
        <title>Update News</title>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body id="box_body">       

        <form id="box_form" action="updatenews" enctype="multipart/form-data" method="post">

            <h1 id="box_h1">Update News</h1>
            <fieldset id="box_fieldset">

                <label for="ID"> News ID: </label>
                <input value="<%=newsId%>" class="box_textbox" type="text"  name="txtNewsID">
                
                <label for="title"> Title: </label>
                <textarea value="" class="box_textbox" type="text"  name="txtTitle"><%=title%></textarea>

                <label for="introduction">Introduction:</label>
                <textarea value="" class="box_textbox"   name="txtIntro"><%=intro%></textarea>

                    <label for="image1">Image 1:</label>
                    <input value="<%=img1%>" name="image1" class="box_textbox" type="file"/>


                    <label for="decription1">Decription of image 1:</label>
                    <textarea value="" class="box_textbox"   name="txtDecription1"><%=des1%></textarea>

                    <label for="image2">Image 2:</label>
                    <input value="<%=img2%>" name="image2" class="box_textbox" type="file"/>

                    <label for="decription2">Decription of image 2:</label>
                    <textarea value="" class="box_textbox"   name="txtDecription2"><%=des2%></textarea>

                    <label for="post">Post Name: </label>
                    <input value="<%=postname%>" class="box_textbox" type="text"  name="txtPost">
            </fieldset>
            
        
            <input class="signup" type="submit" value="Update" />
        </form>

    </body>
    <jsp:include page="afooter.jsp"/>
</html>
