/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.clases;

import java.io.Serializable;

/**
 * Constantes de persistencia.
 * @author cherrera
 */
public class ConstantesPersistencia implements Serializable
{
    public static final String SI                               = "S";
    public static final String NO                               = "N";
    public static final String ACEPTA_CONDICIONES               = "1";
    public static final String SIN_ERROR                        = "00";
    public static final String ERROR_PERSISTENCIA               = "01";
    public static final String ERROR_VALIDACION_FRONT_END       = "02";
    public static final String ERROR_FORMATO_NUMERO             = "03";
    public static final String ERROR_CONVERSION_NUMERICA        = "04";
    public static final String ERROR_NULL_POINTER               = "05";
    public static final String ERROR_GENERAL_GUARDADO           = "06";
    public static final String ERROR_INTEGRACION_API            = "07";
    public static final String ERROR_GENERAL_WEB_SERVICES       = "08";
    public static final String ERROR_REGISTRO_YA_EXISTE         = "09";
    public static final String ERROR_REGISTRO_NO_EXISTE         = "10";
    public static final String ERROR_INESPERADO                 = "99";
    public static final String RESPUESTA_API_CONCESION_VALIDA   = "RA00";

}
