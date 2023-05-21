<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/14/2023
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/trang-chu/header.css">
</head>
<body>
<header class="bg-light">
    <div class="container">
        <div class="row justify-content-end">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="col-4">
                    <ul class="navbar-nav">
                        <a class="navbar-brand" href="/product/hien-thi">Shoe Store</a>
                        <li class="nav-item">
                            <a class="nav-link" href="/product/hien-thi">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/product/view-product">Sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/product/gioi-thieu">Giới thiệu</a>
                        </li>
                    </ul>
                </div>
                <div class="col-3">
                    <form class="form-inline" action="/product/search" method="get">
                        <div class="input-group find-product">
                            <input type="text" class="form-control " name="name" placeholder="Tìm kiếm">
                            <button type="submit" class="btn btn-warning">Tìm kiếm</button>
                        </div>
                    </form>
                </div>
                <div class="col-5">
                    <c:if test="${sessionScope.loggedInUser}">
                        <a href="/cart/hien-thi" class="header__cart menu-info">
                            <div class="box-cart">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                                <i class="iconnewglobal-cart"></i>
                                <span class="cart-number"></span>
                            </div>
                            <span>Giỏ hàng</span>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.loggedInUser == null}">
                        <a href="/dang-nhap/form" class="header__cart menu-info">
                            <div class="box-cart">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-door-open-fill" viewBox="0 0 16 16">
                                    <path d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15H1.5zM11 2h.5a.5.5 0 0 1 .5.5V15h-1V2zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
                                </svg>
                                <i class="iconnewglobal-cart"></i>
                            </div>
                            <span>Đăng Nhập</span>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.loggedInUser != null}">
                        <c:if test="${sessionScope.loggedInUser.name == 'admin'}">
                            <a href="/admin/dashboard" class="header__cart menu-info">
                                <div class="box-cart">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-person-circle" viewBox="0 0 16 16">
                                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                        <path fill-rule="evenodd"
                                              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg>
                                    <i class="iconnewglobal-cart"></i>
                                </div>
                                <span>Admin</span>
                            </a>
                        </c:if>
                        <c:if test="${sessionScope.loggedInUser.name != 'admin'}">
                            <a href="/admin/dashboard" class="header__cart menu-info">
                                <div class="box-cart">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-person-circle" viewBox="0 0 16 16">
                                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                        <path fill-rule="evenodd"
                                              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg>
                                    <i class="iconnewglobal-cart"></i>
                                </div>
                                <span>Tên Khách</span>
                            </a>
                        </c:if>
                        <a href="/dang-nhap/logout" class="header__cart menu-info">
                            <div class="box-cart">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
                                          d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                    <path fill-rule="evenodd"
                                          d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                </svg>
                                <i class="iconnewglobal-cart"></i>
                            </div>
                            <span>Đăng Xuất</span>
                        </a>
                    </c:if>
                </div>
            </nav>
        </div>
    </div>
</header>
<script src="/js/bootstrap.js"></script>
</body>
</html>