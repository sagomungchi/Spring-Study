package board.view.user;

import board.user.UserVO;
import board.user.impl.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    // 확장자 없는 문자열 리턴 시 자동으로 .jsp 확장자가 붙음
    @RequestMapping("/login.do")
    public String login(UserVO vo, UserDAO userDAO){
        System.out.println("로그인 처리");

        if(userDAO.getUser(vo) != null) return "getBoardList.do";
        else return "SpringMVC/login.jsp";
    }
}
