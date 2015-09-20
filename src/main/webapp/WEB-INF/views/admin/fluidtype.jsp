<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fluid types</title>
    </head>
    <body>
         <h1>Fluid types list</h1>
        <c:if test="${!empty fluidtype}">
        <table>
	<tr>
		<th width="80">Id</th>
		<th width="120">Fluidtype</th>
	</tr>
	<c:forEach items="${fluidtypes}" var="fluidtype">
		<tr>
			<td>${fluidtype.id}</td>
			<td>${fluidtype.type}</td>
                        <td><a href="<c:url value='edit/${fluidtype.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${fluidtype.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a fluid type</h1>
        <c:url var="actionUrl" value="/fluidtypes/save" />
        <form:form modelAttribute="fluidtype" method="post" action="${actionUrl}">
            <form:label path="id">Id</form:label>
            <form:input path="id"></form:input>
            <form:label path="type">Type</form:label>
            <form:input path="type"></form:input>
            <input type="submit" value="Save"> 
        </form:form>
    </body>
</html>
