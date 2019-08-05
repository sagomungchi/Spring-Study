package board.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
@Controller
public class LogoutController {

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        System.out.println("로그아웃 기능 처리");

        // 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
        session.invalidate();
        return "SpringMVC/login.jsp";
    }
}
