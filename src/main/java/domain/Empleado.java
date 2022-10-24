package domain;

public class Empleado extends Persona{
    private String NSC;
    private String CURP;
    private int antiguedad;
    private String puesto;

    public Empleado() {
    }
    //Eliminar
    public Empleado(int id){
        super(id);
    }

    //Crear y Actualizar
    public Empleado(String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC, String NSC, String CURP, int antiguedad, String puesto) {
        super(nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.NSC = NSC;
        this.CURP = CURP;
        this.antiguedad = antiguedad;
        this.puesto = puesto;
    }

    //Seleccionar
    public Empleado(String NSC, String CURP, int antiguedad, String puesto, int id, String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC) {
        super(id, nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.NSC = NSC;
        this.CURP = CURP;
        this.antiguedad = antiguedad;
        this.puesto = puesto;
    }

    public String getNSC() {
        return NSC;
    }

    public void setNSC(String NSC) {
        this.NSC = NSC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append(super.toString());
        sb.append("NSC='").append(NSC).append('\'');
        sb.append(", CURP='").append(CURP).append('\'');
        sb.append(", antiguedad=").append(antiguedad);
        sb.append(", puesto='").append(puesto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
