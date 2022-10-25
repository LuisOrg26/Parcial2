package Data;
import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/segundo_parcial?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1234";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    public static void close(ResultSet rs) throws SQLException {
        try{
            rs.close();
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Statement stmt) throws SQLException {
        try{
            stmt.close();
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    public static void close(Connection conn) throws SQLException {
        try{
            conn.close();
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
