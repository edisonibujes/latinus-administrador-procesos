/*
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 *          SISTEMA DE GESTION MIMERO ARCOM         
 *          Todos los Derechos Reservados.                                     
 *          Copyright (C) LATINUS S.A - ARCOM                   
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 */
package net.latinus.comun.bpm.wrapper.util.validator;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author David Paucar Gonzalez <david_gem1@hotmail.com>.
 */
@FacesValidator("plazoCoordenadas")
public class PlazoCoordenadas implements Validator, Serializable {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int plazo = Integer.parseInt(value.toString());
        //Mayor a 0 y menor a 121 meses
        if (plazo < 1 || plazo > 120) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El campo " + component.getAttributes().get("label") + " no es válido, "
                    + "debe se mayor a 0 y menor a 120 meses.", null));
        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
