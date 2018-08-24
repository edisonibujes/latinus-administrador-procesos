
package net.latinus.admin.process.comun.persistencia.jpa.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Union {

    @SerializedName("formulariosUnidos")
    @Expose
    private List<Integer> formulariosUnidos = new ArrayList();

    @SerializedName("idFormularioSiguiente")
    @Expose
    private Integer idFormularioSiguiente;

    public Integer getIdFormularioSiguiente() {
        return idFormularioSiguiente;
    }

    public void setIdFormularioSiguiente(Integer idFormularioSiguiente) {
        this.idFormularioSiguiente = idFormularioSiguiente;
    }
       
    public List<Integer> getFormulariosUnidos() {
        return formulariosUnidos;
    }

    public void setFormulariosUnidos(List<Integer> formulariosUnidos) {
        this.formulariosUnidos = formulariosUnidos;
    }

    @Override
    public String toString() {
        return "Union{" + "formulariosUnidos=" + formulariosUnidos + ", idFormularioSiguiente=" + idFormularioSiguiente + '}';
    }
    
}
