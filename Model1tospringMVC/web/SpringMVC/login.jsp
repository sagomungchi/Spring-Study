<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 30/07/2019
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags"      prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"   %>
<html>
    <head>
        <title><spring:message code="message.user.login.title"/></title>
    </head>
    <body>
        <div style="text-align: center;">
            <h1><spring:message code="message.user.login.title"/></h1>
            <a href="/login.do?lang=ko">
                <spring:message code="message.user.login.ko"/>&nbsp;&nbsp;
            </a>
            <a href="/login.do?lang=en">
                <spring:message code="message.user.login.en"/>
            </a>
            <hr>
            <form action="login.do" method="post">
                <table border="1" cellspacing="0" cellpadding="0">
                    <tr>
                        <td bgcolor="orange"><spring:message code="message.user.login.id"/></td>
                        <td><input type="text" name="id" value="${ userVO.id }"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="orange"><spring:message code="message.user.login.password"/></td>
                        <td><input type="password" name="password" value="${ userVO.password }"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="<spring:message code="message.user.login.loginBtn"/>"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
