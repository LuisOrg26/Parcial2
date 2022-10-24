package domain;

public class Cliente extends Persona{
    private int DiasCredito;
    private String Metodo;
    private String Tipo;

    public Cliente() {
    }
    //Eliminar
    public Cliente(int id){
        super(id);
    }

    //Crear y Actualizar
    public Cliente(String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC, int DiasCredito, String Metodo, String Tipo) {
        super(nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.DiasCredito = DiasCredito;
        this.Metodo = Metodo;
        this.Tipo = Tipo;
    }

    //Seleccionar
    public Cliente(int DiasCredito, String Metodo, String Tipo, int id, String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC) {
        super(id, nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.DiasCredito = DiasCredito;
        this.Metodo = Metodo;
        this.Tipo = Tipo;
    }

    public int getDiasCredito() {
        return DiasCredito;
    }

    public void setDiasCredito(int DiasCredito) {
        this.DiasCredito = DiasCredito;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String Metodo) {
        this.Metodo = Metodo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append(super.toString());
        sb.append("DiasCredito=").append(DiasCredito);
        sb.append(", Metodo='").append(Metodo).append('\'');
        sb.append(", Tipo='").append(Tipo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
