<%-- 
    Document   : News_List
    Created on : Mar 6, 2016, 12:18:20 PM
    Author     : ASUS
--%>

<%@page import="Model.List_News"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>News</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="resources/css/templatemo_style.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/eve_news.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-1-4-2.min.js"></script> 
    <!--script type="text/javascript" src="/jqueryui/js/jquery-ui-1.7.2.custom.min.js"></script--> 
    <script type="text/javascript" src="js/jquery-ui.min.js"></script> 
    <script type="text/javascript" src="js/showhide.js"></script> 
    <script type="text/JavaScript" src="js/jquery.mousewheel.js"></script> 

    <link href="resources/css/ddsmoothmenu.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/ddsmoothmenu.js">

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

</head>

<body id="subpage">

    <div id="templatemo_header_wrapper">
        <div id="site_title"><h1><a href="#">Carousel Template</a></h1></div>
        <div id="templatemo_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="about.html">About</a>
                    <ul>
                        <li><span class="top"></span><span class="bottom"></span></li>
                        <li><a href="#submenu1">Sub menu 1</a></li>
                        <li><a href="#submenu2">Sub menu 2</a></li>
                        <li><a href="#submenu3">Sub menu 3</a></li>
                    </ul>
                </li>
                <li><a href="portfolio.html">Portfolio</a>
                    <ul>
                        <li><span class="top"></span><span class="bottom"></span></li>
                        <li><a href="#submenu1">Sub menu 1</a></li>
                        <li><a href="#submenu2">Sub menu 2</a></li>
                        <li><a href="#submenu3">Sub menu 3</a></li>
                        <li><a href="#submenu4">Sub menu 4</a></li>
                        <li><a href="#submenu5">Sub menu 5</a></li>
                    </ul>
                </li>
                <li><a href="blog.html" class="selected">Blog</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
            <div id="google_translate_element"></div><script type="text/javascript">
            function googleTranslateElementInit() {
                new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
            }
        </script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
            <br style="clear: left" />
        </div> <!-- end of templatemo_menu -->
        <div class="cleaner"></div>
    </div>	<!-- END of templatemo_header_wrapper -->

    <div id="templatemo_main">
        <div id="content">
            <%
                List_News l = new List_News();
                String list = l.listNew();
                out.print(list);
            %>
            
            <div class="post last_box">

                
            </div>

            <div class="pagging">
                <ul>
                    <li><a href="#">Previous</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </div>
            <div class="cleaner"></div>
        </div>

        <div id="sidebar">
            <ul class="templatemo_list">
            <input class="news_textbox" type="text"  name="txtSearch">
            
            <button type="submit">Search</button>
            </ul>
            
            <div class="cleaner h30"></div>
            
            <h3>Categories :</h3>
            <ul class="templatemo_list">
                <li><a href="#">Newṣ</a></li>
                <li><a href="#">Business</a></li>
                <li><a href="#">Politic̣</a></li>
                <li><a href="#">Sports</a></li>
                <li><a href="#">Education</a></li>
                <li><a href="#">Movie</a></li>
                <li><a href="#">Fashion</a></li>
                <li><a href="#">Technology</a></li>
            </ul>

            <div class="cleaner h30"></div>

            <h3>Maybe you like to watch?</h3>
            <ul class="recent_post">
                <li><a href="#">Vivamus imperdiet</a>Nunc ultrices iaculis quam, sed commodo erat tempus mollis.</li>
                <li><a href="#">Pellentesque nunc libero</a>Placerat augue, quis ultricies justo ligula eget justo.</li>
                <li><a href="#">Duis ultricies nulla</a>Etiam nec turpis bibendum massa dapibus dictum.</li>
                <li><a href="#">Proin a elit nisl</a>Donec tincidunt eleifend mauris, ac volutpat leo tincidunt a.</li>
                <li><a href="#">Nunc ultrices iaculis</a>Morbi eget nisi rutrum nisl ultricies venenatis ut sed sem.</li>
            </ul>
        </div> <!-- end of sidebar -->
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->

    <div id="templatemo_bottom_wrapper">
        <div id="templatemo_bottom">
            <div class="col one_third">
                <h4><span></span>Blogroll</h4>
                <div class="bottom_box">
                    <ul class="footer_list">
                        <li><a href="#">Learn HTML CSS</a></li>
                        <li><a href="#">Web Design</a></li>
                        <li><a href="#">Flash Gallery</a></li>
                        <li><a href="#">Website Templates</a></li>
                        <li><a href="#">Free Graphics</a></li>

                    </ul>  
                </div>
            </div>

            <div class="col one_third">
                <h4><span></span>Updates</h4>
                <div class="bottom_box">
                    <ul class="twitter_post">
                        <li>Curabitur nec dui venenatis sem consectetur facilisis. Donec velit nisi, lacinia sed et. <a href="#">http://bit.ly/13IwZO</a></li>
                        <li>Proin dignissim, diam nec <a href="#">@TemplateMo</a> enim lorem tempus orci, ac imperdiet ante purus in justo.</li>
                    </ul>
                </div>
            </div>

            <div class="col one_third no_margin_right">
                <h4><span></span>About Us</h4>
                <div class="bottom_box">
                    <p><em>Duis sem nisl, dignissim ac feugiat in, mattis sit amet est. Duis leo leo, suscipit cursus vehicula sit amet. Sed varius pellentesque massa vel rutrum.</em></p><br />
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
            Copyright © 2016 Nguyen Thanh Danh
        </div> <!-- END of templatemo_footer_wrapper -->
    </div> <!-- END of templatemo_footer -->

</body>

</html>
