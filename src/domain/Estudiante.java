package domain;

public class Estudiante implements Comparable<Estudiante> {
    private int nro;
    private String nombre;
    private String apellido;

    public Estudiante(int nro, String nombre, String apellido) {
        this.nro = nro;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

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

    @Override
    public int compareTo(Estudiante o) {
        return nro - o.getNro();
    }

    @Override
    public String toString() {
        return "[" + nro + ", " + nombre + " " + apellido + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
