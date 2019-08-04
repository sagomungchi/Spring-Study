package board.view.controller.user;

import board.user.UserVO;
import board.user.impl.UserDAO;
import board.view.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    // 확장자 없는 문자열 리턴 시 자동으로 .jsp 확장자가 붙음
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그인 처리");

        String id       = request.getParameter("id");
        String password = request.getParameter("password");

        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(userVO);

        if(user != null){
            return "getBoardList.do";
        } else {
            return "login";
        }
    }
}
