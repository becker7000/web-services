package mx.com.cst.webapp.jaxws.model;

public class Paciente {

    private String nombre;

    public Paciente(){

    }

    public Paciente(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
