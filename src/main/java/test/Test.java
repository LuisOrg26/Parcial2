package test;
import Data.ClienteDao;
import Data.EmpleadoDao;
import domain.Cliente;
import domain.Empleado;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la base datos de clientes");
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Ingrese el numero de la accion que desea realizar");
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Insertar");
                    System.out.println("Ingrese el nombre");
                    String nombre = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido paterno");
                    String apellidoPaterno = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido materno");
                    String apellidoMaterno = validacion(scanner.next());
                    System.out.println("/nIngrese el email");
                    System.out.println("Por ejemplo: programacionOB@gamil.com");
                    String email = validacioncorreo(scanner.next());
                    System.out.println("/nIngrese el telefono");
                    String telefono = validaciontelefono(scanner.next());
                    System.out.println("/nIngrese la fecha de nacimiento");
                    System.out.println("AAAA-MM-DD");
                    String fecha = validacionfecha(scanner.next());
                    System.out.println("/nIngrese el RFC");
                    String RFC = validacionRFC(scanner.next());
                    System.out.println("/nDias de credito");
                    int diasCredito = validacionint(scanner.nextInt());
                    System.out.println("/nMetodo de pago");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Cheque");
                    String metodopago = "";
                    while(true){
                        try {
                            int metodo = validacionint(scanner.nextInt());
                            if (metodo == 1) {
                                metodopago = "Efectivo";
                                break;
                            } else if (metodo == 2) {
                                metodopago = "Tarjeta";
                                break;
                            } else if (metodo == 3) {
                                metodopago = "Cheque";
                                break;
                            } else {
                                System.out.println("Elige un numero valido");
                            }
                        } catch (Exception e) {
                            System.out.println("Ingresa un entero");
                        }
                    }
                    String persona = "";
                    if(RFC.length() == 13){
                        persona = "Fisica";
                    }else if(RFC.length() == 12){
                        persona = "Moral";
                    }

                    Cliente nuevoCliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, email, telefono, fecha, RFC, diasCredito, metodopago, persona);
                    ClienteDao clienteDao = new ClienteDao();
                    clienteDao.insertar(nuevoCliente);
                    System.out.println("Cliente agregrado con exito");
                    break;
                case 2:
                    System.out.println("Actualizar");
                    System.out.println("Ingrese el id del cliente");
                    //int id = validacionint(scanner.nextInt());
                    int id = 0;
                    while(true){
                        try {
                            id = validacionint(validacionidcliente(scanner.nextInt()));
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingresa un entero");
                        }
                    }
                    System.out.println("/nIngrese el nombre");
                    String nombre1 = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido paterno");
                    String apellidoPaterno1 = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido materno");
                    String apellidoMaterno1 = validacion(scanner.next());
                    System.out.println("/nIngrese el email");
                    String email1 = validacioncorreo(scanner.next());
                    System.out.println("/nIngrese el telefono");
                    String telefono1 = validaciontelefono(scanner.next());
                    System.out.println("/nIngrese la fecha de nacimiento");
                    String fecha1 = validacionfecha(scanner.next());
                    System.out.println("/nIngrese el RFC");
                    String RFC1 = validacionRFC(scanner.next());
                    System.out.println("/nDias de credito");
                    int diasCredito1 = validacionint(scanner.nextInt());
                    System.out.println("/nMetodo de pago");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Cheque");
                    String metodopago1 = "";
                    while(true){
                        try {
                            int metodo = validacionint(scanner.nextInt());
                            if (metodo == 1) {
                                metodopago1 = "Efectivo";
                                break;
                            } else if (metodo == 2) {
                                metodopago1 = "Tarjeta";
                                break;
                            } else if (metodo == 3) {
                                metodopago1 = "Cheque";
                                break;
                            } else {
                                System.out.println("Elige un numero valido");
                            }
                        } catch (Exception e) {
                            System.out.println("Ingresa un entero");
                        }
                    }
                    String persona1 = "";
                    if(RFC1.length() == 13){
                        persona1 = "Fisica";
                    }else if(RFC1.length() == 12){
                        persona1 = "Moral";
                    }

                    Cliente nuevoCliente1 = new Cliente(id, nombre1, apellidoPaterno1, apellidoMaterno1, email1, telefono1, fecha1, RFC1, diasCredito1, metodopago1, persona1);
                    ClienteDao clienteDao1 = new ClienteDao();
                    clienteDao1.actualizar(nuevoCliente1);

                    System.out.println("Cliente actualizado con exito ");
                    break;
                case 3:
                    System.out.println("Eliminar");
                    System.out.println("Ingrese el id del cliente que desea eliminar");
                    int id1 = 0;
                    while(true){
                        try {
                            id1 = validacionint(validacionidcliente(scanner.nextInt()));
                            ClienteDao clienteDao8 = new ClienteDao();
                            Cliente eliminarCliente = new Cliente(id1);
                            clienteDao8.eliminar(eliminarCliente);
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingresa un entero");
                        }
                    }


                    System.out.println("/nCliente eliminado con exito");
                    break;
                case 4:
                    System.out.println("Consultar");
                    ClienteDao clienteDao3 = new ClienteDao();
                    List<Cliente> clientes = clienteDao3.seleccionar();
                    clientes.forEach(cliente -> {
                        System.out.println(cliente + "\n");
                    });
                    break;
                case 5:
                    System.out.println("Saliendo de Cliente");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    private static void empleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la base de datos de empleados");
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Ingrese el numero de la accion que desea realizar");
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Insertar");
                    System.out.println("Ingrese el nombre");
                    String nombre = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido paterno");
                    String apellidoPaterno = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido materno");
                    String apellidoMaterno = validacion(scanner.next());
                    System.out.println("/nIngrese el email");
                    System.out.println("Ejemplo: ProgramacionOB2@gmail.com");
                    String email = validacioncorreo(scanner.next());
                    System.out.println("/nIngrese el telefono");
                    String telefono = validaciontelefono(scanner.next());
                    System.out.println("/nIngrese la fecha de nacimiento");
                    System.out.println("Ejemplo: AAAA-MM-DD");
                    String fecha = validacionfecha(scanner.next());
                    System.out.println("/nIngrese el RFC");
                    String RFC = validacionRFC(scanner.next());
                    System.out.println("/nIngrese el numero de seguro social");
                    String NSS = validacionNSS(scanner.next());
                    System.out.println("/nIngrese el CURP");
                    String CURP = validacionCURP(scanner.next());
                    System.out.println("/nIngrese la antiguedad");
                    int antiguedad = 0;
                    while (true) {
                        try {
                            antiguedad = validacionint(scanner.nextInt());
                            break;
                        } catch (Exception e) {
                            System.out.println("In/ngrese un entero");
                        }
                    }
                    System.out.println("/nIngrese el puesto");
                    String puesto = validacion(scanner.next());

                    Empleado nuevoEmpleado = new Empleado(nombre, apellidoPaterno, apellidoMaterno, email, telefono, fecha, RFC, NSS, CURP, antiguedad, puesto);
                    EmpleadoDao empleadoDao = new EmpleadoDao();
                    empleadoDao.insertar(nuevoEmpleado);
                    System.out.println("Empleado agregado con exito");
                    break;
                case 2:
                    System.out.println("Actualizar");
                    System.out.println("/nIngrese el id del empleado que desea actualizar");
                    //int id1 = validacionint(scanner.nextInt());
                    int id1 = 0;
                    while (true) {
                        try {
                            id1 = validacionint(validacionidempleado(scanner.nextInt()));
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un entero");
                        }
                    }
                    System.out.println("/nIngrese el nombre");
                    String nombre1 = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido paterno");
                    String apellidoPaterno1 = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido materno");
                    String apellidoMaterno1 = validacion(scanner.next());
                    System.out.println("/nIngrese el email");
                    System.out.println("Ejemplo: programacionOB2@gmai.com");
                    String email1 = validacioncorreo(scanner.next());
                    System.out.println("/nIngrese el telefono");
                    String telefono1 = validaciontelefono(scanner.next());
                    System.out.println("/nIngrese la fecha de nacimiento");
                    System.out.println("Ejemplo: AAAA-MM-DD");
                    String fecha1 = validacionfecha(scanner.next());
                    System.out.println("/nIngrese el RFC");
                    String RFC1 = validacionRFC(scanner.next());
                    System.out.println("/nIngrese el numero de seguro social");
                    String NSS1 = validacionNSS(scanner.next());
                    System.out.println("/nIngrese el CURP");
                    String CURP1 = validacionCURP(scanner.next());
                    System.out.println("/nIngrese la antiguedad");
                    int antiguedad1 = 0;
                    while (true) {
                        try {
                            antiguedad1 = validacionint(scanner.nextInt());
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un entero");
                        }
                    }
                    System.out.println("/nIngrese el puesto");
                    String puesto1 = validacion(scanner.next());

                    EmpleadoDao empleadoDao7 = new EmpleadoDao();
                    Empleado actualizarEmpleado = new Empleado(id1, nombre1, apellidoPaterno1, apellidoMaterno1, email1, telefono1, fecha1, RFC1, NSS1, CURP1, antiguedad1, puesto1);
                    empleadoDao7.actualizar(actualizarEmpleado);
                    System.out.println("Empleado actualizado con exito");
                    break;
                case 3:
                    System.out.println("Eliminar");
                    System.out.println("Ingrese el id del empleado que desea eliminar");
                    //nt id = validacionint(scanner.nextInt());
                    int id = 0;
                    while (true) {
                        try {
                            id = validacionint(validacionidempleado(scanner.nextInt()));
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un entero");
                        }
                    }
                    EmpleadoDao empleadoDao1 = new EmpleadoDao();
                    Empleado eliminarEmpleado = new Empleado(id);
                    empleadoDao1.eliminar(eliminarEmpleado);
                    System.out.println("Empleado eliminado con exito");
                    break;
                case 4:
                    System.out.println("Consultar");
                    EmpleadoDao empleadoDao3 = new EmpleadoDao();
                    List<Empleado> empleados = empleadoDao3.seleccionar();
                    empleados.forEach(empleado -> {
                        System.out.println(empleado+ "\n");
                    });
                case 5:
                    System.out.println("Gracias por usar la base de datos de empleados");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    private static void proveedor() {
        System.out.println("Bienvenido a la base de datos de proveedores");
        int opcionc = 0;
        while (opcionc != 5) {
            System.out.println("Elija una opcion");
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            Scanner scanner = new Scanner(System.in);
            opcionc = scanner.nextInt();
            switch (opcionc) {
                case 1:
                    System.out.println("Insertar");
                    System.out.println("/nIngrese el nombre");//Hecho
                    String nombre = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido paterno");//Hecho
                    String apellidoPaterno = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido materno");//Hecho
                    String apellidoMaterno = validacion(scanner.next());
                    System.out.println("/nIngrese el correo");//Hecho
                    System.out.println("Ejemplo: programacionOB2@gmai.com");
                    String correo = validacioncorreo(scanner.next());
                    System.out.println("/nIngrese el telefono");//Hecho
                    String telefono = validaciontelefono(scanner.next());
                    System.out.println("/nIngrese la fecha de nacimiento");//Hecho
                    System.out.println("Ejemplo: AAA-MM-DD");
                    String fechaNacimiento = validacionfecha(scanner.next());
                    System.out.println("/nIngrese el RFC");//Hecho
                    String RFC = validacionRFC(scanner.next());
                    System.out.println("/nIngrese el dia de entrega");//Hecho
                    System.out.println("Ejemplo: Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo");
                    String diaVisita = validacionentrega(scanner.next());
                    System.out.println("/nIngrese el limite de credito");//Hecho
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
                    System.out.println("Proveedor agregado con exito");
                    break;

                case 2:
                    System.out.println("Actualizar");
                    System.out.println("Ingrese el id del proveedor");
                    int id = 0;
                    while (true) {
                        try {
                            id = validacionint(validacionidproveedor(scanner.nextInt()));
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un entero");
                        }
                    }
                    System.out.println("/nIngrese el nombre");//Hecho
                    String nombre1 = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido paterno");//Hecho
                    String apellidoPaterno1 = validacion(scanner.next());
                    System.out.println("/nIngrese el apellido materno");//Hecho
                    String apellidoMaterno1 = validacion(scanner.next());
                    System.out.println("/nIngrese el correo");//Hecho
                    System.out.println("Ejemplo: programacionOB2@gmai.com");
                    String correo1 = validacioncorreo(scanner.next());
                    System.out.println("/nIngrese el telefono");//Hecho
                    String telefono1 = validaciontelefono(scanner.next());
                    System.out.println("/nIngrese la fecha de nacimiento");//Hecho
                    System.out.println("Ejemplo: AAAA-MM-DD");
                    String fechaNacimiento1 = validacionfecha(scanner.next());
                    System.out.println("/nIngrese el RFC");//Hecho
                    String RFC1 = validacionRFC(scanner.next());
                    System.out.println("/nIngrese el dia de entrega");//Hecho
                    System.out.println("Ejemplo: Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo");
                    String diaVisita1 = validacionentrega(scanner.next());
                    System.out.println("/nIngrese el limite de credito");//Hecho
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
                    System.out.println("/nIngrese el tipo de proveedor");//Hecho
                    String tipoProveedor1 = validacion(scanner.next());

                    Proveedor proveedor = new Proveedor(id, nombre1, apellidoPaterno1, apellidoMaterno1, correo1, telefono1, fechaNacimiento1, RFC1, diaVisita1, limiteCredito1, tipoProveedor1);
                    ProveedorDao proveedorDao1 = new ProveedorDao();
                    proveedorDao1.actualizar(proveedor);
                    System.out.println("Proveedor actualizado con exito");
                    break;
                case 3:
                    System.out.println("Eliminar");
                    System.out.println("Ingrese el id del proveedor");
                    int id1 = 0;
                    while(true) {
                        try {
                            id1 = validacionint(validacionidproveedor(scanner.nextInt()));
                            ProveedorDao proveedorDao2 = new ProveedorDao();
                            Proveedor eliminarproveedor = new Proveedor(id1);
                            proveedorDao2.eliminar(eliminarproveedor);
                            System.out.println("Proveedor eliminado con exito \n");
                            break;
                        } catch (Exception e) {
                            System.out.println("Ingrese un numero entero");
                            continue;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Consultar");
                    ProveedorDao proveedorDao3 = new ProveedorDao();
                    List<Proveedor> proveedores = proveedorDao3.seleccionar();
                    proveedores.forEach(proveedor2 -> {
                        System.out.println(proveedor2 + "\n");
                    });

                    break;
                case 5:
                    System.out.println("Gracias por usar la base de datos de proveedores");
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
            if (dato.matches("^([a-z0-9])?(.[a-z0-9])+@[a-z]+.[a-z]{2,3}+.?([a-z]{2,3}$)")) {
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
            if (dato.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
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

    private static int validacionint(int dato){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (dato == 0) {
                System.out.println("El dato no puede ser 0");
                System.out.println("Ingrese el dato nuevamente");
                dato = scanner.nextInt();
            }else if(dato < 0){
                System.out.println("El dato no puede ser negativo");
                System.out.println("Ingrese el dato nuevamente");
                dato = scanner.nextInt();

            } else if(dato > 0){
                return dato;
            }
        }
    }

    private static int validacionidempleado(int dato){
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new EmpleadoDao().seleccionar();
        while(true) {
            for (Empleado empleado : empleados) {
                if (dato == empleado.getId()) {
                    System.out.println("id encontrado");
                    return dato;
                }
            }

            System.out.println("id no encontrado");
            System.out.println("Inserta el id que quieres buscar\n");
            System.out.println("ids disponible: ");
            for (Empleado empleado : empleados) {
                System.out.println("id: " + empleado.getId() + " Nombre: " + empleado.getNombre());
            }
            dato = scanner.nextInt();
        }
    }

    private static int validacionidcliente(int dato){
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ClienteDao().seleccionar();
        while(true) {
            for (Cliente cliente : clientes) {
                if (dato == cliente.getId()) {
                    System.out.println("id encontrado");
                    return dato;
                }
            }

            System.out.println("id no encontrado");
            System.out.println("Inserta el id que quieres buscar\n");
            System.out.println("ids disponible: ");
            for (Cliente cliente : clientes) {
                System.out.println("id: " + cliente.getId() + " Nombre: " + cliente.getNombre());
            }
            dato = scanner.nextInt();
        }
    }

    private static int validacionidproveedor(int dato){
        Scanner scanner = new Scanner(System.in);
        List<Proveedor> proveedores = new ProveedorDao().seleccionar();
        while(true) {
            for (Proveedor proveedor : proveedores) {
                if (dato == proveedor.getId()) {
                    System.out.println("id encontrado");
                    return dato;
                }
            }

            System.out.println("id no encontrado");
            System.out.println("Inserta el id que quieres buscar\n");
            System.out.println("ids disponible: ");
            for (Proveedor proveedor : proveedores) {
                System.out.println("id: " + proveedor.getId() + " Nombre: " + proveedor.getNombre());
            }
            dato = scanner.nextInt();
        }
    }
}

