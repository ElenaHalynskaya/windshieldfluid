<%-- 
    Document   : index
    Created on : 12.09.2015, 1:07:45
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Windshield fluid</title>
    </head>
    <body>
        <h1>Catalogues</h1>
       <ul> 
           <li><a href="<c:url value='capacities/' />" >Capacities</a></li>
           <li><a href="<c:url value='countries/' />" >Countries</a></li>
           <li><a href="<c:url value='fluidtypes/' />" >Fluid types</a></li>
           <li><a href="<c:url value='manufacturers/' />" >Manufacturers</a></li>
           <li><a href="<c:url value='temperatures/' />" >Temperatures</a></li>
           <li><a href="<c:url value='uses/' />" >Uses</a></li>
           
        </ul>
        <h5><a href="<c:url value='fluids/' />" >Fluids</a></h5>
    </body>
</html>
