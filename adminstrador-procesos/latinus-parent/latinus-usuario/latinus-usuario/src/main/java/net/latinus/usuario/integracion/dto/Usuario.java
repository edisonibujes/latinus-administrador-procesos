
package net.latinus.usuario.integracion.dto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String cn;
    String direccionNacimiento;
    String estadoCuenta;
    String fechaNacimiento;
    String fechaRegistro;
    String mail;
    String mobile;
    String postalAddress;
    List<Rol> roles = new ArrayList();

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getDireccionNacimiento() {
        return direccionNacimiento;
    }

    public void setDireccionNacimiento(String direccionNacimiento) {
        this.direccionNacimiento = direccionNacimiento;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cn=" + cn + ", direccionNacimiento=" + direccionNacimiento + ", estadoCuenta=" + estadoCuenta + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", mail=" + mail + ", mobile=" + mobile + ", postalAddress=" + postalAddress + ", roles=" + roles + '}';
    }
    
}
