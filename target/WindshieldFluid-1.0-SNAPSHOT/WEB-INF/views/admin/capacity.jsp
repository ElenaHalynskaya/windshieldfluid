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
        <h1>
	Add a Capacity
</h1>

<div>
    
    
<form:form action="add" method="post" commandName="capacity">
    <table>
        <tr>
            <td>
		<form:label path="id">
                    <spring:message text="ID"/>
		</form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
            </td> 
	</tr>
	<tr>
            <td>
		<form:label path="capacityCol">
			<spring:message text="Capacity"/>
		</form:label>
            </td>
            <td>
		<form:input path="capacityCol" />
            </td> 
	</tr>
    </table>
           <input type="submit" value="Save"/>    
            <input type="reset" value="Clear"/>    
</form:form>
</div>
</body>
</html>
