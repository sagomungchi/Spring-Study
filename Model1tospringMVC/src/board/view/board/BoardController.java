package board.view.board;

import board.BoardVO;
import board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by seansin@cbnu.ac.kr.com on 05/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */

// 컨트롤러 통합
@Controller
public class BoardController {
    //글 등록
    @RequestMapping("/inserBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO){
        boardDAO.insertBoard(vo);
        return "getBoardList.do";
    }
    //글 수정
    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo, BoardDAO boardDAO){
        boardDAO.updateBoard(vo);
        return "getBoardList.do";
    }
    //글 삭제
    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
        boardDAO.deleteBoard(vo);
        return "getBoardList.do";
    }
    //글 상세보기
    @RequestMapping("/getBoard.do")
    public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView){
        modelAndView.addObject(boardDAO.getBoard(vo));
        modelAndView.setViewName("SpringMVC/getBoard.jsp");

        return modelAndView;
    }
    //글 목록보기
    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView){
        modelAndView.addObject(boardDAO.getBoardList(vo));
        modelAndView.setViewName("SpringMVC/getBoardList.jsp");

        return modelAndView;
    }
}
