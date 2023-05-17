<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/14/2023
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/product-css/cart.css">
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<section class="cart-body">
    <div class="container">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-7">
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <div>
                                        <p class="mb-1">Shopping cart</p>
                                        <p class="mb-0">You have 4 items in your cart</p>
                                    </div>
                                </div>
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between">
                                            <div class="d-flex flex-row align-items-center">
                                                <div>
                                                    <img
                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img1.webp"
                                                            class="img-fluid rounded-3" alt="Shopping item"
                                                            style="width: 65px;">
                                                </div>
                                                <div class="ms-3">
                                                    <h5>Iphone 11 pro</h5>
                                                    <p class="small mb-0">256GB, Navy Blue</p>
                                                </div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center">
                                                <div style="width: 50px;">
                                                    <h5 class="fw-normal mb-0">2</h5>
                                                </div>
                                                <div style="width: 80px;">
                                                    <h5 class="mb-0">$900</h5>
                                                </div>
                                                <a href="#!" style="color: #cecece;"><i
                                                        class="fas fa-trash-alt"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between">
                                            <div class="d-flex flex-row align-items-center">
                                                <div>
                                                    <img
                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img2.webp"
                                                            class="img-fluid rounded-3" alt="Shopping item"
                                                            style="width: 65px;">
                                                </div>
                                                <div class="ms-3">
                                                    <h5>Samsung galaxy Note 10 </h5>
                                                    <p class="small mb-0">256GB, Navy Blue</p>
                                                </div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center">
                                                <div style="width: 50px;">
                                                    <h5 class="fw-normal mb-0">2</h5>
                                                </div>
                                                <div style="width: 80px;">
                                                    <h5 class="mb-0">$900</h5>
                                                </div>
                                                <a href="#!" style="color: #cecece;"><i
                                                        class="fas fa-trash-alt"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between">
                                            <div class="d-flex flex-row align-items-center">
                                                <div>
                                                    <img
                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img3.webp"
                                                            class="img-fluid rounded-3" alt="Shopping item"
                                                            style="width: 65px;">
                                                </div>
                                                <div class="ms-3">
                                                    <h5>Canon EOS M50</h5>
                                                    <p class="small mb-0">Onyx Black</p>
                                                </div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center">
                                                <div style="width: 50px;">
                                                    <h5 class="fw-normal mb-0">1</h5>
                                                </div>
                                                <div style="width: 80px;">
                                                    <h5 class="mb-0">$1199</h5>
                                                </div>
                                                <a href="#!" style="color: #cecece;"><i
                                                        class="fas fa-trash-alt"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card mb-3 mb-lg-0">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between">
                                            <div class="d-flex flex-row align-items-center">
                                                <div>
                                                    <img
                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img4.webp"
                                                            class="img-fluid rounded-3" alt="Shopping item"
                                                            style="width: 65px;">
                                                </div>
                                                <div class="ms-3">
                                                    <h5>MacBook Pro</h5>
                                                    <p class="small mb-0">1TB, Graphite</p>
                                                </div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center">
                                                <div style="width: 50px;">
                                                    <h5 class="fw-normal mb-0">1</h5>
                                                </div>
                                                <div style="width: 80px;">
                                                    <h5 class="mb-0">$1799</h5>
                                                </div>
                                                <a href="#!" style="color: #cecece;"><i
                                                        class="fas fa-trash-alt"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-lg-5">

                                <div class="card bg-primary text-white rounded-3">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h5 class="mb-0">Card details</h5>
                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
                                                 class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                        </div>
                                        <form class="mt-4">
                                            <div class="form-outline form-white mb-4">
                                                <label class="form-label" for="typeName">Họ Và Tên</label>
                                                <input type="text" id="typeName" class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Họ Và Tên"/>
                                            </div>

                                            <div class="form-outline form-white mb-4">
                                                <label class="form-label" for="typePhone">Số Điện Thoại</label>
                                                <input type="text" id="typePhone" class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Số Điện Thoại"/>
                                            </div>

                                            <div class="form-outline form-white mb-4">
                                                <label class="form-label" for="typePhone">Email</label>
                                                <input type="email" id="typeEmail" class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Email"/>
                                            </div>

                                            <div class="form-outline form-white mb-4">
                                                <label class="form-label" for="typeAddress">Địa Chỉ</label>
                                                <input type="address" id="typeAddress" class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Địa Chỉ"/>
                                            </div>

                                        </form>

                                        <hr class="my-4">

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Subtotal</p>
                                            <p class="mb-2">$4798.00</p>
                                        </div>

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Shipping</p>
                                            <p class="mb-2">$20.00</p>
                                        </div>

                                        <div class="d-flex justify-content-between mb-4">
                                            <p class="mb-2">Total(Incl. taxes)</p>
                                            <p class="mb-2">$4818.00</p>
                                        </div>

                                        <button type="button" class="btn btn-info btn-block btn-lg">
                                            <div class="d-flex justify-content-between">
                                                <span>Đặt Hàng</span>
                                            </div>
                                        </button>

                                    </div>
                                </div>

                            </div>

                        </div>

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
