<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <spring:url value="http://users.hogent.be/~530534jp/style.css" var="urlCss"/>
       <link rel="stylesheet" href="${urlCss}" type="text/css" />
    </head>
    
    <body id="loginbody" onload='document.loginForm.username.focus();'>
        <div id="logo"></div>
        <div id="login-box">

            <h2>Welkom bij Give A Day</h2>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
                
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

           <form name='loginForm' action="<c:url value='/login' />" method='POST'>
               <table id="table">
                    <tr id="x">
                        <td id="y"><input id="logininput" placeholder="Gebruikersnaam" type='text' name='username' value=''></td>
                    </tr>
                    <tr id="x">
                        <td><input id="logininput" placeholder="Wachtwoord" type='password' name='password' /></td>
                    </tr>
                    <tr id="x">
                        <td id="y"><input id="loginbutton" name="submit" type="submit"
                                               value="Log in" /></td>
                    </tr>
                </table>

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />

            </form>
        </div>

    </body>
</html>