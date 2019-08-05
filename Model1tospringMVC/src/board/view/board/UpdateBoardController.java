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
public class UpdateBoardController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 수정 처리");

        // 1. 사용자 입력 정보 추출
        String seq     = request.getParameter("seq");
        String title   = request.getParameter("title");
        String content = request.getParameter("content");

        // 2. DB 연동 처리
        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(Integer.parseInt(seq));
        boardVO.setTitle(title);
        boardVO.setContent(content);

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.updateBoard(boardVO);

        // 3. 화면 네비게이션
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:getBoardList.do");

        return modelAndView;
    }
}
