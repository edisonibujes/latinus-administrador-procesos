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
import net.latinus.arcom.comun.intalio.wrapper.util.ValidacionCedula;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
@Component
@Scope("request")
@FacesValidator("cedulaValidator")
public class CedulaValidator implements Validator, Serializable {

    static final int MULT = 2;
    static final int TOTAL_PROVINCES = 24;
    private static final int NUM_PROVINCIAS = 24;
    private static int[] coeficientes = {4, 3, 2, 7, 6, 5, 4, 3, 2};
    private static int constante = 11;

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String message = "";
        String cedula = (String) arg2;

        if ((cedula == null || cedula.length() < 1) && cedula.length() != 10) {
            message = "La cédula " + cedula + " no tiene 10 caracteres";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }

//        boolean result = ValidacionCedula.validarCedulaRegistroCivil(cedula);
        boolean result = validate(cedula);

        if (!result) {
            message = "La cédula " + cedula + " ingresada no es válida";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }

    }

    /**
     * Valida el n?mero de c?dula de Ecuador
     *
     * @param identificationNumber Solo d?gitos, sin guiones.
     *
     * @return
     */
    public static boolean validate(String identificationNumber) {

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

}
