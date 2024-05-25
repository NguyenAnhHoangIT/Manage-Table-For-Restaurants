<%-- 
    Document   : datmon
    Created on : May 18, 2024, 9:57:17 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đặt món</title>
        <link rel="stylesheet" type="text/css" href="./css/style_datmon.css">
        <script src="./js/script.js"></script>
        <script src="https://kit.fontawesome.com/45dede687a.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <aside>
            <div class="rt">
                <button class="btn_return" onclick="back()">
                    <div class="return_con"><i class="fa-solid fa-caret-left"></i></div>
                    <h3>Trở về</h3>
                </button>
            </div>
            <div class="menu">
                <ul>
                    <li><a href="ClearSession?id=back"><i class="fa-solid fa-house"></i><h3>Bàn</h3></a></li>
                    <li><a href="ClearSession?id=menu"><i class="fa-solid fa-bars"></i><h3>Menu</h3></a></li>
                    <li><a href="ClearSession?id=khuvuc"><i class="fa-solid fa-layer-group"></i><h3>Khu vực</h3></a></li>
                </ul>
            </div>
        </aside>
        <div class="main">
            <div class="title">
                <h1>Chọn món</h1>
                <hr>
            </div>
            <div class="drinks_con">
                <c:forEach items="${dsdouong}" var="ds">
                    <c:set var="id" value="${ds.maDoUong}"/>
                    <button class="drink" onclick="chonmon('${id}', '${maban}', '${trangthai}')">
                        <div class="content">
                            <div class="drink_name"><h2>${ds.tenDoUong}</h2></div>
                            <div class="drink_cost"><h3>${ds.donGia}</h3></div>
                            <div class="back_ground"></div>
                        </div>
                    </button>
                </c:forEach>
            </div>
        </div>
        <div class="baninf_con">
            <div class="tendoadon">
                <form action="" method="POST">
                    <h1>Hoá đơn #${mahoadon}</h1>
                    <input type="hidden" name="mahoadon" value="${mahoadon}">
                </form>
            </div>
            <div class="dachon_dagoi">
                <button id="${trangthai == 'Available' ? 'yes' : ''}" class="dachon">Danh sách chọn</button>
                <button id="${trangthai == 'Using' ? 'yes' : ''}" class="dagoi">Đã gọi</button>
            </div>
            <div class="chitiet_con">
                <table class="chitiet">
                    <thead>
                        <tr>
                            <th scope="col">Tên món</th>
                            <th scope="col" style="width:25%">Số lượng</th>
                            <th scope="col" style="width:25%">Giá</th>
                                <c:if test="${trangthai == 'Available'}">
                                <th scope="col" style="width:5%">Huỷ</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${trangthai != 'Using'}">
                            <c:forEach items="${cartProduct}" var="c" >
                                <tr>
                                    <td>${c.tenDoUong}</td>
                                    <td class="soluong_con">
                                        <button class="inc" onclick="inc_dec('inc', '${c.maDoUong}','${c.maDoUong}', '${maban}', '${trangthai}')" ><i class="fa-solid fa-plus"></i></button>
                                        <form action="" method="POST" class="form_dachon">
                                            <input type="hidden" name="id" value="${c.maDoUong}">
                                            <input type="text" name="quantity" value="${c.soLuong}" class="form_dachon_soluong" readonly>
                                        </form>
                                        <button class="dec" onclick="inc_dec( 'dec','${c.maDoUong}','${c.maDoUong}', '${maban}', '${trangthai}')" ><i class="fa-solid fa-minus"></i></button>
                                    </td>
                                    <td>
                                        ${c.donGia}
                                    </td>
                                    <td><button onclick="xoamon('${c.maDoUong}', '${maban}', '${trangthai}')"><i class="fa-solid fa-trash"></i></button></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${trangthai == 'Using'}">
                            <c:forEach items="${cp}" var="c" >
                                <tr>
                                    <td>${c.tenDoUong}</td>
                                    <td>
                                        <form class="form_dachon">
                                            <input type="text" name="quantity" value="${c.soLuong}" class="form_dachon_soluong" readonly>
                                        </form>                 
                                    </td>
                                    <td>
                                        ${c.donGia}
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
            <c:choose>
                <c:when test="${trangthai == 'Available'}">
                    <div class="total_cart">
                        <h2 class="thetrai">Tổng:</h2>
                        <h2 class="thephai">${tong > 0 ? tong : '0'}</h2>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="total_cart">
                        <h2 class="thetrai">Tổng:</h2>
                        <h2 class="thephai">${hd.tongTien}</h2>
                    </div>
                    <div class="thoigian_con"><h2 class="thoigian">Thời gian: ${hd.ngayBan}</h2></div>
                </c:otherwise>
            </c:choose>
            <c:if test="${trangthai == 'Available'}">
                <div class="btnxacnhan" onclick="order('${mahoadon}', '${maban}', '${trangthai}')">
                    <button>Xác nhận đặt</button>
                </div>
            </c:if>
            <c:if test="${trangthai == 'Using'}">
                <div class="btnxacnhan" onclick="done('${maban}', '${trangthai}')" >
                    <button>Xuất hoá đơn</button>
                </div>
            </c:if>
        </div>
    </body>
</html>
