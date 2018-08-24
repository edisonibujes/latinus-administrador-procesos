
package net.latinus.admin.process.comun.persistencia.jpa.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Paralelo {

    @SerializedName("idFormularioSiguiente")
    @Expose
    private Integer idFormularioSiguiente;
    
    @SerializedName("hijosDto")
    @Expose
    private List<Hijo> hijosDto = new ArrayList();

    public List<Hijo> getHijosDto() {
        return hijosDto;
    }

    public void setHijosDto(List<Hijo> hijosDto) {
        this.hijosDto = hijosDto;
    }

    public Integer getIdFormularioSiguiente() {
        return idFormularioSiguiente;
    }

    public void setIdFormularioSiguiente(Integer idFormularioSiguiente) {
        this.idFormularioSiguiente = idFormularioSiguiente;
    }

    @Override
    public String toString() {
        return "Paralelo{" + "idFormularioSiguiente=" + idFormularioSiguiente + ", hijosDto=" + hijosDto + '}';
    }

}
