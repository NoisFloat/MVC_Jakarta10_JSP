package Beans;

public class Genero {
    private int idGenero;
    private String nombreGenero;
    private String descripcion;

    public Genero() {
        this.idGenero = 0;
        this.nombreGenero = "";
        this.descripcion = "";
    }
    public Genero(int idGenero, String nombreGenero, String descripcion) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.descripcion = descripcion;
    }
    public Genero(String nombreGenero){
        this.nombreGenero = nombreGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
