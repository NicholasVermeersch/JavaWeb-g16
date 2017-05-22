<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht assessements</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="menubar">Overzicht assessements</div>
             <c:forEach var="item" items="${peers}">
            <p>${item.voor.name}</p>
            <c:forEach var="antw" items="${item.antwoorden}">
                <p>  ${antw.antwoord}</p>
            </c:forEach>
        </c:forEach>
        </div>
    </body>
</html>
