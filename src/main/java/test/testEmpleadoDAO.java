package test;
import Data.EmpleadoDao;
import domain.Empleado;
import java.util.List;

public class testEmpleadoDAO {
    public static void main(String[] args) {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado nuevoEmpleado = new Empleado("Javier", "Carrillo", "Corona", "lulu@gmail.com", "1234567890", "1999-01-01", "HCCO990101", "1234567890", "HCCO990101", 5, "Gerente");
        empleadoDao.insertar(nuevoEmpleado);
    }
}

