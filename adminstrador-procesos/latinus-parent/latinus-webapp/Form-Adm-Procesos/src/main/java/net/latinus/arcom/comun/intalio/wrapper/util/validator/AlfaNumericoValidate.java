/*
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 *          SISTEMA DE GESTION MIMERO ARCOM         
 *          Todos los Derechos Reservados.                                     
 *          Copyright (C) LATINUS S.A - ARCOM                   
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 */
package net.latinus.arcom.comun.intalio.wrapper.util.validator;

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
 * @author David Paucar Gonzalez <david_gem1@hotmail.com>.
 */
@FacesValidator("alfaNumericoValidate")
public class AlfaNumericoValidate implements Validator {

    private static final String CAMPO_PATTERN = "^[a-zàáâãäåèéêëìíîïòóôõöùúûüñÿA-ZÀÁÂÃÄÅÈÉÊËÌÍÎÏÒÓÔÕÖÙÚÛÜÑŸ0-9\\s;#'´]*$";
    private Pattern pattern;
    private Matcher matcher;

    public AlfaNumericoValidate() {
        pattern = Pattern.compile(CAMPO_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El campo " + component.getAttributes().get("label") + " no es válido, no se admiten caracteres especiales", null));
        }

    }
}
