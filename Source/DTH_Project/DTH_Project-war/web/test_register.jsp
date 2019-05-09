<%-- 
    Document   : test_register
    Created on : Mar 5, 2016, 10:18:19 PM
    Author     : r0cklee147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="header.jsp"/>
    <body id="box_body">

        <form id="box_form" action="index.html" method="post">

            <h1 id="box_h1">Sign Up</h1>

            <fieldset id="box_fieldset">
                <legend id="box_legend"><span class="number">1</span>Your basic info</legend>
                <label for="name">User Name: </label>
                <input id="box_textbox" type="text"  name="user_id">

                <label for="mail">Password:</label>
                <input id="box_textbox"  type="password" name="user_password">

                <label for="password">Confirm Password:</label>
                <input id="box_textbox"  type="password"  name="user_repassword">

            </fieldset>

            <fieldset id="box_fieldset">
                <legend id="box_legend"><span class="number">2</span>Your profile</legend>
                <label for="name">Full Name: </label>
                <input id="box_textbox" type="text"  name="user_name">

                <label for="bio">Address:</label>
                <textarea id="box_textbox"   name="user_bio"></textarea>

                <label for="location">Location:</label>
                <select id="box_dropdown" name="user_loca">      
                        <option value="1">Ha Noi</option>
                        <option value="2">Ho Chi Minh</option>
                        <option value="3">Da Nang</option>
                </select>

                <label for="name">Card Number: </label>
                <input id="box_textbox" type="text" name="user_card">
                
                <label for="name">Phone Number: </label>
                <input id="box_textbox" type="text"  name="user_phone">
                
                <label for="name">Email: </label>
                <input id="box_textbox" type="text"  name="user_email">
            </fieldset>
            <a class="signup" href="">Sign Up</a>
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
