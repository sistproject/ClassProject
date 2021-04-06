<%@page import="oracle.jdbc.aq.AQDequeueOptions.DeliveryFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String id=(String)session.getAttribute("id");
	int deliveryFee = 3000;
	int discount = 0;
	int total= (int)request.getAttribute("total"); 
	int cnt= (int)request.getAttribute("cnt"); 
	if(total>100000) {
		deliveryFee = 0;
		discount = deliveryFee*cnt;
	}
	int price=total + deliveryFee*cnt;
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="../main/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="../main/styles/responsive.css">
<link rel="stylesheet" href="../main/styles/main_styles.css">
<script src="./js/bootstrap.bundle.min.js" defer></script>
<script src="./js/jquery-3.3.1.slim.min.js" defer></script>
<title>Document</title>
</head>
<body>
  <div class="px-4 px-lg-0" style="margin-top:8%">
    <!-- For demo purpose -->
    <div class="container text-white py-5 text-center">
      <h1 class="display-4">장바구니</h1>
    </div>
    <!-- End -->
  
    <div class="pb-5">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
  
            <!-- Shopping cart table -->
            <div class="table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col" class="border-0 bg-light" width=60%>
                      <div class="p-2 px-3 text-uppercase">Product</div>
                    </th>
                    <th scope="col" class="border-0 bg-light" width=12%>
                      <div class="py-2 text-uppercase">Price</div>
                    </th>
                    <th scope="col" class="border-0 bg-light" width=12%>
                      <div class="py-2 text-uppercase">Quantity</div>
                    </th>
                    <th scope="col" class="border-0 bg-light" width=12%>
                      <div class="py-2 text-uppercase">Remove</div>
                    </th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="w" items="${wlist}">
                  <tr class="items">
                    <th scope="row" class="border-0">
                      <div class="p-2">
                        <img src="${w.poster}" alt="" style="width:70px; height:70px" class="img-fluid rounded shadow-sm">
                        <div class="ml-3 d-inline-block align-middle">
                          <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">${w.title}</a></h5><span class="text-muted font-weight-normal font-italic d-block">artist: ${w.artist}</span>
                        </div>
                      </div>
                    </th>
                    <td class="border-0 align-middle"><strong>${w.price}</strong></td>
                    <td class="border-0 align-middle"><strong>${w.quantity}</strong></td>
                    <td class="border-0 align-middle"><a href="../cart/cart_remove.do?wno=${w.no }" class="text-dark"><i id="remove" class="fa fa-trash"></i></a></td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- End -->
            <div class="table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col" class="border-0 bg-light" width=60%>
                      <div class="p-2 px-3 text-uppercase">Class</div>
                    </th>
                    <th scope="col" class="border-0 bg-light" width=12%>
                      <div class="py-2 text-uppercase">Price</div>
                    </th>
                    <th scope="col" class="border-0 bg-light" width=12%>
                      <div class="py-2 text-uppercase">Quantity</div>
                    </th>
                    <th scope="col" class="border-0 bg-light" width=12%>
                      <div class="py-2 text-uppercase">Remove</div>
                    </th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="c" items="${clist}">
                  <tr class="items">
                    <th scope="row" class="border-0">
                      <div class="p-2">
                        <img src="${c.poster}" alt="" style="width:70px; height:70px" class="img-fluid rounded shadow-sm">
                        <div class="ml-3 d-inline-block align-middle">
                          <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">${c.title}</a></h5><span class="text-muted font-weight-normal font-italic d-block">artist: ${c.artist}</span>
                        </div>
                      </div>
                    </th>
                    <td class="border-0 align-middle"><strong>${c.price}</strong></td>
                    <td class="border-0 align-middle"><strong>${c.quantity}</strong></td>
                    <td class="border-0 align-middle"><a href="../cart/cart_remove.do?cno=${c.no }" class="text-dark"><i id="remove" class="fa fa-trash"></i></a></td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- end -->
          </div>
        </div>
  
        <div class="row py-5 p-4 bg-white rounded shadow-sm">
          <div class="col-lg-6">
            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon code</div>
            <div class="p-4">
              <p class="font-italic mb-4">If you have a coupon code, please enter it in the box below</p>
              <div class="input-group mb-4 border rounded-pill p-2">
                <input type="text" placeholder="Apply coupon" aria-describedby="button-addon3" class="form-control border-0">
                <div class="input-group-append border-0">
                  <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Apply coupon</button>
                </div>
              </div>
            </div>
            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
            <div class="p-4">
              <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
              <textarea name="" cols="30" rows="2" class="form-control"></textarea>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
            <div class="p-4">
              <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
              <ul class="list-unstyled mb-4">
                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>₩ ${total}</strong></li>
                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">deliveryFee</strong><strong>₩ <%=deliveryFee %></strong></li>
                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">discount</strong><strong>₩ <%=discount %></strong></li>
                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                  <h5 class="font-weight-bold">₩ <%=price%></h5>
                </li>
              </ul><a href="../cart/cart_checkout.do" class="btn btn-dark rounded-pill py-2 btn-block" id="checkout">Procceed to checkout</a>
            </div>
          </div>
        </div>
  
      </div>
    </div>
  </div>
<script src="../main/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../main/js/custom.js"></script>
</body>
</html>