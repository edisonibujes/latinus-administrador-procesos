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
@FacesValidator("cedulaValidatorUtil")
public class CedulaValidatorUtil implements Validator, Serializable {

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String message = "";
        String cedula = (String) arg2;
        System.out.println("Entra a CedulaValidatorUtil" + cedula.length());
        if ((cedula == null || cedula.length() < 1) && cedula.length() != 10) {
            System.out.println("Entra al if");
            message = "La cédula " + cedula + " no tiene 10 caracteres";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,message,null));
        }

        boolean result = ValidacionCedula.validarCedulaRegistroCivil(cedula);
//        boolean result = true;

        if (!result) {
            message = "La cédula " + cedula + " ingresada no es válida";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,message,null));
        }

    }

}
