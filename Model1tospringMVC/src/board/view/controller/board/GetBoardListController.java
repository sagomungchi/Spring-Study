package board.view.controller.board;

import board.BoardVO;
import board.impl.BoardDAO;
import board.view.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 목록 검색 처리");

        // 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
        // 2. DB 연동 처리
        BoardVO boardVO = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(boardVO);

        // 3. 검색 결과를 세션에 저장하고 목록 화면을 리턴
        HttpSession session = request.getSession();
        session.setAttribute("boardList", boardList);
        return "getBoardList";
    }
}
