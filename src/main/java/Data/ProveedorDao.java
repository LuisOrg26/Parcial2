package Data;
import java.util.List;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import static Data.Conexion.*;

public class ProveedorDao {

    private static final String SQL_SELECT = "SELECT id, nombre, apellidop, apellidom, email, telefono, fecha, RFC, DiasEntrega, CreditoD, Categoria FROM proveedor";
    private static final String SQL_INSERT = "INSERT INTO proveedor(nombre, apellidop, apellidom, email, telefono, fecha, RFC, DiasEntrega, CreditoD, Categoria) VALUES(?,?,?,?,?,?,?,?,?,?)";
}
