<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capacity</title>
    </head>
    <body>
        <h1>Capacities list</h1>
        <c:if test="${!empty capacities}">
        <table>
	<tr>
		<th width="80">Id</th>
		<th width="120">Capacity</th>
	</tr>
	<c:forEach items="${capacities}" var="capacity">
		<tr>
			<td>${capacity.id}</td>
			<td>${capacity.capacityCol}</td>
			
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Capacity</h1>
        <c:url var="actionUrl" value="save" />
        <form:form id="capacityForm" commanName="capacity" method="post" action="${aciontUrl}">
            <form:label path="id">Id</form:label>
            <form:input path="id"></form:input>
            <form:label path="capacity">Id</form:label>
            <form:input path="capacityCol"></form:input>
            <input type="submit" value="Save"> 
        </form:form>
</body>
</html>
