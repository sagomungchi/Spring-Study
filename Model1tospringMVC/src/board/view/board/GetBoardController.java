package board.view.board;

import board.BoardVO;
import board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
public class GetBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 상세 조회 처리");

        // 1. 검색할 게시글 번호 추춣
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(boardVO);

        // 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("board", board);
        modelAndView.setViewName("getBoard");

        return modelAndView;
    }
}
