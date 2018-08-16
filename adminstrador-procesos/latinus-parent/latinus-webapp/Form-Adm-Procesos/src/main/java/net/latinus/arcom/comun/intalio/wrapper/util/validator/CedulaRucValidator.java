/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.util.validator;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Latinus
 */
@Component
@Scope("request")
@FacesValidator("cedulaRucValidator")
public class CedulaRucValidator implements Validator, Serializable {

    static final int MULT = 2;
    static final int TOTAL_PROVINCES = 24;
    private static final int NUM_PROVINCIAS = 24;
    private static int[] coeficientes = {4, 3, 2, 7, 6, 5, 4, 3, 2};
    private static int constante = 11;

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String message = "";
        String numeroDocumento = (String) arg2;
        
        System.out.println("Método de Validación de Cédula");
        Boolean valDocumento = false;
        if (numeroDocumento != null) {
            if (numeroDocumento.length() < 10 || numeroDocumento.length() > 13) {
                message = "Longitud del campo cédula " + numeroDocumento + " no es correcta. Debe ser 10 (si es cédula) ó 13 (si es RUC).";
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            } else if (numeroDocumento.length() == 10) {
                valDocumento = validarCedula(numeroDocumento);
                if (!valDocumento) {
                    message = "La Cédula " + numeroDocumento + " no es correcta.";
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
                } 
            } else if (numeroDocumento.length() == 13) {
                valDocumento = validarRuc(numeroDocumento);
                if (!valDocumento) {
                    message = "El RUC " + numeroDocumento + " no existe.";
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
                } 
            }
        }
        if (valDocumento == false) {
            message = "La Cédula o RUC " + numeroDocumento + " no es correcta.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }

    public static boolean validarCedula(String identificationNumber) {

        boolean valid = false;

        // si no tiene 10 d?gitos es inv?lida
        if (identificationNumber.length() != 10) {
            return valid;
        }

        String province = identificationNumber.substring(0, 2);

        // si sus dos primeros d?gitos son inv?lidos
        if (Integer.parseInt(province) > TOTAL_PROVINCES) {
            return valid;
        }

        int totalEven = 0; // pares
        int totalOdd = 0; // impares

        // la ?ltima posici?n no cuenta solo es verificador
        int totalValidNumbers = identificationNumber.length() - 1;
        int verifier = Integer.parseInt(identificationNumber.charAt(9) + "");

        for (int i = 0; i < totalValidNumbers; i++) {
            int digit = Integer.parseInt(identificationNumber.charAt(i) + "");
            // System.out.println("digit:"+digit);
            if (i % 2 == 0) {// si son impares
                int product = digit * MULT;
                // System.out.println("product:"+product);
                if (product > 9) {
                    product = product - 9;
                }
                totalEven += product;
            } else { // si son pares
                totalOdd += digit;
                // System.out.println(">>>"+totalOdd);
            }
        }

        int total = totalOdd + totalEven;

        String totalString = String.valueOf(total + 10);

        // se verifica la decena superior
        if (totalString.length() > 1) {
            int first = Integer.parseInt(totalString.charAt(0) + "");
            total = Integer.parseInt(first + "0") - total;
            if (total == 10) {
                total = 0;
            }
        }

        int result = total;

        // si el n?mero verificador es igual al resultado del algoritmo
        // entonces es una c?dula v?lida
        if (result == verifier) {
            valid = true;
        }

        return valid;
    }

    public static boolean validarRuc(String identificationNumber) {

        boolean valid = false;

        // si no tiene 10 d?gitos es inv?lida
        if (identificationNumber.length() != 13) {
            return valid;
        }
        String rucNatural = identificationNumber.substring(0, 10);
       if (validaRucEP(identificationNumber) || validacionRUC(identificationNumber) || validarCedula(rucNatural)){
           valid = true;
       }
       return valid;
    }

    public static Boolean validaRucEP(String ruc) {
        final int prov = Integer.parseInt(ruc.substring(0, 2));
        boolean resp = false;

        if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
            resp = false;
        }

        // boolean val = false;
        Integer v1, v2, v3, v4, v5, v6, v7, v8, v9;
        Integer sumatoria;
        Integer modulo;
        Integer digito;
        int[] d = new int[ruc.length()];

        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(ruc.charAt(i) + "");
        }

        v1 = d[0] * 3;
        v2 = d[1] * 2;
        v3 = d[2] * 7;
        v4 = d[3] * 6;
        v5 = d[4] * 5;
        v6 = d[5] * 4;
        v7 = d[6] * 3;
        v8 = d[7] * 2;
        v9 = d[8];

        sumatoria = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8;
        modulo = sumatoria % 11;
        if (modulo == 0) {
            return true;
        }
        digito = 11 - modulo;

        if (digito.equals(v9)) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }

    public static Boolean validacionRUC(String ruc) {
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

        if (resp == d[9]) {
            resp_dato = true;
        } else {
            resp_dato = false;
        }
        return resp_dato;
    }

}
