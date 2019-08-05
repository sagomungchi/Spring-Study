package board.view.controller.user;

import board.view.controller.Controller;

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
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그아웃 기능 처리");

        // 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
        HttpSession session = request.getSession();
        session.invalidate();

        return "login";
    }
}
