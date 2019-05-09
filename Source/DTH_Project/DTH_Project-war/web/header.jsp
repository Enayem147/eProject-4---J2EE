<%-- 
    Document   : header
    Created on : Mar 4, 2016, 2:16:01 PM
    Author     : r0cklee147
--%>

<%@page import="myModel.CustomerModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/eve_news.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bordercss.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/templatemo_style.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="resources/css/ddsmoothmenu.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/mycss.css" />

        <script type="text/javascript" src="resources/js/jquery-1-4-2.min.js"></script> 
        <!--script type="text/javascript" src="/jqueryui/js/jquery-ui-1.7.2.custom.min.js"></script--> 
        <script type="text/javascript" src="resources/js/jquery-ui.min.js"></script> 
        <script type="text/javascript" src="resources/js/showhide.js"></script> 
        <script type="text/JavaScript" src="resources/js/jquery.mousewheel.js"></script> 
        <script type="text/javascript" src="resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/ddsmoothmenu.js">

            /***********************************************
             * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
             * This notice MUST stay intact for legal use
             * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
             ***********************************************/

        </script>

        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "templatemo_menu", //menu DIV id
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                //customtheme: ["#1c5a80", "#18374a"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })

        </script> 

        <!-- Load the CloudCarousel JavaScript file -->
        <script type="text/JavaScript" src="resources/js/cloud-carousel.1.0.5.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {

                // This initialises carousels on the container elements specified, in this case, carousel1.
                $("#carousel1").CloudCarousel(
                        {
                            reflHeight: 40,
                            reflGap: 2,
                            titleBox: $('#da-vinci-title'),
                            altBox: $('#da-vinci-alt'),
                            buttonLeft: $('#slider-left-but'),
                            buttonRight: $('#slider-right-but'),
                            yRadius: 30,
                            xPos: 480,
                            yPos: 32,
                            speed: 0.15,
                            autoRotate: "yes",
                            autoRotateDelay: 1500
                        }
                );
            });

        </script>
    </head>
    <body id="subpage">
        <div id="templatemo_header_wrapper">
            <div id="site_title"><h1><a href="index.jsp">DTH Template</a></h1></div>
            <div id="templatemo_menu" class="ddsmoothmenu">
                <ul>
                    <li><a href="index.jsp" class="selected">Home</a></li>
                    <li><a href="">Packages</a>
                        <ul>

                            <li><span class="top"></span><span class="bottom"></span></li>
                            <li><a href="Packages.jsp">Subscribe Package</a></li>
                            <li><a href="Packages.jsp">Recharge Package</a></li>
                            <li><a href="#submenu2">Set-up Boxes</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Movies</a>
                        <ul>
                            <li><span class="top"></span><span class="bottom"></span></li>
                            <li><a href="#submenu1">Book Movie</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Dealer List</a></li>
                    <li><a href="News_List.jsp">News</a></li>
                    <li><a href="Event_List.jsp">Event</a></li>
                    <li><a href="#">Others</a>
                        <ul>
                            <li><span class="top"></span><span class="bottom"></span></li>
                            <li><a href="#submenu1">Contact</a></li>
                            <li><a href="#submenu2">Support</a></li>
                            <li><a href="#submenu2">FAQs</a></li>
                        </ul>
                    </li>
                    
                    <%
                        if (session.getAttribute("login") != null) {
                            String username = String.valueOf(session.getAttribute("login"));
                            String role = String.valueOf(session.getAttribute("role"));
                            CustomerModel model = new CustomerModel();
                            double money = model.getWallet(username);
                            if (role.equals("customer")) {

                    %>
                    <li><a href="#">Hello : <%out.print(username);%></a>
                        <ul>
                            <li><span class="top"></span><span class="bottom"></span></li>
                            <li><a href="#submenu1">Your money : $<%out.print(money);%></a></li>
                            <li><a href="#submenu1">My Profile</a></li>
                            <li><a href="#submenu2">My Services </a></li>
                            <li><a href="#submenu2">Change Password</a></li>
                        </ul>
                    </li>
                    <li><a href="logout?exit=ok">Log out</a></li>
                        <%                            }
                            if (role.equals("admin")) {

                        %>
                    <li><a href="admin_page/admin_index.jsp">Dashboard</a></li>
                    <li><a href="logout?exit=ok">Log out</a></li>
                        <%                        }
                        %>


                    <%
                    } else {

                    %>
                    <li><a href="Register.jsp">Register</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                        <%                        }
                        %>


                </ul>
                <br style="clear: left" />
            </div> <!-- end of templatemo_menu -->
            <div class="cleaner"></div>
        </div>	<!-- END of templatemo_header_wrapper -->
        <div id="templatemo_main">
    </body>
</html>
