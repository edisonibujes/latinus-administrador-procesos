
package net.latinus.admin.process.comun.persistencia.jpa.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Condicionale {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("valor")
    @Expose
    private Integer valor;
    @SerializedName("operacion")
    @Expose
    private String operacion;
    @SerializedName("idFormulario")
    @Expose
    private Integer idFormulario;
    @SerializedName("estadoSolicitud")
    @Expose
    private String estadoSolicitud;
    @SerializedName("rolTarea")
    @Expose
    private String rolTarea;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getRolTarea() {
        return rolTarea;
    }

    public void setRolTarea(String rolTarea) {
        this.rolTarea = rolTarea;
    }

    @Override
    public String toString() {
        return "Condicionale{" + "nombre=" + nombre + ", valor=" + valor + ", operacion=" + operacion + ", idFormulario=" + idFormulario + ", estadoSolicitud=" + estadoSolicitud + '}';
    }

}
