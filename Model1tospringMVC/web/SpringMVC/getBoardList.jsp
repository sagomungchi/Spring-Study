<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt"    prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"    prefix="fmt"%>

<%
    List<BoardVO> boardVOList = (List<BoardVO>) session.getAttribute("boardList");
%>

<html>
    <head>
        <title>글 목록</title>
    </head>
    <body>
        <div style="text-align: center;">
            <h1><spring:message code="message.board.list.mainTitle"/> </h1>
            <h3>${userName}<spring:message code="message.board.list.wecomeMsg"/> <a href="logout.do">로그아웃</a></h3>
        </div>
        <form action="getBoardList.do" method="post">
            <table border="1" cellpadding="0" cellspacing="0" width="700">
                <tr>
                    <td align="right">
                        <select name="searchCondition">
                            <c:forEach items="${conditionMap}" var="option">
                                <option value="${option.value}">${option.key}</option>
                            </c:forEach>
                        </select>
                        <input type="text" name="searchKeyword"/>
                        <input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
                    </td>
                </tr>
            </table>
        </form>

        <table border="1" cellpadding="0" cellspacing="0" width="700">
            <tr>
                <th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/> </th>
                <th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/>제목</th>
                <th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/>작성자</th>
                <th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/>등록일</th>
                <th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/>조회수</th>
            </tr>

            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.seq}</td>
                    <td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
                    <td>${board.writer}</td>
                    <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${board.cnt}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="SpringMVC/insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
    </body>
</html>
