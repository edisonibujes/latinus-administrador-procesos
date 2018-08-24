
package net.latinus.admin.process.comun.persistencia.jpa.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SolicitudAtentidad {

    @SerializedName("idCatalogo")
    @Expose
    private Integer idCatalogo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("nemonico")
    @Expose
    private String nemonico;

    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNemonico() {
        return nemonico;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("idCatalogo", idCatalogo).append("nombre", nombre).append("descripcion", descripcion).append("nemonico", nemonico).toString();
    }

}
