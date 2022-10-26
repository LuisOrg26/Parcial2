package test;
import Data.ClienteDao;
import domain.Cliente;
import java.util.List;
public class testClienteDAO {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
    Cliente nuevoCliente = new Cliente("Javier","Carrillo","Corona","hugo@mail.com","1234567890","1999-01-01","HCCO990101",30,"Efectivo","Fisica");
    clienteDao.insertar(nuevoCliente);


    }
}
