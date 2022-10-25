package test;
import java.sql.*;
import domain.*;
import Data.Conexion;

public class testPersona {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/segundo_parcial?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try{
            Connection conn = DriverManager.getConnection(url, "root", "1234");
            var sql = "SELECT id, nombre, apellidop, apellidom, email, telefono, fecha, RFC, DiasEntrega, CreditoD, Categoria FROM proveedor";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nombre: " + rs.getString("nombre"));
                System.out.println("apellidop: " + rs.getString("apellidop"));
                System.out.println("apellidom: " + rs.getString("apellidom"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("telefono: " + rs.getString("telefono"));
                System.out.println("fecha: " + rs.getString("fecha"));
                System.out.println("edad:" + rs.getInt("edad"));
                System.out.println("RFC: " + rs.getString("RFC"));
                System.out.println("DiasEntrega: " + rs.getString("DiasEntrega"));
                System.out.println("CreditoD: " + rs.getString("CreditoD"));
                System.out.println("Categoria: " + rs.getString("Categoria"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }

    }
}
