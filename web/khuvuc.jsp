<%-- 
    Document   : khuvuc
    Created on : May 19, 2024, 5:31:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý khu vực, bàn</title>
        <link rel="stylesheet" type="text/css" href="./css/style_khuvuc.css">
        <script src="./js/script.js"></script>
        <script src="https://kit.fontawesome.com/45dede687a.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <menu>
                <ul>
                    <li><a href="ban.jsp">Bàn</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li class="on"><a href="#">Khu vực</a></li>
                </ul>
            </menu>
        </header>
        <main>
            <div class="left">
                <div class="title"><h1>Khu vực:</h1></div>
                <div class="tabs nihao">
                    <div class="sapxep">
                        <c:forEach items="${dskhuvuc}" var="kv" varStatus="loop">
                            <c:set var="ma" value="${loop.index + 1}"/>
                            <button class="tab_item" onclick="openTab(event, 'tab${ma}')">
                                <h3>${kv.tenKhuVuc}</h3>
                            </button>
                        </c:forEach>
                        <button class="tab_item_plus nodecor" onclick="showForm('themkhuvuc')" >
                            <div class="modify_plus">
                                <i class="fa-solid fa-plus"></i>
                            </div>
                        </button>
                    </div>
                </div>
                <div class="title"><h1>Bàn:</h1></div>
                <div class="tab_content nihao">
                    <c:forEach items="${dsbantheokhu}" var="dsban" varStatus="loop">
                        <c:set var="ma" value="${loop.index + 1}"/>
                        <div class="tab_pane hide" id ="tab${ma}">
                            <c:forEach items="${dsban}" var="ban">
                                <c:set var="id" value="${ban.maBan_ID}"/>
                                <button class="tab_grid_item">
                                    <div class="detail_con">
                                        <h3>${ban.tenBan}</h3>
                                        <p>${ban.moTa}</p>
                                    </div>
                                </button>
                            </c:forEach>
                            <button class="tab_grid_item_plus nodecor" onclick="showForm('themban')" >
                                <div class="modify_plus">
                                    <i class="fa-solid fa-plus"></i>
                                </div>
                            </button>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="right">
                <form class="themkhuvuc form-container" method="POST">
                    <h1>Thêm khu vực</h1>
                    <label>Tên khu vực</label>
                    <input type="text" name="tenkhuvuc">
                    <label>Mô tả</label>
                    <textarea id="motakhuvuc" name="motakhuvuc" rows="2"></textarea>
                    <div class="btncon">
                        <button type="submit">Xác nhận</button>
                    </div>
                </form>
                <form class="themban form-container" method="POST">
                    <h1>Thêm bàn</h1>
                    <label>Tên bàn</label>
                    <input type="text" name="tenban">
                                        <label>Khu vực</label>
                    <select name="khuvuc" id="khuvuc">
                        <c:forEach items="${dskhuvuc}" var="d" >
                            <option value="${d.maKhuVuc_ID}">${d.tenKhuVuc}</option>
                        </c:forEach>
                    </select>
                    <label>Mô tả</label>
                    <textarea id="motaban" name="motaban" rows="2"></textarea>
                    <div class="btncon">
                        <button type="submit">Xác nhận</button>
                    </div>
                </form>
            </div>
        </main>
    </body>
</html>
