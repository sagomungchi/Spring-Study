package board.view.board;

import board.BoardVO;
import board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
@Controller
public class DeleteBoardController {

    @RequestMapping("deleteBoard.do")
    public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
        System.out.println("글 삭제 기능 처리");

        boardDAO.deleteBoard(vo);
        return "getBoardList.do";
    }
}
