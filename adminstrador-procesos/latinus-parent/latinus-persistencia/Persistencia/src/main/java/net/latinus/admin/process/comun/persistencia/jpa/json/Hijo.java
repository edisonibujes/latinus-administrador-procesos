
package net.latinus.admin.process.comun.persistencia.jpa.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Hijo {

    @SerializedName("idFormulario")
    @Expose
    private Integer idFormulario;

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    @Override
    public String toString() {
        return "Hijo{" + "idFormulario=" + idFormulario + '}';
    }
    
}
