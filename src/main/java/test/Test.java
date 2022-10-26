package test;
import Data.ClienteDao;
import domain.Cliente;
import domain.Empleado;
import domain.Proveedor;
import Data.EmpleadoDao;
import Data.ProveedorDao;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la base de datos");
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Ingrese el numero de la tabla que desea consultar");
            System.out.println("1. Proveedor");
            System.out.println("2. Cliente");
            System.out.println("3. Empleado");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    proveedor();
                    break;
                case 2:
                    cliente();
                    break;
                case 3:
                    empleado();
                    break;
                case 4:
                    System.out.println("Gracias por usar la base de datos");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }


        }


    }

    private static void cliente() {
    }

    private static void empleado() {
    }

    private static void proveedor() {
        System.out.println("Bienvenido a la seccion de proveedores");
        int opcionc = 0;
        while (opcionc != 5) {
            System.out.println("Elija una opcion");
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Listar");
            System.out.println("5. Salir");
            Scanner scanner = new Scanner(System.in);
            opcionc = scanner.nextInt();
            switch (opcionc) {
                case 1:
                    System.out.println("Insertar");
                    System.out.println("Ingrese el nombre");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el apellido paterno");
                    String apellidoPaterno = scanner.next();
                    System.out.println("Ingrese el apellido materno");
                    String apellidoMaterno = scanner.next();
                    System.out.println("Ingrese el correo");
                    String correo = scanner.next();
                    System.out.println("Ingrese el telefono");
                    String telefono = scanner.next();
                    System.out.println("Ingrese la fecha de nacimiento");
                    String fechaNacimiento = scanner.next();
                    System.out.println("Ingrese el RFC");
                    String RFC = scanner.next();
                    System.out.println("Ingrese el dia de entrega");
                    String diaVisita = scanner.next();
                    System.out.println("Ingrese el limite de credito");
                    double limiteCredito = scanner.nextDouble();
                    System.out.println("Ingrese el tipo de persona");
                    String tipoPersona = scanner.next();
                    Proveedor nuevoProveedor = new Proveedor(nombre, apellidoPaterno, apellidoMaterno, correo, telefono, fechaNacimiento, RFC, diaVisita, limiteCredito, tipoPersona);
                    ProveedorDao proveedorDao = new ProveedorDao();
                    proveedorDao.insertar(nuevoProveedor);
                    break;
                case 2:
                    System.out.println("Actualizar");
                    System.out.println("Ingrese el id del proveedor");
                    int id = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Gracias por usar la seccion de proveedores");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }



    }
}

