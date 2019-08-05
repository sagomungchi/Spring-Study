<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="board.impl.BoardDAO" %>
<%@ page import="board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String seq = request.getParameter("seq");

    BoardVO boardVO = new BoardVO();
    boardVO.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(boardVO);

    response.sendRedirect("getBoardList.jsp");
%>