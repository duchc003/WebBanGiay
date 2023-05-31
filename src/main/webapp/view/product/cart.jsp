<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <c:forEach items="${cartDetailDTOS}" var="list" varStatus="loop">
                                    <div class="card mb-3 mb-lg-0">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex flex-row align-items-center">
                                                    <div>
                                                        <img src="${list.image}" class="img-fluid rounded-3"
                                                             alt="Shopping item" style="width: 65px;">
                                                    </div>
                                                    <div class="ms-3">
                                                        <h5 style="font-size: 15px">${list.name}</h5>
                                                    </div>
                                                    <div class="G7E4B7">
                                                        <div><span class="M-AAFK vWt6ZL">₫${list.price}</span><span
                                                                class="M-AAFK">₫${list.unitPrice}</span></div>
                                                    </div>
                                                    <form action="/cart/update" method="post">
                                                        <div class="mXmGu+ shopee-input-quantity">

                                                            <button type="submit" class="mJX7hG"
                                                                    onclick="decreaseValue(${loop.index})">
                                                                -
                                                            </button>
                                                            <input id="quantityInput${loop.index}"
                                                                   class="mJX7hG _8BP9GU"
                                                                   type="text" role="spinbutton" aria-valuenow="1"
                                                                   value="${list.quantity}" name="cart.quantity">
                                                            <button type="submit" class="mJX7hG"
                                                                    onclick="increaseValue(${loop.index})">
                                                                +
                                                            </button>
                                                        </div>
                                                    </form>
                                                    <a href="">Xóa</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
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
                                                <input type="address" id="typeAddress"
                                                       class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Địa Chỉ"/>
                                            </div>

                                        </form>
                                        <hr class="my-4">
                                        <div class="d-flex justify-content-between mb-4">
                                            <p class="mb-2">Total(Incl. taxes)</p>
                                            <p class="mb-2">${total.unitPrice}</p>
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
<script>
    function deleteProduct(index) {
        var deleteFlagInput = document.getElementById("deleteFlag" + index);
        var quantityInput = document.getElementById("quantityInput" + index);
        var quantity = parseInt(quantityInput.value);
        if (quantity === 1) {
            if (confirm("Bạn có muốn xóa sản phẩm này khỏi giỏ hàng không")) {
                deleteFlagInput.value = "true";
            }
        } else {
            deleteFlagInput.value = "false";
        }
        var form = deleteFlagInput.closest("form");
        form.submit();
    }

    function decreaseValue(index) {
        var input = document.getElementById("quantityInput" + index);
        var value = parseInt(input.value);
        if (value > 1) {
            input.value = value - 1;
        }
    }

    function increaseValue(index) {
        var input = document.getElementById("quantityInput" + index);
        var value = parseInt(input.value);
        input.value = value + 1;
    }
</script>
<script src="/js/bootstrap.js"></script>
</body>
</html>
