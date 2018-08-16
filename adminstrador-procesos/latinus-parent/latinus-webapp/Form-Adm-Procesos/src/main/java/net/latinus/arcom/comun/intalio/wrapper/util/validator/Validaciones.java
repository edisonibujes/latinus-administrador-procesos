/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.util.validator;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Roddy Arana - Latinus
 */
public class Validaciones implements Validator, Serializable 
{

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException 
    {

        String cadena = (String) arg2;

        if (!(cadena).matches(("^[A-Z0-9a-z_\\-\\.\\,\\% ]*$"))) {
            throw new ValidatorException(new FacesMessage(
                    "No se permiten caracteres especiales"));
        }
    }
    
    

   


}
