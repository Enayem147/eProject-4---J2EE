<%-- 
    Document   : Add_News
    Created on : Mar 6, 2016, 11:39:10 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
        <title>Add News</title>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body id="box_body">       

        <form id="box_form" enctype="multipart/form-data"  action="./../addnews" method="post">

            <h1 id="box_h1">Add News</h1>
            <fieldset id="box_fieldset">
            
                    <label for="title"> Title: </label>
                    <textarea class="box_textbox" type="text" required="true"  name="txtTitle"></textarea>

                    <label for="introduction:">Introduction:</label>
                    <textarea class="box_textbox" required="true"  name="txtIntroduction"></textarea>

                    <label for="image1">Image 1:</label>
                    <input class="box_textbox" type="file" required="true" name="image1"/>


                    <label for="decription1">Decription of image 1:</label>
                    <textarea class="box_textbox" required="true"  name="txtDecription1"></textarea>

                    <label for="image2">Image 2:</label>
                    <input class="box_textbox" type="file" required="true" name="image2"/>

                    <label for="decription2">Decription of image 2:</label>
                    <textarea class="box_textbox" required="true"  name="txtDecription2"></textarea>

                    <label for="post">Post Name: </label>
                    <input class="box_textbox" type="text" required="true" name="txtPost">

                    
            </fieldset>

            <button type="submit" class="signup" href="">Add News</button>
        </form>

    </body>
    <jsp:include page="afooter.jsp"/>
</html>
