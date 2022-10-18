
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/customers" method="post">
<fieldset>
    <legend>Thong tin khach hang</legend>
    <caption>Danh sach khach hang</caption>
    <table style="width: 80%">
    <thead>
    <tr>
        <th>Ma so</th>
        <th>Ho ten</th>
        <th>Email</th>
        <th>Dia chi</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <input type="text" name ="id" value="${requestScope["customer"].getId()}">
        </td>
        <td>
            <input type="text" name="name" value="${requestScope["customer"].getName()}">
        </td>
        <td>
            <input type="text" name="email" value="${requestScope["customer"].getEmail()}">
        </td>
        <td>
            <input type="text" name="address" value="${requestScope["customer"].getAddress()}">
        </td>
    </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </tbody>
    </table>
</fieldset>
</form>
<a href="/customers">Quay lai</a>.