
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       <ul> 
           <li><a href="<c:url value='capacities/' />" >Capacities</a></li>
           <li><a href="<c:url value='countries/' />" >Countries</a></li>
           <li><a href="<c:url value='fluidtypes/' />" >Fluid types</a></li>
           <li><a href="<c:url value='manufacturers/' />" >Manufacturers</a></li>
           <li><a href="<c:url value='temperatures/' />" >Temperatures</a></li>
           <li><a href="<c:url value='uses/' />" >Uses</a></li>
        </ul>
    </body>
</html>
