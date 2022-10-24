package domain;
import java.time.LocalDate;
import java.time.Period;
public class Persona {
    private int id;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String email;
    private String telefono;
    private String fecha;
    private int edad;
    private String RFC;

    public Persona() {
    }
    //Eliminar
    public Persona(int id){
        this.id = id;
    }
    //Crear y Actualizar
    public Persona(String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC) {
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.email = email;
        this.telefono = telefono;
        this.fecha = fecha;
        this.edad = age();
        this.RFC = RFC;
    }
    //Seleccionar
    public Persona(int id,String nombre, String apellidop, String apellidom,String email,String telefono,String fecha,String RFC) {

        this.id = id;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.email = email;
        this.telefono = telefono;
        this.fecha = fecha;
        this.edad = age();
        this.RFC = RFC;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getedad() {
        return edad;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int age() {
        LocalDate date = LocalDate.parse(this.fecha);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(date, now);
        return diff.getYears();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellidop='").append(apellidop).append('\'');
        sb.append(", apellidom='").append(apellidom).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", fecha='").append(fecha).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", RFC='").append(RFC).append('\'');
        return sb.toString();
    }
}



