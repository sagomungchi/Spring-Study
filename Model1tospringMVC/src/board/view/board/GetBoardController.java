package board.view.board;

import board.BoardVO;
import board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
@Controller
public class GetBoardController {

    @RequestMapping("/getBoard.do")
    public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView) {
        System.out.println("글 상세 조회 처리");

        modelAndView.addObject("board", boardDAO.getBoard(vo));
        modelAndView.setViewName("SpringMVC/getBoard.jsp");

        return modelAndView;
    }
}
