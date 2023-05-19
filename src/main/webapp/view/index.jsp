<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/11/2023
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/trang-chu/index.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>
<section class="fill-product">
    <div class="container">
        <h2 class="text-center featured-product">Featured Products</h2>
        <hr/>
        <div class="row">
            <c:forEach var="list" items="${list}">
                <div class="col-md-4">
                    <div class="card">
                        <img
                                class="card-img-top"
                                src="${list.image}"
                                alt="Card image cap"
                        />
                        <div class="card-body">
                            <a href="/product/product-detail/${list.name}" class="card-title">${list.name}</a>
                            <p class="card-text">
<%--                                    ${list.price}--%>
                            </p>
                            <a href="#" class="btn btn-primary">Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
<link rel="stylesheet" href="/js/bootstrap.js">
</body>
</html>
