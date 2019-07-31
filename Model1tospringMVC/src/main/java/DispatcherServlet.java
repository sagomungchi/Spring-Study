package main.java;

import board.BoardVO;
import board.impl.BoardDAO;
import board.user.UserVO;
import board.user.impl.UserDAO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DispatcherServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        process(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri  = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);

        if(path.equals("/login.do")){
            System.out.println("로그인 처리");

            String id       = request.getParameter("id");
            String password = request.getParameter("password");

            UserVO userVO = new UserVO();
            userVO.setId(id);
            userVO.setPassword(password);

            UserDAO user = new UserDAO();
            user.getUser(userVO);

            if(user != null){
                response.sendRedirect("getBoardList.do");
            } else {
                response.sendRedirect("login.jsp");
            }

        } else if(path.equals("/logout.do")){
            System.out.println("로그아웃 처리");

            HttpSession httpSession = request.getSession();
            httpSession.invalidate();

        } else if(path.equals("/insertBoard.do")){
            System.out.println("글 등록 처리");

            String title   = request.getParameter("title");
            String writer  = request.getParameter("writer");
            String content = request.getParameter("content");

            BoardVO boardVO = new BoardVO();
            boardVO.setTitle(title);
            boardVO.setWriter(writer);
            boardVO.setContent(content);

            BoardDAO boardDAO = new BoardDAO();
            boardDAO.insertBoard(boardVO);

            response.sendRedirect("getBoardList.do");

        } else if(path.equals("/updateBoard.do")){
            System.out.println("글 수정 처리");

            String seq     = request.getParameter("seq");
            String title   = request.getParameter("title");
            String content = request.getParameter("content");

            BoardVO boardVO = new BoardVO();
            boardVO.setTitle(title);
            boardVO.setContent(content);
            boardVO.setSeq(Integer.parseInt(seq));

            BoardDAO boardDAO = new BoardDAO();
            boardDAO.updateBoard(boardVO);

            response.sendRedirect("getBoardList.do");

        } else if(path.equals("/deleteBoard.do")){
            System.out.println("글 삭제 처리");

            String seq = request.getParameter("seq");

            BoardVO boardVO = new BoardVO();
            boardVO.setSeq(Integer.parseInt(seq));

            BoardDAO boardDAO = new BoardDAO();
            boardDAO.deleteBoard(boardVO);

            response.sendRedirect("getBoardList.do");

        } else if(path.equals("/getBoard.do")){
            System.out.println("글 상세 조회 처리");

            String seq = request.getParameter("seq");

            BoardVO boardVO = new BoardVO();
            boardVO.setSeq(Integer.parseInt(seq));

            BoardDAO boardDAO = new BoardDAO();
            BoardVO board = boardDAO.getBoard(boardVO);

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("board", board);
            response.sendRedirect("getBoard.jsp");

        } else if(path.equals("/getBoardList.do")){
            System.out.println("글 목록 검색 처리");

            BoardVO boardVO = new BoardVO();
            BoardDAO boardDAO = new BoardDAO();
            List<BoardVO> boardList = boardDAO.getBoardList(boardVO);

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("boardList", boardList);
            response.sendRedirect("getBoardList.jsp");
        }
    }
}
