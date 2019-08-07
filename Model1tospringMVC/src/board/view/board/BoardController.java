package board.view.board;

import board.BoardService;
import board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seansin@cbnu.ac.kr.com on 05/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */

// 컨트롤러 통합
@Controller
@SessionAttributes("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //검색 조건 목록 설정
    @ModelAttribute("conditionMap")
    public Map<String, String> searchConditionMap(){
        Map<String, String> conditionMap = new HashMap<String, String>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }

    //글 등록
    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo) throws IOException {
        MultipartFile uploadFile = vo.getUploadFile();

        if(!uploadFile.isEmpty()){
            String fileName = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("/Users/sinsuung/Downloads/" + fileName));
        }

        boardService.insertBoard(vo);
        return "getBoardList.do";
    }
    //글 수정
    @RequestMapping("/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo){
        System.out.println("번호 : "   + vo.getSeq());
        System.out.println("제목 : "   + vo.getTitle());
        System.out.println("작성자 : " + vo.getWriter());
        System.out.println("내용 : "   + vo.getContent());
        System.out.println("등록일 : " + vo.getRegDate());
        System.out.println("조회수 : " + vo.getCnt());
        boardService.updateBoard(vo);
        return "getBoardList.do";
    }
    //글 삭제
    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo){
        boardService.deleteBoard(vo);
        return "getBoardList.do";
    }

    //글 상세보기
    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, Model model){
        System.out.println("작성자 이름 : " + vo.getWriter());
        model.addAttribute("board", boardService.getBoard(vo));
        return "SpringMVC/getBoard.jsp";
    }

    //글 목록보기 + 글 목록 검색
    @RequestMapping("/getBoardList.do")
    public String getBoardList(BoardVO vo, Model model){
        // Null Check
        if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
        if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

        model.addAttribute("boardList", boardService.getBoardList(vo));
        return "SpringMVC/getBoardList.jsp";
    }
}
