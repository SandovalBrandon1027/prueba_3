import java.io.Serializable;

public class datos implements Serializable {
    String nombre;
    String apellido;

    String cedula;
    String codigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public datos(String nombre, String apellido, String cedula, String codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.codigo = codigo;
    }
    public String toString(){
        return "Nombre: "+nombre+"Apellido: "+apellido+"Cedula: "+cedula+"Codigo: "+codigo;
    }
}



