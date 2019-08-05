<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="board.user.impl.UserDAO" %>
<%@ page import="board.user.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO  userVO  = userDAO.getUser(vo);

    if(userVO != null){
        response.sendRedirect("getBoardList.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>