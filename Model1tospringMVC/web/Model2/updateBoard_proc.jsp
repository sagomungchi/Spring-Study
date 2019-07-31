<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="board.impl.BoardDAO" %>
<%@ page import="board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");
    String seq     = request.getParameter("seq");
    String title   = request.getParameter("title");
    String content = request.getParameter("content");

    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setContent(content);
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.updateBoard(vo);

    response.sendRedirect("getBoardList.jsp");

%>