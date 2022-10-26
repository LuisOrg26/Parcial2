package Data;
import java.util.List;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import static Data.Conexion.*;

public class ProveedorDao {

    private static final String SQL_SELECT = "SELECT id, nombre, apellidop, apellidom, email, telefono, fecha, edad,RFC, DiasEntrega, CreditoD, Categoria FROM proveedor";
    private static final String SQL_INSERT = "INSERT INTO proveedor(nombre, apellidop, apellidom, email, telefono, fecha, edad, RFC, DiasEntrega, CreditoD, Categoria) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE proveedor SET nombre=?, apellidop=?, apellidom=?, email=?, telefono=?, fecha=?, edad=?, RFC=?, DiasEntrega=?, CreditoD=?, Categoria=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM proveedor WHERE id=?";

    public List<Proveedor> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Proveedor proveedor = null;
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidop = rs.getString("apellidop");
                String apellidom = rs.getString("apellidom");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String fecha = rs.getString("fecha");
                int edad = rs.getInt("edad");
                String RFC = rs.getString("RFC");
                String DiasEntrega = rs.getString("DiasEntrega");
                double CreditoD = rs.getDouble("CreditoD");
                String Categoria = rs.getString("Categoria");

                proveedor = new Proveedor(id, nombre, apellidop, apellidom, email, telefono, fecha, edad, RFC, DiasEntrega, CreditoD, Categoria);
                proveedores.add(proveedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return proveedores;
    }

    public int insertar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getApellidop());
            stmt.setString(3, proveedor.getApellidom());
            stmt.setString(4, proveedor.getEmail());
            stmt.setString(5, proveedor.getTelefono());
            stmt.setString(6, proveedor.getFecha());
            stmt.setInt(7, proveedor.getEdad());
            stmt.setString(8, proveedor.getRFC());
            stmt.setString(9, proveedor.getDiasEntrega());
            stmt.setDouble(10, proveedor.getCreditoD());
            stmt.setString(11, proveedor.getCategoria());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return rows;
    }

    public int actualizar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getApellidop());
            stmt.setString(3, proveedor.getApellidom());
            stmt.setString(4, proveedor.getEmail());
            stmt.setString(5, proveedor.getTelefono());
            stmt.setString(6, proveedor.getFecha());
            stmt.setInt(7, proveedor.getEdad());
            stmt.setString(8, proveedor.getRFC());
            stmt.setString(9, proveedor.getDiasEntrega());
            stmt.setDouble(10, proveedor.getCreditoD());
            stmt.setString(11, proveedor.getCategoria());
            stmt.setInt(12, proveedor.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return rows;
    }

    public int eliminar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, proveedor.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return rows;
    }
}
