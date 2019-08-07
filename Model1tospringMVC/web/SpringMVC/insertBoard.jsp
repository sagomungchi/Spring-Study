<%--
  Created by IntelliJ IDEA.
  User: sinsuung
  Date: 31/07/2019
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>새글등록</title>
    </head>
    <body>
        <div style="text-align: center;">
            <hr>
            <form action="../insertBoard.do" method="post">
                <table border="1" cellpadding="0" cellspacing="0">
                    <tr>
                        <td bgcolor="orange" width="70">제목</td>
                        <td align="left">
                            <input type="text" name="title" />
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">작성자</td>
                        <td align="left">
                            <input type="text" name="writer" size="10"/>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">내용</td>
                        <td align="left">
                            <textarea name="content" cols="40" rows="10"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="새글 등록"/>
                        </td>
                    </tr>
                </table>
            </form>
            <hr>
            <a href="getBoardList.do">글 목록으로</a>
        </div>
    </body>
</html>
