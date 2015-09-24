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
                        <td><a href="<c:url value='edit/${capacity.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${capacity.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Capacity</h1>
        <c:url var="actionUrl" value="/capacities/save" />
        <form:form modelAttribute="capacity" method="post" action="${actionUrl}">
            <form:hidden path="id" />
            <form:label path="capacityCol">CapacityCol</form:label>
            <form:input path="capacityCol"></form:input>
            <form:errors path="capacityCol" />
            <br>
            <input type="submit" value="Save"> 
        </form:form>
</body>
</html>
