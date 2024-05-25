<%-- 
    Document   : ban
    Created on : May 17, 2024, 6:15:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bàn</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <script src="./js/script.js"></script>
    </head>
    <body>
        <header>
            <menu>
                <ul>
                    <li class="on"><a href="#">Bàn</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="khuvuc.jsp">Khu vực</a></li>
                </ul>
            </menu>
        </header>
        <main>
            <aside class="tabs">
                <c:forEach items="${dskhuvuc}" var="kv" varStatus="loop">
                    <c:set var="ma" value="${loop.index + 1}"/>
                    <button class="tab_item" onclick="openTab(event, 'tab${ma}')">
                        <h3>${kv.tenKhuVuc}</h3>
                    </button>
                </c:forEach>

            </aside>
            <div class="tab_content">
                <c:forEach items="${dsbantheokhu}" var="dsban" varStatus="loop">
                    <c:set var="ma" value="${loop.index + 1}"/>
                    <div class="tab_pane hide" id ="tab${ma}">
                        <c:forEach items="${dsban}" var="ban">
                            <c:set var="id" value="${ban.maBan_ID}"/>
                            <button class="tab_grid_item" onclick="datmon('${id}','${ban.trangThai}')">
                                <div class="status">
                                    <h2 class="${'Available'.equals(ban.trangThai) ? 'green' : 'red'}">${ban.trangThai}</h2>
                                </div>
                                <div class="detail_con">
                                    <h3>${ban.tenBan}</h3>
                                    <p>${ban.moTa}</p>
                                </div>
                            </button>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
        </main>
    </body>
</html>
