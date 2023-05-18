<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/17/2023
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/product-css/product-detail.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div class="container">
        <div class="card">
            <div class="row">
                <aside class="col-sm-5 border-right">
                    <article class="gallery-wrap">
                        <div class="img-big-wrap">
                            <div><a href="#"><img src="${productDetailDTO.image}"></a></div>
                        </div>
                    </article>
                </aside>
                <aside class="col-sm-7">
                    <article class="card-body p-5">
                        <h3 class="title mb-3">${productDetailDTO.name}</h3>
                        <p class="price-detail-wrap">
                    <span class="price h3 text-warning">
                        <span class="currency">${productDetailDTO.price}</span>
                    </span>
                        </p>
                        <dl class="item-property">
                            <dt>Description</dt>
                            <dd><p>${productDetailDTO.description}</p></dd>
                        </dl>
                        <dl class="param param-feature">
                            <dt>Color</dt>
                            <dd>${productDetailDTO.color}</dd>
                        </dl>
                        <div class="size-selector___2kfnl">
                            <div class="heading-container___1FcxP"><h2 class="heading___38ihw">Kích cỡ</h2></div>
                            <div class="sizes___2jQjF gl-vspace" data-auto-id="size-selector">
                                <button class="gl-label size___2lbev"><span>${productDetailDTO.size}</span></button>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <dl class="param param-inline">
                                    <dt>Quantity:</dt>
                                    <dd>
                                        <select class="form-control form-control-sm" style="width:70px;">
                                            <option> 1</option>
                                            <option> 2</option>
                                            <option> 3</option>
                                        </select>
                                    </dd>
                                </dl>  <!-- item-property .// -->
                            </div> <!-- col.// -->
                            <div class="col-sm-7">
                            </div>
                        </div>
                        <hr>
                        <a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
                        <a href="#" class="btn btn-lg btn-outline-primary text-uppercase"> <i
                                class="fas fa-shopping-cart"></i> Add to cart </a>
                    </article>
                </aside>
            </div>
        </div>
</div>
<jsp:include page="/view/footer.jsp"></jsp:include>
</body>
</html>
