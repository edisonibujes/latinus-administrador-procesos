/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
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

@Entity
@Table(name = "solicitud", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")})
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private Proceso idProceso;

    @Column(name = "numero_tramite")
    private Integer numeroTramite;

    @JoinColumn(name = "id_formulario", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario idFormulario;

    @JoinColumn(name = "estado_solicitud", referencedColumnName = "id_catalogo")
    @ManyToOne
    private Catalogo estadoSolicitud;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
   
    @JoinColumn(name = "usuario_modificacion", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioModificacion;
    
    @Column(name = "rol_tarea")
    private String rolTarea;
    
    @Column(name = "usuario_tarea")
    private String usuarioTarea;
    
    public Solicitud() {

    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(Integer numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public Formulario getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Formulario idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Usuario getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Usuario usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Catalogo getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Catalogo estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getRolTarea() {
        return rolTarea;
    }

    public void setRolTarea(String rolTarea) {
        this.rolTarea = rolTarea;
    }

    public String getUsuarioTarea() {
        return usuarioTarea;
    }

    public void setUsuarioTarea(String usuarioTarea) {
        this.usuarioTarea = usuarioTarea;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", idProceso=" + idProceso + ", numeroTramite=" + numeroTramite + ", idFormulario=" + idFormulario + ", estadoSolicitud=" + estadoSolicitud + ", usuarioCreacion=" + usuarioCreacion + ", usuarioModificacion=" + usuarioModificacion + '}';
    }

}
