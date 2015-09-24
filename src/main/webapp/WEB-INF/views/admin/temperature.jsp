<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Temperatures</title>
    </head>
    <body>
        <h1>Temperatures list</h1>
        <c:if test="${!empty temperatures}">
        <table>
	<tr>
		<th width="80">Id</th>
		<th width="120">Min</th>
                <th width="120">Max</th>
	</tr>
	<c:forEach items="${temperatures}" var="temperature">
		<tr>
			<td>${temperature.id}</td>
			<td>${temperature.temperatureMin}</td>
                        <td>${temperature.temperatureMax}</td>
                        <td><a href="<c:url value='edit/${temperature.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${temperature.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Tempereature</h1>
        <c:url var="actionUrl" value="/temperatures/save" />
        <form:form modelAttribute="temperature" method="post" action="${actionUrl}">
            <form:hidden path="id" />
            <form:label path="temperatureMin">Min</form:label>
            <form:input path="temperatureMin"></form:input>
            <form:errors path="temperatureMin" />
            <br>
            <form:label path="temperatureMax">Max</form:label>
            <form:input path="temperatureMax"></form:input>
            <form:errors path="temperatureMax" />
            <br>
            <input type="submit" value="Save"> 
        </form:form>
    </body>
</html>
