<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddCustomer page</title>
<style type="text/css">
	.error{
		color: red;
		font-family: serif;
		font-style: italic;
	}
</style>
</head>
<body>
<form:form action="addcustomer" method="post" modelAttribute="customer">
	 <form:hidden path="cusId"/> 
	Enter Cus_Name: <form:input path="cusName"/><form:errors path="cusName" class="error"/><br/>
	Enter PhoneNo: <form:input path="phNo"/><form:errors path="phNo" class="error"/><br/>
	Enter Email: <form:input path="email"/><form:errors path="email" class="error"/><br/>
	<input type="submit"/>
</form:form>

</body>
</html>