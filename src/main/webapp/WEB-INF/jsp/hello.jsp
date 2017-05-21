<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Hello Page</title>
        <link rel="stylesheet" type="text/css" href="Web Pages/resources/css/style.css">
    </head>
    <body>
        <h1>Message : ${message}</h1>
        <h1>Username : ${username}</h1>
        <h1>Group : ${groep}</h1>
        <h1>Cursists :</h1>
        ${cursisten}

        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
        </form>

        <c:choose>
            <c:when test="${ingediend == 1}">
                <a href="<c:url value="peerassesment.htm"/>">Bekijk peerassesment</a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="peerassesment.htm"/>">Dien peerassesment in</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>