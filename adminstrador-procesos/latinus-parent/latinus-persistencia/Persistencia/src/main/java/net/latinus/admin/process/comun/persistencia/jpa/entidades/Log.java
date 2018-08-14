/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PERSONAL1
 */
@Entity
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "Log.findByDatosGrilla", query = "SELECT l FROM Log l WHERE l.datosGrilla = :datosGrilla"),
    @NamedQuery(name = "Log.findByDatosVariables", query = "SELECT l FROM Log l WHERE l.datosVariables = :datosVariables"),
    @NamedQuery(name = "Log.findByFechaAtencion", query = "SELECT l FROM Log l WHERE l.fechaAtencion = :fechaAtencion")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Long idLog;
    @Column(name = "datos_grilla")
    private String datosGrilla;
    @Column(name = "datos_variables")
    private String datosVariables;
    @Column(name = "fecha_atencion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAtencion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public Log() {
    }

    public Log(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getDatosGrilla() {
        return datosGrilla;
    }

    public void setDatosGrilla(String datosGrilla) {
        this.datosGrilla = datosGrilla;
    }

    public String getDatosVariables() {
        return datosVariables;
    }

    public void setDatosVariables(String datosVariables) {
        this.datosVariables = datosVariables;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Log{" + "idLog=" + idLog + ", datosGrilla=" + datosGrilla + ", datosVariables=" + datosVariables + ", fechaAtencion=" + fechaAtencion + ", idUsuario=" + idUsuario + '}';
    }

}
