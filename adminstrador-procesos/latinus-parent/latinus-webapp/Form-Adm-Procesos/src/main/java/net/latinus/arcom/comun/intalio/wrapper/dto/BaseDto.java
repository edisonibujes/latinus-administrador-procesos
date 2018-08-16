package net.latinus.arcom.comun.intalio.wrapper.dto;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import net.latinus.arcom.comun.persistencia.jpa.dao.CatalogoDAO;
import net.latinus.arcom.comun.persistencia.jpa.dao.CatalogoDetalleDAO;
import net.latinus.arcom.comun.persistencia.jpa.entidades.AsesorProcesoMinero;
import net.latinus.arcom.comun.persistencia.jpa.entidades.CatalogoDetalle;
import net.latinus.arcom.comun.persistencia.jpa.entidades.Catalogo;

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
