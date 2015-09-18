<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capacity</title>
    </head>
    <body>
        <h1>Capacity</h1>
        <c:if test="${empty capacities}">
            <div>Empty list</div>
        </c:if>
    </body>
</html>
