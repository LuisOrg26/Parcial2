package test;
import Data.ProveedorDao;
import domain.Proveedor;
import java.util.List;
public class testProveedorDAO {

    public static void main(String[] args) {
        ProveedorDao proveedorDao = new ProveedorDao();
        Proveedor nuevoProveedor = new Proveedor("Javier", "Carrillo", "Corona", "hugo@gmail.com", "1234567890", "2003-02-26", "HCCO990101", "Lunes", 200.8, "Fisica");
        proveedorDao.insertar(nuevoProveedor);
    }
}
