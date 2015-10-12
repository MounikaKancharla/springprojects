<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>SpringMVC Mongo Example</title>
</head>
<body>
<form action="customer/save" method="post">

<label for="name">Customer Name:</label>
<input type="text" id="name" name="name"/><br>

<label for="address">Address:</label>
<input type="text" id="address" name="address"/><br>

<input type="submit" value="submit">
</form>

<table border="2">
<c:forEach var="customer" items="${customerList}">
<tr>

<td>${customer.name}</td>
<td>${customer.address}</td>

</tr>

</c:forEach>

</table>

</body>
</html> 