/*
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 *                         SISTEMA DE GESTION MIMERO ARCOM 
 *                          Todos los Derechos Reservados
 *                       Copyright (C) ARCOM  - LATINUS S.A
 * -----------------------------------------------------------------------------
 * ----------------------------------------------------------------------------- 
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
 * CoordenadasValidator
 *
 * @author David Paucar Gonzalez <david.paucar@latinus.net>
 * @business SISTEMA DE GESTION MINERA
 * @date 23-oct-2015
 * @version 1.0
 */
@Component
@Scope("request")
@FacesValidator("coordenadasValidator")
public class CoordenadasValidator implements Validator, Serializable {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Long coordena = new Long(value.toString());
        if (coordena % 100 != 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El campo " + component.getAttributes().get("label") + " no es válido, "
                    + "debe ser múltiplo de 100.", null));
        }
    }

}
