package net.latinus.arcom.comun.intalio.wrapper.dto;

import java.io.Serializable;

/**
 *
 * @author Latinus
 */
public class BaseDto implements Serializable {

    private String nombre;

    public BaseDto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
