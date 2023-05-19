<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/19/2023
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <style>
        header.navbar.navbar-dark.sticky-top.bg-dark.flex-md-nowrap.p-0.shadow {
            background-color: #0CBEF0 !important;
        }

        ul.nav.flex-column {
            width: 100%;
            line-height: 40px;
            padding: 0px 10px;
            color: #fff;
            font-size: 13px;
            font-weight: bold;
            text-transform: uppercase;
            position: relative;
            border: 0px;
            float: left;
        }
        a.nav-link:hover {
            color: coral;
        }
    </style>
</head>
<body>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Shoe Store</a>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" href="#">Sign out</a>
        </div>
    </div>
</header>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-home" aria-hidden="true">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-file" aria-hidden="true">
                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                <polyline points="13 2 13 9 20 9"></polyline>
                            </svg>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/product-manager/hien-thi">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-shopping-cart" aria-hidden="true">
                                <circle cx="9" cy="21" r="1"></circle>
                                <circle cx="20" cy="21" r="1"></circle>
                                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                            </svg>
                            Products
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-users" aria-hidden="true">
                                <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                                <circle cx="9" cy="7" r="4"></circle>
                                <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                                <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                            </svg>
                            Customers
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-bar-chart-2" aria-hidden="true">
                                <line x1="18" y1="20" x2="18" y2="10"></line>
                                <line x1="12" y1="20" x2="12" y2="4"></line>
                                <line x1="6" y1="20" x2="6" y2="14"></line>
                            </svg>
                            Reports
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-layers" aria-hidden="true">
                                <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                                <polyline points="2 17 12 22 22 17"></polyline>
                                <polyline points="2 12 12 17 22 12"></polyline>
                            </svg>
                            Integrations
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="chartjs-size-monitor">
                <div class="chartjs-size-monitor-expand">
                    <div class=""></div>
                </div>
                <div class="chartjs-size-monitor-shrink">
                    <div class=""></div>
                </div>
            </div>
            <br>
            <div class="container">
                <div class="form-outline">
                    <label class="form-label" for="typeText">Name</label>
                    <input type="text" id="typeText" class="form-control"/>
                </div>
                <br>
                <label class="form-label" for="typeText">Size</label>
                <div style="display: flex;">
                    <select class="form-select" aria-label="Default select example">
                        <option>Vui Lòng Chọn</option>
                        <c:forEach items="${listSize}" var="size">
                            <option value="${size.id}">${size.size}</option>
                        </c:forEach>
                    </select>
                    <button style="margin-left: 10px;" class="btn btn-warning">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                        </svg>
                    </button>
                </div>
                <br>
                <label class="form-label" for="typeText">Color</label>
                <div style="display: flex;">
                    <select class="form-select" aria-label="Default select example">
                        <option>Vui Lòng Chọn</option>
                        <c:forEach items="${listColor}" var="color">
                            <option value="${color.id}">${color.name}</option>
                        </c:forEach>
                    </select>
                    <button style="margin-left: 10px;" class="btn btn-warning">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                        </svg>
                    </button>
                </div>
                <br>
                <label class="form-label" for="typeText">Category</label>
                <div style="display: flex;">
                    <select class="form-select" aria-label="Default select example">
                        <option>Vui Lòng Chọn</option>
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                    <button style="margin-left: 10px;" class="btn btn-warning">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                        </svg>
                    </button>
                </div>
                <br>
                <label class="form-label" for="typeText">Origin</label>
                <div style="display: flex;">
                    <select class="form-select" aria-label="Default select example">
                        <option>Vui Lòng Chọn</option>
                        <c:forEach items="${listOrigin}" var="origin">
                            <option value="${origin.id}">${origin.name}</option>
                        </c:forEach>
                    </select>
                    <button style="margin-left: 10px;" class="btn btn-warning">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                        </svg>
                    </button>
                </div>
                <br>
                <div class="form-outline">
                    <label class="form-label" for="typeText">Quantity</label>
                    <input type="text" class="form-control"/>
                </div>
                <br>
                <div class="form-outline">
                    <label class="form-label" for="typeText">Price</label>
                    <input type="text" class="form-control"/>
                </div>
                <br>
                <div class="form-outline">
                    <label class="form-label" for="typeText">Description</label>
                    <input type="text" class="form-control"/>
                </div>
                <br>
                <div class="form-outline">
                    <label class="form-label" for="typeText">Image</label>
                    <input type="text" class="form-control"/>
                </div>
                <br>
            </div>
            <hr>
            <button type="button" class="btn btn-warning">ADD</button>
            <hr>
        </main>
    </div>
</div>
<script src="/js/bootstrap.js"></script>
</body>
</html>
