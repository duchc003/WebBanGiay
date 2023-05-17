<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/11/2023
  Time: 7:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<c:if test="${!empty message}">
    <div class="alert alert-primary" role="alert">
            ${message}
    </div>
    <c:remove var="message" scope="session"></c:remove>
</c:if>
<section class="vh-100">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 text-black">
                <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
                    <form:form style="width: 23rem;" action="/user/login" method="post" modelAttribute="login">
                        <center><h1>Login</h1></center>
                        <div class="form-outline mb-4">
                            <label class="form-label">Username</label>
                            <form:input path="name" class="form-control form-control-lg" />
                        </div>
                        <div class="form-outline mb-4">
                            <label class="form-label" >Password</label>
                            <form:input type="password" path="password" class="form-control form-control-lg" />
                        </div>
                        <div class="pt-1 mb-4">
                            <input class="btn btn-info btn-lg btn-block" type="submit" value="login"></input>
                        </div>
                        <p class="small mb-5 pb-lg-2"><a class="text-muted" href="/user/forgot-password">Forgot password?</a></p>
                        <p>Don't have an account? <a href="/user/register" class="link-info">Register here</a></p>
                    </form:form>
                </div>
            </div>
            <div class="col-sm-6 px-0 d-none d-sm-block">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
                     alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
            </div>
        </div>
    </div>
</section>
<script src="/js/bootstrap.js"></script>
</body>
</html>
