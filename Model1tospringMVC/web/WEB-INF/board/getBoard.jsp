<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="board.impl.BoardDAO" %>
<%@ page import="board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BoardVO board = (BoardVO) session.getAttribute("board");
%>


<html>
    <head>
        <title>글 - 상세보기</title>
    </head>
    <body>
        <div style="text-align: center;">
            <h1>글 - 상세보기</h1>
            <a href="logout_proc.jsp">로그아웃</a>
            <hr>
            <form action="updateBoard.do" method="post">
                <input type="hidden" name="seq" value="${ board.seq }"/>
                <table border="1" cellspacing="0" cellpadding="0">
                    <tr>
                        <td bgcolor="orange" width="70">제목</td>
                        <td align="left">
                            <input type="text" name="title" value="${ board.title }"/>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">작성자</td>
                        <td align="left">${ board.writer }</td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">내용</td>
                        <td align="left">
                            <textarea name="content" cols="40" rows="10">
                                ${ board.content }
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">등록일</td>
                        <td align="left">${ board.regDate }</td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">조회수</td>
                        <td align="left">${ board.cnt }</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="글 수정"/>
                        </td>
                    </tr>
                </table>
            </form>
            <hr>
            <a href="${pageContext.request.contextPath}/SpringMVC/insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
            <a href="deleteBoard.do?seq=${ board.seq }">
                글 삭제
            </a>&nbsp;&nbsp;&nbsp;
            <a href="getBoardList.do">글 목록</a>&nbsp;&nbsp;&nbsp;
        </div>
    </body>
</html>
