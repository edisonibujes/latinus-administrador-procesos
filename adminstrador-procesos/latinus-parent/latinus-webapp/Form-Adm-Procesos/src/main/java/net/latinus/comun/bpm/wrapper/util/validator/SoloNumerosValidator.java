/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.comun.bpm.wrapper.util.validator;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cherrera
 */
@FacesValidator("soloNumerosValidator")
public class SoloNumerosValidator implements Validator, Serializable {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Boolean valNumero;

        String message;
        String numero = (String) value;

        if (numero == null || numero.length() < 1) {
            message = "Debe ingresar un valor";
            throw new ValidatorException(new FacesMessage(message));
        }

        try {

            Long vNumero = new Long(numero);

            valNumero = Boolean.TRUE;

        } catch (Exception e) {
            valNumero = Boolean.FALSE;
        }

        if (!valNumero) {
            message = "El valor " + numero + " debe ser NUMERICO";
            throw new ValidatorException(new FacesMessage(message));
        }

    }

    public static boolean soloNumeros(String campoValidar) {
        Pattern patronA = Pattern.compile("[0-9]*([\\.])([0-9]*)");
        Pattern patronB = Pattern.compile("[0-9]*");
        Matcher encajaA = patronA.matcher(campoValidar.trim());
        Matcher encajaB = patronB.matcher(campoValidar.trim());
        if (encajaA.matches() || encajaB.matches()) {
            System.out.println("true :" + campoValidar);
            return true;
        } else {
            System.out.println("false :" + campoValidar);
            return false;
        }
    }

    public static boolean validaCoordenadaConLimiteFrontera(String campoValidar) {
        return validaNumeroConDecimales(campoValidar) || validaNumeroEntero(campoValidar);
    }

    public static boolean validaCoordenadaSinLimiteFrontera(String campoValidar) {
        return validaNumeroEntero(campoValidar) && validaNumeroMultiploCien(campoValidar);
    }

    public static boolean validaNumeroEntero(String campoValidar) {
        Pattern patronA = Pattern.compile("[0-9]*");
        Matcher encajaA = patronA.matcher(campoValidar.trim());
        if (encajaA.matches()) {
            return true;
        } else {
            System.out.println("El campo: " + campoValidar + " no es un número entero.");
            return false;
        }
    }

    public static boolean validaNumeroMultiploCien(String campoValidar) {
        System.out.println("campoValidar: " + campoValidar);
        Integer campoV = Integer.parseInt(campoValidar.trim());
        Integer resp = campoV % 100;
        if (resp == 0) {
            return true;
        } else {
            System.out.println("El campo: " + campoValidar + " no es multiplo de 100.");
            return false;
        }
    }

    public static boolean validaNumeroConDecimales(String campoValidar) {
        Pattern patronA = Pattern.compile("[0-9]*([\\.])([0-9]*)");
        Matcher encajaA = patronA.matcher(campoValidar.trim());
        return encajaA.matches() && validaCuatroDecimales(campoValidar);
    }

    public static boolean validaCuatroDecimales(String campoValidar) {
        System.out.println("validaCuatroDecimales: " + campoValidar);
        String decimales[] = campoValidar.trim().split("\\.");
        System.out.println("Decimales: " + decimales[1]);
        try {
            if (Integer.parseInt(decimales[1].trim()) <= 9999) {
                System.out.println("validaCuatroDecimales: true");
                return true;
            } else {
                System.out.println("validaCuatroDecimales: false");
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
