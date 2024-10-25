<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hotan
  Date: 10/25/2024
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them Tin Tuc</title>
</head>
<body>
<form action="ThemTinTucServlet" method="post">
    Ma Danh Muc: <select name="maDM" id="maDM">
    <c:forEach items="${listdm}" var="danhMuc">
        <option value="${danhMuc.maDM}">${danhMuc.maDM}</option>
    </c:forEach>
</select> <br/> <br/>
    Tieu De: <input type="Text" name="tieuDe" id="tieuDe" /> <br/> <br/>
    Noi Dung Thong TIn: <input type="Text" name="noiDungTT" id="noiDungTT" /><br/> <br/>
    Lien ket: <input type="Text" name="lienKet" id="lienKet" /><br/> <br/>
    <input type="submit" value="Them"/>
</form>

</body>
</html>
