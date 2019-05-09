<%-- 
    Document   : test_login
    Created on : Mar 5, 2016, 10:18:03 PM
    Author     : r0cklee147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Order Summary</title>
    </head>
    <jsp:include page="header.jsp"/>
    <body>

        
        <div id="content">
            <h2> Package Name</h2>
            <h4>Package Detail</h4>
            <hr/>
            <p>Discount : 5% </p>
            <p>Price Discount : $475 per month</p>
            <p></p>
            <p>Curabitur viverra massa ut felis interdum suscipit. Duis rhoncus semper orci, vitae suscipit nunc ultricies </p>
            <h5><b>188 + </b> Channels</h5>
            <div class="cleaner h30"></div>
            <div class="about_box">
                <h4>Setup Box</h4>
                <hr/>
                <img src="resources/images/upload/setupbox/setup2.png" alt="User 02" />
                <p>Price</p>
                <div class="cleaner"></div>
            </div>

        </div>
        <div id="sidebar">
            <h2>Result</h2>
            <div class="testimonial">
                <p>TOtal Price</p>
                <cite>Steven <a href="#"><span>- Web Designer</span></a></cite>
            </div>
            
            <button type="submit">Subscribe</button>
            
            
        </div> 

        <div class="cleaner"></div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
