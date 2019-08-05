<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="board.impl.BoardDAO" %>
<%@ page import="board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");
    String title   = request.getParameter("title");
    String writer  = request.getParameter("writer");
    String content = request.getParameter("content");

    BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setWriter(writer);
        boardVO.setContent(content);

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.insertBoard(boardVO);

    response.sendRedirect("getBoardList.jsp");
%>