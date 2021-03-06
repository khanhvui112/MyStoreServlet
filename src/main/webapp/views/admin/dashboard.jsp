<%--
  Created by IntelliJ IDEA.
  User: san vui
  Date: 11/11/2021
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.ico" type="image/ico"/>

        <title>ADMIN DASHBOARD </title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--JS-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


        <!-- Custom Theme Style -->
        <link href="${pageContext.request.contextPath}/views/assets/css/custom.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/assets/css/dasboard.css">
    </head>
    <body style="background: unset;" class="nav-md">
        <div class="container body">
            <div class="main_container" >
                <div class="col-md-3 left_col" id="menu-left">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="./" class="site_title"><i class="fa fa-paw"></i> <span>My Store</span></a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix">
                            <c:if test="${loginDTO.getAvatar() != 'null' }">
                                <div class="profile_pic">
                                    <img style="height: 8%;width: 77%;"
                                         src="${pageContext.request.contextPath}/views/assets/images/avatar/${loginDTO.getAvatar()}"
                                         alt="..." class="img-circle profile_img">
                                </div>
                            </c:if>
                            <div class="profile_info">
                                <span>Xin ch??o,</span>
                                <h2  style="color:aqua;">${loginDTO.getUserName()}</h2>
                                <span style="color:lawngreen;">${loginDTO.getRole()}</span>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br/>

                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                            <div class="menu_section">
                                <ul class="nav side-menu">
                                    <c:if test="${loginDTO.getRole().equalsIgnoreCase('admin')}">
                                        <li><a id="home"><i class="fa fa-user"></i> Qu???n l?? h??? th???ng<span
                                                class="fa fa-chevron-down"></span></a>
                                            <ul class="menu employee text-white" style="display:none;" id="employee">
                                                <li id="all-employee"><a >Nh??n vi??n</a></li>
                                                <li><a href="index2.html">Menu</a></li>
                                                <li><a href="index3.html">S???n ph???m</a></li>
                                            </ul>
                                        </li>
                                    </c:if>
                                    <li><a id="product"><i class="fa fa-product-hunt"></i> Qu???n l?? s???n ph???m <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="menu products-hidden">
                                            <li><a href="form.html">Xem t???t danh s??ch s???n ph???m</a></li>
                                            <li><a href="form_advanced.html">Th??m s???n ph???m</a></li>
                                            <li><a href="form_validation.html">S???a s???n ph???m</a></li>
                                            <li><a href="form_wizards.html">X??a s???n ph???m</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-desktop"></i> UI Elements <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="menu child_menu">
                                            <li><a href="general_elements.html">General Elements</a></li>
                                            <li><a href="media_gallery.html">Media Gallery</a></li>
                                            <li><a href="typography.html">Typography</a></li>
                                            <li><a href="icons.html">Icons</a></li>
                                            <li><a href="glyphicons.html">Glyphicons</a></li>
                                            <li><a href="widgets.html">Widgets</a></li>
                                            <li><a href="invoice.html">Invoice</a></li>
                                            <li><a href="inbox.html">Inbox</a></li>
                                            <li><a href="calendar.html">Calendar</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-table"></i> Tables <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="menu child_menu">
                                            <li><a href="tables.html">Tables</a></li>
                                            <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="menu child_menu">
                                            <li><a href="chartjs.html">Chart JS</a></li>
                                            <li><a href="chartjs2.html">Chart JS2</a></li>
                                            <li><a href="morisjs.html">Moris JS</a></li>
                                            <li><a href="echarts.html">ECharts</a></li>
                                            <li><a href="other_charts.html">Other Charts</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-clone"></i>Layouts <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                                            <li><a href="fixed_footer.html">Fixed Footer</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="menu_section">
                                <h3>Live On</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-bug"></i> Additional Pages <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="e_commerce.html">E-commerce</a></li>
                                            <li><a href="projects.html">Projects</a></li>
                                            <li><a href="project_detail.html">Project Detail</a></li>
                                            <li><a href="contacts.html">Contacts</a></li>
                                            <li><a href="profile.html">Profile</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="page_403.html">403 Error</a></li>
                                            <li><a href="page_404.html">404 Error</a></li>
                                            <li><a href="page_500.html">500 Error</a></li>
                                            <li><a href="plain_page.html">Plain Page</a></li>
                                            <li><a href="login.html">Login Page</a></li>
                                            <li><a href="pricing_tables.html">Pricing Tables</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span
                                            class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="#level1_1">Level One</a>
                                            <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                                                <ul class="nav child_menu">
                                                    <li class="sub_menu"><a href="level2.html">Level Two</a>
                                                    </li>
                                                    <li><a href="#level2_1">Level Two</a>
                                                    </li>
                                                    <li><a href="#level2_2">Level Two</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a href="#level1_2">Level One</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span
                                            class="label label-success pull-right">Coming Soon</span></a></li>
                                </ul>
                            </div>

                        </div>

                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu" style="height: 8%;">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>
                        <nav class="nav navbar-nav">
                            <ul class=" navbar-right">
                                <li class="nav-item dropdown open" style="padding-left: 15px;">
                                    <p class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown"
                                       data-toggle="dropdown" aria-expanded="false">
                                        <c:if test="${loginDTO.getAvatar() != 'null' }">
                                            <img src="${pageContext.request.contextPath}/views/assets/images/avatar/${loginDTO.getAvatar()}"
                                                 alt="">
                                        </c:if>

                                        ${loginDTO.getUserName()}
                                    </p>

                                    <div class="dropdown-menu dropdown-usermenu pull-right"
                                         aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="javascript:;"> Th??ng tin t??i kho???n</a>
                                        <a class="dropdown-item" href="javascript:;">C??i ?????t</a>
                                        <a class="dropdown-item" href="javascript:;">H??? tr???</a>
                                        <a class="dropdown-item" href="./Logout"><i
                                                class="fa fa-sign-out pull-right"></i> ????ng xu???t</a>
                                    </div>
                                </li>

                                <li role="presentation" class="nav-item dropdown open">
                                    <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1"
                                       data-toggle="dropdown" aria-expanded="false">
                                        <i class="fa fa-envelope-o"></i>
                                        <span class="badge bg-green">6</span>
                                    </a>
                                    <ul id="notication" class="dropdown-menu list-unstyled msg_list" role="menu"
                                        aria-labelledby="navbarDropdown1">
                                        <li class="nav-item">
                                            <a class="dropdown-item">
                                                <span class="image"></span>
                                                <span>
                          <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="dropdown-item">
                                                <span class="image"></span>
                                                <span>
                          <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="dropdown-item">
                                                <span class="image"></span>
                                                <span>
                          <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="dropdown-item">
                                                <span class="image"></span>
                                                <span>
                          <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <div class="text-center">
                                                <a class="dropdown-item">
                                                    <strong>See All Alerts</strong>
                                                    <i class="fa fa-angle-right"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="row">
                        <div class="col-sm-12" id="table-append">
                            <table id="datatable" class="table text-center dataTable no-footer"
                                   style="width: 100%;" role="grid" aria-describedby="datatable_info">
                                <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-sort="ascending"
                                            aria-label="Name: activate to sort column descending">
                                            H??? v?? t??n ?????m
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Position: activate to sort column ascending">T??n
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Office: activate to sort column ascending">T??n t??i kho???n
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Age: activate to sort column ascending">Email
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Start date: activate to sort column ascending">S??? ??i???n tho???i
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Salary: activate to sort column ascending">Ng??y sinh
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Salary: activate to sort column ascending">Gi???i t??nh
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Salary: activate to sort column ascending">?????a ch???
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Salary: activate to sort column ascending">Ph??ng ban
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatable" rowspan="1"
                                            colspan="1" aria-label="Salary: activate to sort column ascending">Quy???n
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Admin Template by <a href="https://colorlib.com">S???n Vui</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
        </div>
        </div>

        <!-- jQuery -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="${pageContext.request.contextPath}/views/assets/js/dashboard.js"></script>

    </body>
</html>
