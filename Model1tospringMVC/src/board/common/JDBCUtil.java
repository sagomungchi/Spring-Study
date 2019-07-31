package board.common;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection(){
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement stmt, Connection conn){
        if(stmt != null){
            try {
                if(!stmt.isClosed()) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if(conn != null){
            try {
                if(!conn.isClosed()) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn){
        if(rs != null){
            try {
                if(!stmt.isClosed()) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if(stmt != null){
            try {
                if(!stmt.isClosed()) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if(conn != null){
            try {
                if(!conn.isClosed()) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
