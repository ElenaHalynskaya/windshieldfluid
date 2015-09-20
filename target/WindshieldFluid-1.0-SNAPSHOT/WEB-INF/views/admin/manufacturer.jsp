<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manufacturers</title>
    </head>
    <body>
         <h1>Manufacturers list</h1>
        <c:if test="${!empty manufacturers}">
        <table>
	<tr>
                <th width="120">Id</th>
		<th width="120">Name</th>
                <th width="120">Description</th>
                <th width="120">Picture</th>
                
	</tr>
	<c:forEach items="${manufacturers}" var="manufacturer">
		<tr>
                        <td>${manufacturer.id}</td>
			<td>${manufacturer.manufacturerName}</td>
                        <td>${manufacturer.description}</td>
                        <td>${manufacturer.pictureName}</td>
                        <td><a href="<c:url value='edit/${manufacturer.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${manufacturer.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Manufacturer</h1>
        <c:url var="actionUrl" value="/manufacturers/save" />
        <form:form modelAttribute="manufacturer" method="post" action="${actionUrl}">
            <form:label path="manufacturerName">Name</form:label>
            <form:input path="manufacturerName"></form:input>
            <form:label path="description">Description</form:label>
            <form:input path="description"></form:input>
            <form:label path="pictureName">Picture</form:label>
            <form:input path="pictureName"></form:input>
            <input type="submit" value="Save"> 
        </form:form>
    </body>
</html>
