package main.java;

import board.view.controller.Controller;
import board.view.controller.HandlerMapping;
import board.view.controller.ViewResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Dispatcher servlet.
 */
public class DispatcherServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewReslover;

    @Override
    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
        viewReslover   = new ViewResolver();
        viewReslover.setPrefix("./Model2/");
        viewReslover.setSuffix(".jsp");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        process(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1. Client 요청 Path 정보 추출
        String uri  = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);

        // 2. HandlerMappling을 통해 path에 해당하는 Controller를 검색
        Controller controller = handlerMapping.getController(path);
        // 3. 검색된 Controller를 실행
        String viewName = controller.handleRequest(request, response);
        // 4.ViewResolver를 통해 viewName에 해당하는 화면을 검색
        String view = null;
        if(!viewName.contains(".do")){
            view = viewReslover.getView(viewName);
        } else {
            view = viewName;
        }
        // Model2/getBoard.jsp
        // 5. 검색된 화면으로 이동
        response.sendRedirect(view);
    }
}
