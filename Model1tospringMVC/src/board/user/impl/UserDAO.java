package board.user.impl;

import board.common.JDBCUtil;
import board.user.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection        conn = null;
    private PreparedStatement stmt = null;
    private ResultSet           rs = null;

    private final String USER_GET = "select * from users where id=? and password=?";

    public UserVO getUser(UserVO vo){
        UserVO userVO = null;
        try {
            System.out.println("===> JDBC로 getUser() 기능 처리");
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if(rs.next()){
                userVO = new UserVO();
                userVO.setId(rs.getString("ID"));
                userVO.setPassword(rs.getString("PASSWORD"));
                userVO.setName(rs.getString("NAME"));
                userVO.setRole(rs.getString("ROLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return userVO;
    }
}
