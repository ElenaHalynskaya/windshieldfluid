<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fluids</title>
           
    </head>
    <body>
       <h1>Fluids list</h1>
        <c:if test="${!empty fluids}">
        <table>
	<tr>
		<th width="50">Id</th>
		<th width="100">Fluid</th>
                <th width="100">Picture</th>
                <th width="100">Capacity</th>
                <th width="100">Country</th>
                <th width="100">Type</th>
                <th width="100">Manufacturer</th>
                <th width="100">Temperature</th>
                <th width="100">Use</th>
                <th width="100">Price</th>
	</tr>
	<c:forEach items="${fluids}" var="fluid">
		<tr>
			<td>${fluid.id}</td>
			<td>${fluid.fluidName}</td>
                        <td>${fluid.pictureName}</td>
                        <td>${fluid.capacity.capacityCol}</td>
                        <td>${fluid.country.countryName}</td>
                        <td>${fluid.fluidType.type}</td>
                        <td>${fluid.manufacturer.manufacturerName}</td>
                        <td>${fluid.temperature.range}</td>
                        <td>${fluid.use.useName}</td>
                        <td>${fluid.price}</td>
                        <td><a href="<c:url value='edit/${fluid.id}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${fluid.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
        </c:if>
        <h1>Add a Capacity</h1>
        <c:url var="actionUrl" value="/fluids/save" />
        <form:form modelAttribute="fluid" method="post" action="${actionUrl}">
            <form:hidden path="id" />
            <form:label  path="fluidName">Fluid</form:label>
            <form:input path="fluidName"></form:input>
            <form:errors path="fluidName" />
            <br>
            <form:label path="pictureName">Picture</form:label>
            <form:input path="pictureName"></form:input>
            <form:errors path="pictureName" />
            <br>
            <form:label path="capacity">Capacity</form:label>
            <form:select path="capacity" items="${capacities}" itemValue="id" itemLabel="capacityCol"/>
            <form:errors path="capacity" />
            <br>
            <form:label path="country">Country</form:label>
            <form:select path="country" items="${countries}" itemValue="id" itemLabel="countryName"/>
            <br>
            <form:label path="fluidType">Type</form:label>
            <form:select path="fluidType" items="${fluidtypes}" itemValue="id" itemLabel="type"/>
            <br>
            <form:label path="manufacturer">Manufacturer</form:label>
            <form:select path="manufacturer" items="${manufacturers}" itemValue="id" itemLabel="manufacturerName"/>
            <br>
            <form:label path="temperature">Temperature</form:label>
            <form:select path="temperature" items="${temperatures}" itemValue="id" itemLabel="range"/>
            <br>
            <form:label path="use">Uses</form:label>
            <form:select path="use" items="${uses}" itemValue="id" itemLabel="useName"/>
            <br>
            <form:label path="price">Price</form:label>
            <form:input path="price"></form:input>
            <form:errors path="price" />
            <br>
            <input type="submit" value="Save"> 
        </form:form>
    </body>
</html>
