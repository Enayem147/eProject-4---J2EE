<%-- 
    Document   : News
    Created on : Mar 7, 2016, 6:31:37 PM
    Author     : ASUS
--%>

<%@page import="Model.List_Comment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>News</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="resources/css/templatemo_style.css" rel="stylesheet" type="text/css"/>
<!-- templatemo 358 carousel -->
<!-- 
Carousel Template 
http://www.templatemo.com/preview/templatemo_358_carousel 
-->
<script src="resources/js/jquery-1-4-2.min.js" type="text/javascript"></script>
<!--script type="text/javascript" src="/jqueryui/js/jquery-ui-1.7.2.custom.min.js"></script--> 
<script src="resources/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="resources/js/showhide.js" type="text/javascript"></script>
<script src="resources/js/jquery.mousewheel.js" type="text/javascript"></script>

<link href="resources/css/ddsmoothmenu.css" rel="stylesheet" type="text/css"/>

<script src="resources/js/jquery.min.js" type="text/javascript"></script>
<script src="resources/js/ddsmoothmenu.js" type="text/javascript"></script>





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



    ${result}



    <div class="cleaner h40"></div>
    
    <h3>Comments</h3>

    <div id="comment_section">
        <ol class="comments first_level">

            <%
                List_Comment l = new List_Comment();
                String list = l.listComment();
                out.print(list);
            %>

        </ol>
        <div class="cleaner h20"></div>    
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

    </div>

    <div class="cleaner h20"></div>

    <div id="comment_form">
        <h3>Leave your comment</h3>

        <form action="addcomment" enctype="multipart/form-data" method="get">
            <div class="form_row">
                <label>Name (* required)</label><br />
                <input type="text" required="true" name="txtName" />
            </div>

            <div class="form_row">
                <label>Email  (* required)</label><br />
                <input type="text" required="true" name="txtEmail" />
            </div>

            <div class="form_row">
                <label>Comment</label><br />
                <textarea required="true" name="txtComment" rows="" cols=""></textarea>
            </div>

            <input type="submit" name="Send" value="Submit" class="submit_btn" />
        </form>

    </div>
    <div id="fb-root"></div>
            <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
            </script>
            <div class="fb-like" data-href="http://localhost:8080/RDTH-war/eventservlet?eventID=1" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
            <div id="fb-root"></div>
            <script>(function (d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (d.getElementById(id))
                        return;
                    js = d.createElement(s);
                    js.id = id;
                    js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
                    fjs.parentNode.insertBefore(js, fjs);
                }(document, 'script', 'facebook-jssdk'));

            </script>
            <div class="fb-comments" data-href="http://localhost:8080/RDTH-war/newsservlet?newsid=1" data-numposts="5"></div>
    
    <div class="cleaner"></div>
</div>

<div id="sidebar">
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

    <h3>News HOT!!!</h3>
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
        Copyright © 2048 Your Company Name
    </div> <!-- END of templatemo_footer_wrapper -->
</div> <!-- END of templatemo_footer -->

</body>
</html>