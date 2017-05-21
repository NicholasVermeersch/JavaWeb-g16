<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peer Assesment</title>
    </head>
    <body>
        <h1>Peer Assesment</h1>
       <form:form method="POST" action="save.htm" modelAttribute="pw">

            <p><label>Vraag 1:</label>
                <c:forEach items="${pw.peerassesments}" var="peer" varStatus="status">
                    <p>${peer.voor.name}</p>
                    <form:radiobuttons path="peerassesments[${status.index}].antwoorden[0].antwoord" items="${antwoorden}"/><br/>
                </c:forEach>           
            </p>
            <p><label>Vraag 2:</label>
                <c:forEach items="${pw.peerassesments}" var="peer" varStatus="status">
                    <p>${peer.voor.name}</p>
                    <form:radiobuttons path="peerassesments[${status.index}].antwoorden[1].antwoord" items="${antwoorden}"/><br/>
                </c:forEach>              
            </p>
            <p><label>Vraag 3:</label>
                <c:forEach items="${pw.peerassesments}" var="peer" varStatus="status">
                    <p>${peer.voor.name}</p>
                    <form:radiobuttons path="peerassesments[${status.index}].antwoorden[2].antwoord" items="${antwoorden}"/><br/>
                </c:forEach>        
            </p>
            <p><label>Vraag 4:</label>
                <c:forEach items="${pw.peerassesments}" var="peer" varStatus="status">
                    <p>${peer.voor.name}</p>
                   <form:radiobuttons path="peerassesments[${status.index}].antwoorden[3].antwoord" items="${antwoorden}"/><br/>
                </c:forEach>        
            </p>
            <p><label>Vraag 5:</label>
                <c:forEach items="${pw.peerassesments}" var="peer" varStatus="status">
                    <p>${peer.voor.name}</p>
                    <form:radiobuttons path="peerassesments[${status.index}].antwoorden[4].antwoord" items="${antwoorden}"/><br/>
                </c:forEach>        
            </p>
            <p><label>Vraag 6:</label>
                <c:forEach items="${pw.peerassesments}" var="peer" varStatus="status">
                    <p>${peer.voor.name}</p>
                    <form:radiobuttons path="peerassesments[${status.index}].antwoorden[5].antwoord" items="${antwoorden}"/><br/>
                </c:forEach>        
            </p>
            <p>
                <input type="submit" value="save"/>           
            </p>
            <p>
                <input type="submit" value="bevestig" />           
            </p>

        </form:form>
    </body>
</html>
