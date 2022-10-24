package test;
import domain.*;
public class testPersona {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", "Perez", "Garcia", " lulu@gmail.com", "1234567890", "1987-01-01", "PGRJ900101", "1234567890", "PGRJ900101", 5, "Gerente");
        Cliente cliente1 = new Cliente("Luis","Origel","Garcia","lulu@gmail.com","1234567890","1990-01-01","PGRJ900101", 30, "Efectivo", "Mayorista");
        Proveedor proveedor1 = new Proveedor("Lunes",3,"Minorista",2,"Luis","Origel","Gonzalez", "lulu", "4622224662", "1997-01-01", "PGRJ900101");
        System.out.println(empleado1.toString());
        System.out.println(cliente1.toString());
        System.out.println(proveedor1.toString());

    }
}
