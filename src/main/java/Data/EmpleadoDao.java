package Data;
import java.util.List;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import static Data.Conexion.*;
public class EmpleadoDao {

    private static final String SQL_SELECT = "SELECT id, nombre, apellidop, apellidom, email, telefono, fecha, edad, RFC, NSC, CURP, antiguedad, puesto FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado(id, nombre, apellidop, apellidom, email, telefono, fecha, edad, RFC, NSC, CURP, antiguedad, puesto) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre=?, apellidop=?, apellidom=?, email=?, telefono=?, fecha=?, edad=?, RFC=?, NSC=?, CURP=?, antiguedad=?, puesto=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id=?";

    public List<Empleado> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

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
                String NSC = rs.getString("NSC");
                String CURP = rs.getString("CURP");
                int antiguedad = rs.getInt("antiguedad");
                String puesto = rs.getString("puesto");

                empleado = new Empleado(id, nombre, apellidop, apellidom, email, telefono, fecha, RFC, NSC, CURP, antiguedad, puesto);
                empleados.add(empleado);
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
        return empleados;
    }

    public int insertar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, empleado.getId());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellidop());
            stmt.setString(4, empleado.getApellidom());
            stmt.setString(5, empleado.getEmail());
            stmt.setString(6, empleado.getTelefono());
            stmt.setString(7, empleado.getFecha());
            stmt.setInt(8, empleado.getEdad());
            stmt.setString(9, empleado.getRFC());
            stmt.setString(10, empleado.getNSC());
            stmt.setString(11, empleado.getCURP());
            stmt.setInt(12, empleado.getAntiguedad());
            stmt.setString(13, empleado.getPuesto());

            rows = stmt.executeUpdate();
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

    public int actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellidop());
            stmt.setString(3, empleado.getApellidom());
            stmt.setString(4, empleado.getEmail());
            stmt.setString(5, empleado.getTelefono());
            stmt.setString(6, empleado.getFecha());
            stmt.setInt(7, empleado.getEdad());
            stmt.setString(8, empleado.getRFC());
            stmt.setString(9, empleado.getNSC());
            stmt.setString(10, empleado.getCURP());
            stmt.setInt(11, empleado.getAntiguedad());
            stmt.setString(12, empleado.getPuesto());
            stmt.setInt(13, empleado.getId());

            rows = stmt.executeUpdate();
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

    public int eliminar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getId());

            rows = stmt.executeUpdate();
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
