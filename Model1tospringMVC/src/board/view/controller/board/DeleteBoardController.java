package board.view.controller.board;

import board.BoardVO;
import board.impl.BoardDAO;
import board.view.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
public class DeleteBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 삭제 기능 처리");

        // 1. 사용자 입력 정보 추출
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(boardVO);

        return "getBoardList.do";
    }
}
