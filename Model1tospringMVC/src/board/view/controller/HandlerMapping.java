package board.view.controller;

import board.view.controller.board.*;
import board.view.controller.user.LoginController;
import board.view.controller.user.LogoutController;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Handler mapping.
 */
public class HandlerMapping {
    private Map<String, Controller> mappings ;

    /**
     * Instantiates a new Handler mapping.
     */
    public HandlerMapping() {
        mappings = new HashMap<String, Controller>();
        mappings.put("/login.do", new LoginController());
        mappings.put("/getBoardList.do", new GetBoardListController());
        mappings.put("/getBoard.do", new GetBoardController());
        mappings.put("/insertBoard.do", new InsertBoardController());
        mappings.put("/updateBoard.do", new UpdateBoardController());
        mappings.put("/deleteBoard.do", new DeleteBoardController());
        mappings.put("/logout.do", new LogoutController());
    }

    /**
     * Get controller controller.
     *
     * @param path the path
     * @return the controller
     */
    public Controller getController(String path){
        return mappings.get(path);
    }
}
