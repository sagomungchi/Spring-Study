package board.view.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Created by seansin@cbnu.ac.kr.com on 04/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
public class LogoutController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그아웃 기능 처리");

        // 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
        HttpSession session = request.getSession();
        session.invalidate();

        // 2. 세션 종료 후, 메인 화면으로 이동
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:login.jsp");

        return modelAndView;
    }
}
