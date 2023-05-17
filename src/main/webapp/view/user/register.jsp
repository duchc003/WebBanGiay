<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/11/2023
  Time: 7:34 AM
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
<div class="alert alert-primary" role="alert">
    ${message}
</div>
<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>
                            <form:form action="/user/register" method="post" modelAttribute="register">
                                <div class="form-outline mb-4">
                                    <label class="form-label" >Your Name</label>
                                    <form:input type="text" path="name" class="form-control form-control-lg"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example3cg">Your Email</label>
                                    <form:input type="email" path="email" id="form3Example3cg" class="form-control form-control-lg"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                    <form:input type="password" path="password" id="form3Example4cg" class="form-control form-control-lg"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                                    <form:input type="password" path="repeatPassword" id="form3Example4cdg" class="form-control form-control-lg"/>
                                </div>
                                <div class="form-check d-flex justify-content-center mb-5">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg"/>
                                    <label class="form-check-label">
                                        I agree all statements in
                                    </label>
                                </div>
                                <div class="d-flex justify-content-center">
                                    <input class="btn btn-info btn-lg btn-block" type="submit" value="register"></input>
                                </div>
                                <p class="text-center text-muted mt-5 mb-0">Have already an account?
                                    <a href="/user/login" class="fw-bold text-body"><u>Login here</u></a></p>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="/js/bootstrap.js"></script>
</body>
</html>
