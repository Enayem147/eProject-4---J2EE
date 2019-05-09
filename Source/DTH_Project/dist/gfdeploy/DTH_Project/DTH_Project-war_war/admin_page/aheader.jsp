<%-- 
    Document   : adminheader
    Created on : Mar 8, 2016, 10:50:37 AM
    Author     : r0cklee147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <link href="../resources/css/mycss.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/bordercss.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/box.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" ></meta>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Bootstrap Core CSS -->
        <link href="./../resources/css/adm/bootstrap.min.css" rel='stylesheet' type='text/css' />
        <!-- Custom CSS -->
        <link href="./../resources/css/adm/style.css" rel='stylesheet' type='text/css' />
        <!-- Graph CSS -->
        <link href="./../resources/css/adm/lines.css" rel='stylesheet' type='text/css' />
        <link href="./../resources/css/adm/font-awesome.css" rel="stylesheet"/> 
        <!-- jQuery -->
        <script src="./../resources/js/adm/jquery.min.js"></script> 
        <!--webfonts-->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'/>
        <!--webfonts--> 
        <!-- Nav CSS -->
        <link href="./../resources/css/adm/custom.css" rel="stylesheet"/>
        <!-- Metis Menu Plugin JavaScript -->
        <script src="./../resources/js/adm/metisMenu.min.js"></script>
        <script src="./../resources/js/adm/custom.js"></script>
        <!-- Graph JavaScript -->
        <script src="./../resources/js/adm/d3.v3.js"></script>
        <script src="./../resources/js/adm/rickshaw.js"></script>
        <script src="../resources/js/adm/bootstrap.min.js"></script>

        <!-- Copy css -->
        <link href="resources/css/mycss.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bordercss.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/box.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" ></meta>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Bootstrap Core CSS -->
        <link href="resources/css/adm/bootstrap.min.css" rel='stylesheet' type='text/css' />
        <!-- Custom CSS -->
        <link href="resources/css/adm/style.css" rel='stylesheet' type='text/css' />
        <!-- Graph CSS -->
        <link href="resources/css/adm/lines.css" rel='stylesheet' type='text/css' />
        <link href="resources/css/adm/font-awesome.css" rel="stylesheet"/> 
        <!-- jQuery -->
        <script src="resources/js/adm/jquery.min.js"></script> 
        <!--webfonts-->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'/>
        <!--webfonts--> 
        <!-- Nav CSS -->
        <link href="resources/css/adm/custom.css" rel="stylesheet"/>
        <!-- Metis Menu Plugin JavaScript -->
        <script src="resources/js/adm/metisMenu.min.js"></script>
        <script src="resources/js/adm/custom.js"></script>
        <!-- Graph JavaScript -->
        <script src="resources/js/adm/d3.v3.js"></script>
        <script src="resources/js/adm/rickshaw.js"></script>
        <script src="resources/js/adm/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <!-- Navigation -->
            <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">DTH Admin Page</a>
                </div>
                <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'Search...';
                            }"/>
                </form>
                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a>Dashboard</a>
                            </li>
                            <li>
                                <a href="">Manage Customer<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="Customer_Add.xhtml">Add new Customer</a>
                                    </li>
                                    <li>
                                        <a href="Customer_List.xhtml">Customer List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Dealer<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./Dealer_Add.xhtml">Add new Dealer</a>
                                    </li>
                                    <li>
                                        <a href="./Dealer_List.xhtml">Dealer List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Package<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="Package_Add.jsp">Add new Package</a>
                                    </li>
                                    <li>
                                        <a href="Package_List.jsp">Package List</a>
                                    </li>
                                    <li>
                                        <a href="compose.html">Package Invoice List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Location<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./Location_Add.xhtml">Add new Location</a>
                                    </li>
                                    <li>
                                        <a href="./Location_List.xhtml">Location List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Question<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="basic_tables.html">Add new Question</a>
                                    </li>
                                    <li>
                                        <a href="basic_tables.html">Question List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Movie<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="forms.html">Add new Movie</a>
                                    </li>
                                    <li>
                                        <a href="validation.html">Movie List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Movie Genre<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="forms.html">Add new Movie Genre</a>
                                    </li>
                                    <li>
                                        <a href="validation.html">Movie Genre List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage News<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="Add_News.jsp">Add new News</a>
                                    </li>
                                    <li>
                                        <a href="List_News.jsp">News List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href=""> Manage News Type<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="forms.html">Add new News Type</a>
                                    </li>
                                    <li>
                                        <a href="validation.html">News Type List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Event<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="Add_Event.jsp">Add new Event</a>
                                    </li>
                                    <li>
                                        <a href="List_Event.jsp">Event List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Comment<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                   
                                    <li>
                                        <a href="List_Comment.jsp">Comment List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage FAQs<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="forms.html">Add new FAQs</a>
                                    </li>
                                    <li>
                                        <a href="validation.html">FAQs List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="">Manage Feedback<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="forms.html">Add new Feedback</a>
                                    </li>
                                    <li>-
                                        <a href="validation.html">Feedback List</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>                              
                                <a href="">Other<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="../index.jsp">Return Client Page</a>
                                    </li>
                                    <li>
                                        <a href="../logout?exit=ok">Log out</a>
                                    </li>
                                </ul>

                                <!-- /.nav-second-level -->
                            </li>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>
            <div id="page-wrapper">
                </body>
                </html>
