package domain;

public class Proveedor extends Persona{
    private String DiasEntrega;
    private double CreditoD;
    private String Categoria;

    public Proveedor() {
    }

    //Eliminar
    public Proveedor(int id){
        super(id);
    }

    //Crear y Actualizar
    public Proveedor(String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC, String DiasEntrega, double CreditoD, String Categoria) {
        super(nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.DiasEntrega = DiasEntrega;
        this.CreditoD = CreditoD;
        this.Categoria = Categoria;
    }

    public Proveedor(int id,String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, String RFC, String DiasEntrega, double CreditoD, String Categoria) {
        super(id,nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.DiasEntrega = DiasEntrega;
        this.CreditoD = CreditoD;
        this.Categoria = Categoria;
    }

    //Seleccionar
    public Proveedor(int id, String nombre, String apellidop, String apellidom, String email, String telefono, String fecha, int edad, String RFC, String DiasEntrega, double CreditoD, String Categoria) {
        super(id, nombre, apellidop, apellidom, email, telefono, fecha, RFC);
        this.DiasEntrega = DiasEntrega;
        this.CreditoD = CreditoD;
        this.Categoria = Categoria;
    }

    public String getDiasEntrega() {
        return DiasEntrega;
    }

    public void setDiasEntrega(String diasEntrega) {
        DiasEntrega = diasEntrega;
    }

    public double getCreditoD() {
        return CreditoD;
    }

    public void setCreditoD(double creditoD) {
        CreditoD = creditoD;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proveedor{");
        sb.append(super.toString());
        sb.append("DiasEntrega='").append(DiasEntrega).append('\'');
        sb.append(", CreditoD=").append(CreditoD);
        sb.append(", Categoria='").append(Categoria).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
