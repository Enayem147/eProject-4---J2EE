<%-- 
    Document   : Login
    Created on : Mar 4, 2016, 2:58:20 PM
    Author     : r0cklee147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
    </head>
    ${register}
    ${error}
    <jsp:include page="header.jsp"/>
    <body id="box_body">       

        
        <form id="box_form" action="loginservlet" method="post">

            <h1 id="box_h1">Login</h1>

            <fieldset id="box_fieldset">  
                <label for="name">User Name: </label>
                <input class="box_textbox" type="text"  name="txtUserID" >

                <label for="mail">Password:</label>
                <input class="box_textbox"  type="password" name="txtPassword">   

                <label for="role">Role:</label> 
                <input type="radio" value="customer" name="rdRole"><label for="customer" class="light">Customer</label>
                <input type="radio" value="dealer" name="rdRole"><label for="dealer" class="light">Dealer</label>
                <input type="radio" value="admin" name="rdRole"><label for="admin" class="light">Administrator</label>
            </fieldset>

            <button type="submit" class="signup">Login</button>
        </form>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
