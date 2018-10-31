package net.latinus.usuario.integracion.dto;

public class Rol {
    String nombre;
    String id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rol{" + "nombre=" + nombre + ", id=" + id + '}';
    }

}
