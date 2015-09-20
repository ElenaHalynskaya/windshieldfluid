<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Countries</title>
    </head>
    <body>
        <h1>Countries list</h1>
        <c:if test="${!empty countries}">
        <table>
	<tr>
		<th width="80">Id</th>
		<th width="120">Country</th>
                <th width="120">Picture name</th>
	</tr>
	<c:forEach items="${countries}" var="country">
		<tr>
			<td>${country.id}</td>
			<td>${country.countryName}</td>
                        <td>${country.pictureName}</td>
                        <td><a href="<c:url value='edit/${country.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${country.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Country</h1>
        <c:url var="actionUrl" value="/countries/save" />
        <form:form modelAttribute="country" method="post" action="${actionUrl}">
            <form:label path="id">Id</form:label>
            <form:input path="id"></form:input>
            <form:label path="countryName">Country name</form:label>
            <form:input path="countryName"></form:input>
            <form:label path="pictureName">Picture</form:label>
            <form:input path="pictureName"></form:input>
            <input type="submit" value="Save"> 
        </form:form>
    </body>
</html>
