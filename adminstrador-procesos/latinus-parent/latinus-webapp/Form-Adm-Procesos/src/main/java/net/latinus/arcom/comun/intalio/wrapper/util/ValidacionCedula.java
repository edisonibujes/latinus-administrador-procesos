/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.util;

import java.io.Serializable;
import net.latinus.arcom.comun.dto.CedulaDTO;
import net.latinus.arcom.ws.client.jar.bsg.service.RegistroCivilService;
//import net.latinus.snap.ws.cliente.civil.Cedula;
//import net.latinus.snap.ws.cliente.civil.impl.WSRegistroCivilConsultaCedulaImpl;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public class ValidacionCedula implements Serializable {

    public ValidacionCedula() {
        System.out.println("Crea el constructor ValidacionCedula");
    }

    public static boolean validarCedula(String cedula) {
        boolean cedulaCorrecta;
        try {
            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }

    /**
     * Validar
     *
     * @param cedula
     * @return
     */
    @SuppressWarnings("UnusedAssignment")
    public static boolean validarCedulaRegistroCivil(String cedula) {

        Boolean cedulaCorrecta = Boolean.FALSE;
//        WSRegistroCivilConsultaCedulaImpl wsRegistroCivilConsultaCedula = new WSRegistroCivilConsultaCedulaImpl();
        try {
            System.out.println("ENTRA AL TRY DE VALIDAR CEDULA RC");
            System.out.println("cedula: " + cedula);
            CedulaDTO result = RegistroCivilService.validarCedula(cedula);
//            Cedula result = wsRegistroCivilConsultaCedula.busquedaPorCedula(cedula);
            System.out.println("result : " + result.getNombre());
            cedulaCorrecta = result.getCodigoError().equals("000");

        } catch (Exception e) {
            System.out.println("ERROR VALIDAR CEDULA RC" + e.getMessage());
            cedulaCorrecta = validarCedula(cedula);
        }
        return cedulaCorrecta;
    }

}
