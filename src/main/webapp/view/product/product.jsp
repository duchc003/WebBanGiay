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
    <link rel="stylesheet" href="/css/product-css/product.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<jsp:include page="/view/banner.jsp"></jsp:include>
<section class="container">
    <div class="row">
        <div class="col-lg-3">
            <div class="list-group">
                <div class="box-product-hot">
                    <div class="header">DANH MỤC SẢN PHẨM</div>
                    <c:forEach var="category" items="${categoryList}">
                        <a
                                type="button"
                                href="/product/view-product/category/${category.id}"
                                class="list-group-item list-group-item-action"
                        >
                                ${category.name}
                        </a>
                    </c:forEach>
                </div>
                <div class="box-product-hot">
                    <div class="header">Sản phẩm nổi bật</div>
                    <ul class="body-pro">
                        <c:forEach items="${list}" var="product">
                            <li class="item-list">
                                <a
                                        class="img-view"
                                        href="l"
                                        title=""
                                ><img
                                        src="https://cf.shopee.vn/file/4b924cc79c66d4466db085e6f7f5dfc5"
                                        align="left"
                                        alt=""
                                /></a>
                                <h5>
                                    <a
                                            class="link-view"
                                            title=""
                                            href=""
                                    >${product.name}</a
                                    >
                                </h5>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-9 all-product">
            <div class="container">
                <div class="row card-image-margin">
                    <c:forEach items="${list}" var="product">
                        <div class="col-md-4">
                            <div class="card box-produc">
                                <img
                                        src="${product.image}"
                                        class="card-img-top"
                                        alt="Sản phẩm 1"
                                />
                                <div class="card-body">
                                    <a class="link-view" title="" href="/product/product-detail/${product.name}"
                                    ><h4 class="card-title">
                                            ${product.name}
                                    </h4></a
                                    >
                                    <p class="card-text"><strong>Giá:</strong> $100</p>
                                    <button
                                            type="button"
                                            class="btn btn-primary"
                                            data-toggle="modal"
                                            data-target="#product1Modal"
                                    >
                                        Add to cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="row phan-trang">
                    <div class="col-lg-4">
                        <ul class="pagination main-pager">
                            <li class="page-item previous-center">
                                <a class="page-link" href="#" onclick="changePage(${product.number}-1)">Previous</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-lg-4">
                        <ul class="pagination main-pager">
                            <li class="page-item previous">
                                <input type="number" id="input-value" min="1" max="${product.totalPages}"
                                       style="width: 40px; border: none; appearance: none; text-align: center;"
                                       onchange="changePage(this.value)">
                                <input style="width: 70px; border: none" id="max-value"
                                       value="| ${product.totalPages}" readonly="">
                            </li>
                        </ul>
                    </div>
                    <div class="col-lg-4">
                        <ul class="pagination main-pager">
                            <li class="page-item previous-center">
                                <a class="page-link" href="#" onclick="changePage(${product.number}+1)">Next</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/view/footer.jsp"></jsp:include>
<link rel="stylesheet" href="/js/bootstrap.js">
</body>
</html>