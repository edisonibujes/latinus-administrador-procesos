/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import net.latinus.arcom.comun.intalio.wrapper.util.ValidacionRUC;

/**
 * Validador de Numero de Documento
 *
 * @author cherrera
 */
@FacesValidator("numeroDocumentoValidator")
public class NumeroDocumentoValidator implements Validator, Serializable {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Boolean valDocumento;

        String message;
        String documento = (String) value;

        //Validar como cédula
        if (documento.length() == 10) {
            valDocumento = ValidacionCedula.validarCedulaRegistroCivil(documento);
            if (!valDocumento) {
                message = "Cédula " + documento + " no es correcta";
                throw new ValidatorException(new FacesMessage(message));
            }

        } else if (documento.length() == 13) //Validar como RUC
        {
            valDocumento = ValidacionRUC.validaExistenciaRUC(documento);
            if (!valDocumento) {
                message = "RUC " + documento + " no existe";
                throw new ValidatorException(new FacesMessage(message));
            }

        } else //Documento no tiene la longitud adecuada
        {
            message = "La documento " + documento + " no tiene 10 ó 13 caracteres";
            throw new ValidatorException(new FacesMessage(message));
        }

    }

}
