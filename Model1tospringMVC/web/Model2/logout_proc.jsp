<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>