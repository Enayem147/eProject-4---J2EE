<%-- 
    Document   : index
    Created on : Mar 5, 2016, 1:37:05 PM
    Author     : r0cklee147
--%>

<%@page import="myModel.CustomerModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>R-DTH HOME</title>
        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>

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
    <body id="home">
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
        </div>

        <div id="templatemo_slider">
            <!-- This is the container for the carousel. -->
            <div id = "carousel1" style="width:960px; height:280px;background:none;overflow:scroll; margin-top: 20px">            
                <!-- All images with class of "cloudcarousel" will be turned into carousel items -->
                <!-- You can place links around these images -->

                <a href="#" rel="lightbox"><img class="cloudcarousel" src="resources/images/slider/a.jpg" alt="CSS Templates 1" title="Website Templates 1" /></a>
                <a href="#" rel="lightbox"><img class="cloudcarousel" src="resources/images/slider/b.jpg" alt="CSS Templates 2" title="Website Templates 2" /></a>
                <a href="#" rel="lightbox"><img class="cloudcarousel" src="resources/images/slider/c.jpg" alt="CSS Templates 3" title="Website Templates 3" /></a>
                <a href="#" rel="lightbox"><img class="cloudcarousel" src="resources/images/slider/d.jpg" alt="CSS Templates 4" title="Website Templates 4" /></a>
                <a href="#" rel="lightbox"><img class="cloudcarousel" src="resources/images/slider/f.jpg" alt="Flash Templates 1" title="Flash Templates 1" /></a>
                <a href="#" rel="lightbox"><img class="cloudcarousel" src="resources/images/slider/g.jpg" alt="Flash Templates 2" title="Flash Templates 2" /></a>
            </div> 
            <!-- Define left and right buttons. -->
            <center>
                <input id="slider-left-but" type="button" value="" />
                <input id="slider-right-but" type="button" value="" />
            </center>
        </div>
        <div id="templatemo_main">

            <div class="col one_third fp_services">
                <h2>Welcome!</h2>
                <img src="resources/images/templatemo_image_04.jpg" alt="Image 04 " class="image_fl" />
                <p>Carousel is free css template provided by templatemo.com for your personal or commercial websites. Quisque nec suscipit ipsum. Fusce vitae accumsan massa.</p>
                <ul class="templatemo_list">
                    <li class="flow">Integer placerat dolor vel</li>
                    <li class="flow nomr">Condimentum vulputate</li>
                    <li class="flow">Itristique non suscipit id</li>
                    <li class="flow nomr"> Donec eget lacus vitae leo</li>
                </ul>
            </div>
            <div class="col one_third fp_services">
                <h2>News</h2>
                <div class="rp_pp">
                    <img src="resources/images/templatemo_image_01.jpg" alt="Image 01" />
                    <a href="#">Integer venenatis pharetra magna vitae   condimentum   ultrices.</a>
                    <p>Feb 27, 2048 - 140 comments</p>
                    <div class="cleaner"></div>
                </div>
                <div class="rp_pp">
                    <img src="resources/images/templatemo_image_02.jpg" alt="Image 02" />
                    <a href="#">Nulla facilisi. Vestibulum vel odio ac mi feugiat condimentum.</a>
                    <p>Feb 21, 2048 - 154 comments</p>
                    <div class="cleaner"></div>
                </div>
                <div class="rp_pp">
                    <img src="resources/images/templatemo_image_03.jpg" alt="Image 03" />
                    <a href="#">Fusce dolor neque, placerat ac erat venenatis eu, venenatis ac leo.</a>
                    <p>Feb 15, 2048 - 179 comments</p>
                    <div class="cleaner"></div>
                </div>
            </div>
            <div class="col one_third no_margin_right fp_services">

                <h2>Testimonials</h2>
                <div class="testimonial">
                    <p>Nunc vitae purus non augue scelerisque ultricies vitae et velit quis nulla id orci malesua tempus erat.</p>
                    <cite>HOANG NGUYEN TRUONG NAM  <a href="#"><span>- CEO, R-DTH Company</span></a></cite></div>
                
            </div>

            <div class="cleaner"></div>
        </div>
        <div>
            <div id="templatemo_bottom_wrapper">
                <div id="templatemo_bottom">
                    <div class="col one_third">
                        <h4><span></span>Blogroll</h4>
                        <div class="bottom_box">
                            <ul class="footer_list">
                                <li><a href="#">Packages</a></li>
                                <li><a href="#">Movies</a></li>
                                <li><a href="#">Set-up Boxes</a></li>
                                <li><a href="#">Events</a></li>
                                <li><a href="#">News</a></li>
                            </ul>  
                        </div>
                    </div>
                    <div class="col one_third">
                        <h4><span></span>Updates</h4>
                        <div class="bottom_box">
                            <ul class="twitter_post">
                                <li>Updating. <a href="#"></a></li>
                                <li><a href="#"></a>Updating.</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col one_third no_margin_right">
                        <h4><span></span>About Us</h4>
                        <div class="bottom_box">
                            <p><em>R-DTH is a DTH company which uses latest MPEG-4 technology to increase the broadcast capacity. The company is supported by Iredeto’s conditional access solution to manage content and revenues in satellite broadcasting venture.</em></p><br />              
                            <div class="footer_social_button">
                                <a href="#"><img src="resources/images/facebook.png" title="facebook" alt="facebook" /></a>
                                <a href="#"><img src="resources/images/flickr.png" title="flickr" alt="flickr" /></a>
                                <a href="#"><img src="resources/images/twitter.png" title="twitter" alt="twitter" /></a>
                                <a href="#"><img src="resources/images/youtube.png" title="youtube" alt="youtube" /></a>
                                <a href="#"><img src="resources/images/feed.png" title="rss" alt="rss" /></a>
                            </div>
                        </div>
                    </div>

                    <div class="cleaner"></div>
                </div> <!-- END of tempatemo_bottom -->
            </div> <!-- END of tempatemo_bottom_wrapper -->

            <div id="templatemo_footer_wrapper">
                <div id="templatemo_footer">
                    Copyright © 2048 Your Company Name
                </div> <!-- END of templatemo_footer_wrapper -->
            </div> <!-- END of templatemo_footer -->
        </div>

    </body>
</html>
