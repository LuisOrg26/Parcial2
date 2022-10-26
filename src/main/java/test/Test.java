package test;
import domain.Proveedor;
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
                    System.out.println("Ingrese el nombre");//Hecho
                    String nombre = validacion(scanner.next());
                    System.out.println("Ingrese el apellido paterno");//Hecho
                    String apellidoPaterno = validacion(scanner.next());
                    System.out.println("Ingrese el apellido materno");//Hecho
                    String apellidoMaterno = validacion(scanner.next());
                    System.out.println("Ingrese el correo");//Hecho
                    String correo = validacioncorreo(scanner.next());
                    System.out.println("Ingrese el telefono");//Hecho
                    String telefono = validaciontelefono(scanner.next());
                    System.out.println("Ingrese la fecha de nacimiento");//Hecho
                    System.out.println("Ejemplo: 1999-12-31");
                    String fechaNacimiento = validacionfecha(scanner.next());
                    System.out.println("Ingrese el RFC");//Hecho
                    String RFC = validacionRFC(scanner.next());
                    System.out.println("Ingrese el dia de entrega");//Hecho
                    System.out.println("Ejemplo: Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo");
                    String diaVisita = validacionentrega(scanner.next());
                    System.out.println("Ingrese el limite de credito");//Hecho
                    double limiteCredito = 0;
                    while(true) {
                        try {
                            limiteCredito = validaciondouble(scanner.nextDouble());
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un numero valido");
                            continue;
                        }
                    }
                    System.out.println("Ingrese el tipo de proveedor");//Hecho
                    String tipoProveedor = validacion(scanner.next());

                    Proveedor nuevoProveedor = new Proveedor(nombre, apellidoPaterno, apellidoMaterno, correo, telefono, fechaNacimiento, RFC, diaVisita, limiteCredito, tipoProveedor);
                    ProveedorDao proveedorDao = new ProveedorDao();
                    proveedorDao.insertar(nuevoProveedor);
                    break;

                case 2:
                    System.out.println("Actualizar");
                    System.out.println("Ingrese el id del proveedor");
                    int id = scanner.nextInt();
                    System.out.println("Ingrese el nombre");//Hecho
                    String nombre1 = validacion(scanner.next());
                    System.out.println("Ingrese el apellido paterno");//Hecho
                    String apellidoPaterno1 = validacion(scanner.next());
                    System.out.println("Ingrese el apellido materno");//Hecho
                    String apellidoMaterno1 = validacion(scanner.next());
                    System.out.println("Ingrese el correo");//Hecho
                    String correo1 = validacioncorreo(scanner.next());
                    System.out.println("Ingrese el telefono");//Hecho
                    String telefono1 = validaciontelefono(scanner.next());
                    System.out.println("Ingrese la fecha de nacimiento");//Hecho
                    System.out.println("Ejemplo: 1999-12-31");
                    String fechaNacimiento1 = validacionfecha(scanner.next());
                    System.out.println("Ingrese el RFC");//Hecho
                    String RFC1 = validacionRFC(scanner.next());
                    System.out.println("Ingrese el dia de entrega");//Hecho
                    System.out.println("Ejemplo: Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo");
                    String diaVisita1 = validacionentrega(scanner.next());
                    System.out.println("Ingrese el limite de credito");//Hecho
                    double limiteCredito1 = 0;
                    while(true) {
                        try {
                            limiteCredito1 = validaciondouble(scanner.nextDouble());
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un numero valido");
                            continue;
                        }
                    }
                    System.out.println("Ingrese el tipo de proveedor");//Hecho
                    String tipoProveedor1 = validacion(scanner.next());

                    Proveedor proveedor = new Proveedor(nombre1, apellidoPaterno1, apellidoMaterno1, correo1, telefono1, fechaNacimiento1, RFC1, diaVisita1, limiteCredito1, tipoProveedor1);
                    ProveedorDao proveedorDao1 = new ProveedorDao();
                    proveedorDao1.actualizar(proveedor);

                    break;
                    case 3:
                    System.out.println("Eliminar");
                    System.out.println("Ingrese el id del proveedor");
                    int id1 = scanner.nextInt();
                    Proveedor proveedor1 = new Proveedor(id1);
                    ProveedorDao proveedorDao2 = new ProveedorDao();
                    proveedorDao2.eliminar(proveedor1);
                    break;
                case 4:
                    System.out.println("Listar");
                    ProveedorDao proveedorDao3 = new ProveedorDao();
                    List<Proveedor> proveedores = proveedorDao3.seleccionar();
                    proveedores.forEach(proveedor2 -> {
                        System.out.println(proveedor2);
                    });

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

    private static String validacion(String dato){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (dato.isEmpty()) {
                System.out.println("El dato no puede estar vacio");
                System.out.println("Ingrese el dato nuevamente");
                dato = scanner.next();
            }else if(dato.matches("[a-zA-Z]*")) {
                return dato;
            } else if(dato.matches("[a-zA-Z0-9]*")){
                    System.out.println("El dato no puede tener numeros");
                    System.out.println("Ingrese el dato nuevamente");
                    dato = scanner.next();

            }else if(!dato.matches("[a-zA-Z]*")){
                System.out.println("El dato no puede tener caracteres especiales");
                System.out.println("Ingrese el dato nuevamente");
                dato = scanner.next();

            }
        }

    }

    private static double validaciondouble(double dato){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (dato == 0) {
                System.out.println("El dato no puede ser 0");
                System.out.println("Ingrese el dato nuevamente");
                dato = scanner.nextDouble();
            }else if(dato < 0){
                System.out.println("El dato no puede ser negativo");
                System.out.println("Ingrese el dato nuevamente");
                dato = scanner.nextDouble();

            } else if(dato > 0){
                return dato;
            }

        }
    }

    private static String validacionentrega(String dato){
        while(true) {
            switch (dato) {
                case "Lunes": return dato;
                case "Martes": return dato;
                case "Miercoles": return dato;
                case "Jueves": return dato;
                case "Viernes": return dato;
                case "Sabado": return dato;
                case "Domingo": return dato;
                default:
                    System.out.println("El dato no es valido");
                    System.out.println("Ingrese el dato nuevamente");
                    Scanner scanner = new Scanner(System.in);
                    dato = scanner.next();
                    break;
            }
        }
    }

    private static String validaciontipo(String dato){
        while(true) {
            if (dato == "Fisica" || dato == "Moral") {
                return dato;
            }else{
                System.out.println("Ingrese un tipo valido de persona");
                System.out.println("Ejemplo: Fisica");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }

    private static String validaciontelefono(String dato){
        while(true) {
            if (dato.matches("[0-9]{10}")) {
                return dato;
            }else{
                System.out.println("Ingrese un numero de telefono valido de 10 caracteres");
                System.out.println("Ejemplo: 1234567890");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }

    private static String validacioncorreo(String dato){
        while(true) {
            if (dato.matches("^[a-z0-9]*+@[a-z]*+.[a-z]{2,3}$" )) {
                return dato;
            }else{
                System.out.println("Ingrese un correo valido");
                System.out.println("Ejemplo: luisjaorg26@gmail.com");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }

    private static String validacionfecha(String dato){
        while(true) {
            if (dato.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}" )) {
                return dato;
            }else{
                System.out.println("Ingrese una fecha valida");
                System.out.println("Ejemplo: 1999-12-31");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }

    private static String validacionRFC(String dato){
        while(true) {
            if (dato.matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}") || dato.matches("[A-Z]{3}[0-9]{6}[A-Z0-9]{3}")) {
                return dato;
            }else{
                System.out.println("Ingrese un RFC valido");
                System.out.println("Ejemplo: AAAA000000AAA o AAA000000AAA");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }

    private static String validacionCURP(String dato){
        while(true) {
            if (dato.matches("[A-Z]{4}[0-9]{6}[A-Z]{6}[0-9]{2}")) {
                return dato;
            }else{
                System.out.println("Ingrese un CURP valido");
                System.out.println("Ejemplo: AAAA000000AAAAAA00");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }

    private static String validacionNSS(String dato){
        while(true) {
            if (dato.matches("[0-9]{11}")) {
                return dato;
            }else{
                System.out.println("Ingrese un numero de telefono valido de 10 caracteres");
                System.out.println("Ejemplo: 1234567890");
                Scanner scanner = new Scanner(System.in);
                dato = scanner.next();
            }
        }
    }



}

