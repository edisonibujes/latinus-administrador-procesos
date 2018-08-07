/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.latinus.arcom.comun.configuracion.Constantes;

/**
 * Clase de utilitarios
 * @author cherrera
 */
public class UtilDate {

    /**
     *
     * @param strDate
     * @param strFormat
     * @return
     */
    public static Date stringToDate(String strDate, String strFormat) {
        try {

            if (strFormat == null) {
                strFormat = Constantes.DATE_FORMAT;
            }
            
            DateFormat formatter = new SimpleDateFormat(strFormat);

            Date date = formatter.parse(strDate);

            return date;
        } catch (Exception e) {
            return null;
        }
    }
}
