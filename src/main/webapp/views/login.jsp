<%--
  Created by IntelliJ IDEA.
  User: san vui
  Date: 11/11/2021
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>My Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/views/assets/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/assets/css/login.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <jsp:include page="./_header.jsp"></jsp:include>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" method="post" action="./login">
					<span style="font-family: ui-serif;" class="login100-form-title p-b-49">
						????ng nh???p
					</span>

                        <p class="showError" style="color: red;">${error}</p>
                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                            <span class="label-input100">T??n t??i kho???n<span style="color:red;" class="spanUsername"></span></span>
                            <input class="input100 username" id="username" type="text" name="username" placeholder="Type your username">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">M???t kh???u</span>
                            <input class="input100 password" id="password" type="password" name="password" placeholder="Type your password">
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <div class="text-right p-t-8 p-b-31">
                            <a href="#">
                                Qu??n m???t kh???u?
                            </a>

                        </div>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn submit">
                                    ????ng nh???p
                                </button>
                            </div>
                        </div>

                        <div class="txt1 text-center p-t-20 p-b-20">
                            <div class="flex-col-c p-20">
                                <p class="loginhere">
                                    B???n ch??a c?? t??i kho???n ? <a href="./signup" class="loginhere-link">????ng k??</a>
                                </p>
                            </div>
						<span>
							????ng nh???p v???i
						</span>
                        </div>

                        <div class="flex-c-m">
                            <a href="#" class="login100-social-item bg1">
                                <i class="fa fa-facebook"></i>
                            </a>

                            <a href="#" class="login100-social-item bg2">
                                <i class="fa fa-twitter"></i>
                            </a>

                            <a href="#" class="login100-social-item bg3">
                                <i class="fa fa-google"></i>
                            </a>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="./_footer.jsp"></jsp:include>

        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/vendor/bootstrap/js/popper.js"></script>
        <script src="${pageContext.request.contextPath}/views/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/views/assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/views/assets/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/views/assets/js/login.js"></script>
    </body>
</html>
