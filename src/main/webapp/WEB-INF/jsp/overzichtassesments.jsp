<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht assessments</title>
    </head>
    <body>
        <c:forEach var="item" items="${peers}">
            ${item.voor.name}
            <c:forEach var="antw" items="${item.antwoorden}">
                ${antw.antwoord}
            </c:forEach>

        </c:forEach>
    </body>
</html>
