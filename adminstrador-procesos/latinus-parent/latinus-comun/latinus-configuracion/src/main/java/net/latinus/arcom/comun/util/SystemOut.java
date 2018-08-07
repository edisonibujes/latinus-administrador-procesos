/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.util;

import java.io.Serializable;
import net.latinus.arcom.comun.configuracion.Configuracion;
import net.latinus.arcom.comun.configuracion.Constantes;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public class SystemOut implements Serializable
{
    /**
     * Controlar mensajes que se imprimen
     * @param message 
     */
    public static void println(String message)
    {
        if(Configuracion.getInstance().getProperty(Configuracion.SHOW_SYSTEM_OUT).equals(Constantes.SI))
        {   
            System.out.println(message);
        }
    
    }
}
