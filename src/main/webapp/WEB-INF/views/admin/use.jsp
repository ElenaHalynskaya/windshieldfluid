<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uses</title>
    </head>
    <body>
        <h1>Uses list</h1>
        <c:if test="${!empty uses}">
        <table>
	<tr>
		<th width="80">Id</th>
		<th width="120">Use</th>
	</tr>
	<c:forEach items="${uses}" var="use">
		<tr>
			<td>${use.id}</td>
			<td>${use.useName}</td>
                        <td><a href="<c:url value='edit/${use.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${use.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Use</h1>
        <c:url var="actionUrl" value="/uses/save" />
        <form:form modelAttribute="use" method="post" action="${actionUrl}">
           
            <form:hidden path="id" />
            <form:label path="useName">Use</form:label>
            <form:input path="useName"></form:input>
            <form:errors path="useName" />
            <br>
            <input type="submit" value="Save"> 
        </form:form>
    </body>
</html>
