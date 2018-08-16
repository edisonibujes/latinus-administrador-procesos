/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.util;

import java.io.Serializable;
import net.latinus.arcom.comun.dto.sri.ContribuyenteDTO;
import net.latinus.arcom.ws.client.jar.bsg.service.SRIService;

/**
 * Clase para validacion de RUC
 *
 * @author cherrera
 */
public class ValidacionRUC implements Serializable {

    /**
     * @param args
     */
    private static final int NUM_PROVINCIAS = 24;

    private static final int[] coeficientes = {4, 3, 2, 7, 6, 5, 4, 3, 2};
    private static final int constante = 11;

    /**
     * See:
     * http://www.cyberexplorador.com/2011/02/20/validar-el-ingreso-del-ruc-de-ecuador-en-java-segunda-parte/
     *
     * @param ruc
     * @return
     */
    @SuppressWarnings("UnusedAssignment")
    public static Boolean validacionRUCPersonaNatural(String ruc) {

        boolean resp_dato = false;
        final int prov = Integer.parseInt(ruc.substring(0, 2));
        if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
            resp_dato = false;
        }

        int[] d = new int[10];
        int suma = 0;

        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(ruc.charAt(i) + "");
        }

        for (int i = 0; i < d.length - 1; i++) {
            d[i] = d[i] * coeficientes[i];
            suma += d[i];
        }

        int aux, resp;

        aux = suma % constante;
        resp = constante - aux;

        resp = (aux == 0) ? 0 : resp;

        resp_dato = resp == d[9];

        return resp_dato;
    }

    /**
     * Valida existencia de RUC versus el servicio del SRI
     *
     * @param ruc
     * @return
     */
    public static Boolean validaExistenciaRUC(String ruc) {

        boolean rucCorrecto;

        try {
            if (ruc.length() != 13) {
                rucCorrecto= Boolean.FALSE;
                return rucCorrecto;
            }

            SRIService ss = new SRIService();
            ContribuyenteDTO cdto = ss.obtenerInformacionContribuyenteSimple(ruc, "");

            if (cdto.getNumeroRuc() == null) {
                rucCorrecto= Boolean.FALSE;
            } else {
                rucCorrecto= Boolean.TRUE;
            }

        } catch (Exception e) {
            rucCorrecto = false;
        }

        return rucCorrecto;
    }

}
