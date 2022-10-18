<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Product Management</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        form{
            display: flex;
        }
        .btn-outline-success{
            float: left;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/customers">Danh sách khách hàng</a>
        <form action = "search">
            <input class="form-control" type="search" name="product" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Tìm</button>
        </form>
        <a class="navbar-brand" href="<%=request.getContextPath()%>/new">Thêm khách hàng</a>
    </div>

</nav>
</body>
</html>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
Co <%= customers.size() %> khach hang trong danh sach.
<table style="width: 100%">
    <thead>
    <tr>
        <th>Ma so</th>
        <th>Ho ten</th>
        <th>Email</th>
        <th>Dia chi</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.customers}" var="c">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <a href="/customerDetail/${c.id}">${c.name}</a>
            </td>
            <td>
                <c:out value="${c.email}"/>
            </td>
            <td>
                <c:out value="${c.address}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>