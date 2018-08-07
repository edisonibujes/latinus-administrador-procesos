/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.enumeracion;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public enum GenericoEnum 
{
    
     CLASE_INFORME_EXTERNO("CLINFEXT","Clase Informe Externo"),
     CLASE_INFORME_INTERNO("CLINFINT","Clase Informe Interno"),
     CLASE_INFORME_OTROS("CLINFOTRO","Otros");
    
    private String nemonico;
    private String nombre;
    
     GenericoEnum(String nemonico,String nombre)
    {
       this.nemonico=nemonico;
       this.nombre=nombre;
    }
     
       /**
     * @return the nemonico
     */
    public String getNemonico() {
        return nemonico;
    }

    /**
     * @param nemonico the nemonico to set
     */
    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
