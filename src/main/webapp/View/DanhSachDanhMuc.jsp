<%--
  Created by IntelliJ IDEA.
  User: hotan
  Date: 10/25/2024
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello from hell</title>
</head>
<body>
<h2>Danh Sach Danh Muc </h2>
<script>
    function handeleItemPress(maDanhMuc, TenDanhMuc, NguoiQL, GhiChu){
        document.getElementById('maDM').value=maDanhMuc;
        document.getElementById('tenDM').value=TenDanhMuc;
        document.getElementById('nguoiQL').value=NguoiQL;
        document.getElementById('ghiChu').value=GhiChu;

    }
    function handeleclick(){
        document.getElementById('maDM').value="";
        document.getElementById('tenDM').value="";
        document.getElementById('nguoiQL').value="";
        document.getElementById('ghiChu').value="";
    }
</script>
<table border="1">

    <thead>
    <tr>
        <th>Ma Danh Muc</th>
        <th>Ten Danh Muc</th>
        <th>Ghi Chu</th>
        <th>Nguoi quan ly</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listDM}" var="DanhMuc">
        <tr onclick="handeleItemPress('${DanhMuc.maDM}','${DanhMuc.tenDm}','${DanhMuc.nguoiQL}','${DanhMuc.ghiChu}')">
            <td>${DanhMuc.maDM}</td>
            <td>${DanhMuc.tenDm}</td>
            <td>${DanhMuc.nguoiQL}</td>
            <td>${DanhMuc.ghiChu}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<br/>

<form action="DanhSachDanhMucMucServlet" method="post">
    Ma Danh Muc: <input type="text" name ="maDM" id="maDM" readonly><br/> <br/>
    Ten Danh Muc : <input type="text" name="tenDM" id="tenDM" /> <br/><br/>
    Nguoi Quan Ly: <input type="text" name="nguoiQL" id="nguoiQL" /> <br/> <br/>
    Ghi Chu: <input type="text" name="ghiChu" id="ghiChu" />
    <input type="submit" name ="action" value="Them" onclick="handelleclick()" />
    <input type="submit" name ="action" value="Delete" onclick="handelleclick()" />
    <input type="submit" name ="action" value="Update" onclick="handelleclick()" />
</form>

<div>
    <ul>
        <li><a href="DanhSachDanhMucMucServlet">Danh Sach Danh Muc</a></li>
        <li><a href="DanhSachTinTucServlet">Danh Sach Tin Tuc</a></li>
        <li><a href="DanhSachTTTheoDanhMucSerVLet">Danh Sach Tin Tuc Theo Danh muc</a></li>
        <li><a href="ThemTinTucServlet">Them Tin Tuc</a></li>
        <li><a href="index.jsp">Trang Chu</a></li>

    </ul>
</div>
</body>
</html>
