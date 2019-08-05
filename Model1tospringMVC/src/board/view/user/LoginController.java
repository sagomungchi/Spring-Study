package board.view.user;

import board.user.UserVO;
import board.user.impl.UserDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

    // 확장자 없는 문자열 리턴 시 자동으로 .jsp 확장자가 붙음
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그인 처리");

        String id       = request.getParameter("id");
        String password = request.getParameter("password");

        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(userVO);

        ModelAndView modelAndView = new ModelAndView();
        if(user != null){
            modelAndView.setViewName("redirect:getBoardList.do");
        } else {
            modelAndView.setViewName("redirect:/SpringMVC/login.jsp");
        }
        return modelAndView;
    }
}
