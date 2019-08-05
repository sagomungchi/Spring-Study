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
public class GetBoardListController {

    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView){

        modelAndView.addObject("boardList", boardDAO.getBoardList(vo));
        modelAndView.setViewName("SpringMVC/getBoardList.jsp");

        return modelAndView;
    }
}
