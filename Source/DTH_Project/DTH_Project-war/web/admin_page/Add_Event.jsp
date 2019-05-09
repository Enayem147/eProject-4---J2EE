<%-- 
    Document   : Add_Event
    Created on : Mar 10, 2016, 8:37:17 PM
    Author     : r0cklee147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
        <title>Add new Events</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#datepicker1").datepicker();
            });
        </script>
        <script>
            $(function () {
                $("#datepicker2").datepicker();
            });
        </script>
    </head>
    <jsp:include page="aheader.jsp"/>
    <body id="box_body">       

        <form id="box_form" enctype="multipart/form-data" action="./../addevent" method="post">

            <h1 id="box_h1">Add New Event</h1>
            <fieldset id="box_fieldset">

                <label for="event">Event Name: </label>
                <input class="box_textbox" type="text" required="true"  name="txtEventName">

                <label for="decription">Description:</label>
                <textarea class="box_textbox" required="true"  name="txtDecription"></textarea>

                <label for="datestard">Date Start:</label>
                <input class="box_textbox" type="text" id="datepicker1" name="txtStart">

                <label for="dateend">Date End:</label>
                <input class="box_textbox" type="text" id="datepicker2" name="txtEnd">

                <label for="image">Image:</label>
                <input class="box_textbox" required="true" name="image" type="file"/>

                <label for="reward">Reward:</label>
                <select id="box_dropdown" name="dlReward"> 
                    <option value="1">Choose Discount</option>
                    <option value="2">Discount 10%</option>
                    <option value="3">Discount 20%</option>
                    <option value="4">Discount 30%</option>
                    <option value="5">Discount 50%</option>
                </select>

            </fieldset>

            <input class="signup" type="submit" value="Add Event" />
        </form>
    </body>
    <jsp:include page="afooter.jsp"/>
</html>
