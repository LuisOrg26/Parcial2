package Data;
import java.util.List;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import static Data.Conexion.*;

public class ClienteDao {
    private static final String SQL_SELECT = "SELECT id, nombre, apellidop, apellidom, email, telefono, fecha, edad, RFC, DiasCredito, Metodo, Tipo FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellidop, apellidom, email, telefono, fecha, edad, RFC, DiasCredito, Metodo, Tipo) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellidop=?, apellidom=?, email=?, telefono=?, fecha=?, edad=?, RFC=?, DiasCredito=?, Metodo=?, Tipo=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id=?";

    public List<Cliente> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

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
                int DiasCredito = rs.getInt("DiasCredito");
                String Metodo = rs.getString("Metodo");
                String Tipo = rs.getString("Tipo");

                cliente = new Cliente(id, nombre, apellidop, apellidom, email, telefono, fecha, RFC, DiasCredito, Metodo, Tipo);
                clientes.add(cliente);
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
        return clientes;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidop());
            stmt.setString(3, cliente.getApellidom());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefono());
            stmt.setString(6, cliente.getFecha());
            stmt.setInt(7, cliente.getEdad());
            stmt.setString(8, cliente.getRFC());
            stmt.setInt(9, cliente.getDiasCredito());
            stmt.setString(10, cliente.getMetodo());
            stmt.setString(11, cliente.getTipo());
            registros = stmt.executeUpdate();
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
        return registros;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidop());
            stmt.setString(3, cliente.getApellidom());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefono());
            stmt.setString(6, cliente.getFecha());
            stmt.setInt(7, cliente.getEdad());
            stmt.setString(8, cliente.getRFC());
            stmt.setInt(9, cliente.getDiasCredito());
            stmt.setString(10, cliente.getMetodo());
            stmt.setString(11, cliente.getTipo());
            stmt.setInt(12, cliente.getId());
            registros = stmt.executeUpdate();
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
        return registros;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getId());
            registros = stmt.executeUpdate();
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
        return registros;
    }
}
