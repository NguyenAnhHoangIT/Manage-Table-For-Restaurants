<%-- 
    Document   : menu
    Created on : May 19, 2024, 11:55:43 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" type="text/css" href="./css/style_menu.css">
        <script src="./js/script.js"></script>
        <script src="https://kit.fontawesome.com/45dede687a.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <menu>
                <ul>
                    <li><a href="ban.jsp">Bàn</a></li>
                    <li class="on"><a href="#">Menu</a></li>
                    <li><a href="khuvuc.jsp"">Khu vực</a></li>
                </ul>
            </menu>
        </header>
        <main>
            <div class="con_con">
                <div class="drinks_con">
                    <c:forEach items="${dsdouong}" var="ds">
                        <c:set var="id" value="${ds.maDoUong}"/>
                        <button class="drink">  
                            <div class="content">
                                <div class="drink_name"><h2>${ds.tenDoUong}</h2></div>
                                <div class="drink_cost"><h3>${ds.donGia}</h3></div>
                                <div class="back_ground"></div>
                            </div>
                        </button>
                    </c:forEach>
                    <button class="them_con">  
                        <div class="them_bg">
                            <i class="fa-solid fa-plus"></i>
                        </div>
                    </button>
                </div>
            </div>
            <div class="add_con">
                <form class="frm" method="POST">
                    <div class="ten_con">
                        <label>Tên món mới:</label>
                        <input type="text" name="ten" id="ten">
                    </div>
                    <div class="danhmuc_con">
                        <label>Danh mục:</label>
                        <select class="se" name="danhmuc" id="danhmuc">
                            <c:forEach items="${dsdanhmuc}" var="d" >
                                <option value="${d.maDanhMuc_ID}">${d.tenDanhMuc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="dongia_con">
                        <label>Đơn giá:</label>
                        <input type="text" name="dongia" id="dongia">
                    </div>
                    <div class="tungay_con">
                        <label>Từ ngày:</label>
                        <input type="date" name="tungay" id="tungay">
                    </div>
                    <div class="denngay_con">
                        <label>Đến ngày:</label>
                        <input type="date" name="denngay" id="denngay">
                    </div>
                    <button type="submit">Xác nhận</button>
                </form>
            </div>
        </main>
    </body>
</html>
