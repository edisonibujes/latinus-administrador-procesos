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
import net.latinus.arcom.comun.dto.sri.ContribuyenteCompletoDTO;
import net.latinus.arcom.comun.intalio.wrapper.util.ValidacionRUC;
import net.latinus.arcom.ws.client.jar.bsg.service.SRIService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
@Component
@Scope("request")
@FacesValidator("rucValidator")
public class RucValidator implements Validator, Serializable 
{
    
    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException 
    {
         String ruc = (String) arg2;
         
         boolean result = ValidacionRUC.validaExistenciaRUC(ruc);
         
         if(!result)
         {
           String message = "El RUC " + ruc + " ingresado no es válido";  
           throw new ValidatorException(new FacesMessage(message));
         }
         
    }
    
    /**
     *
     * @param ruc
     * @return
     */
    public boolean validarRuc(String ruc) 
    {
        boolean rucCorrecto;

        try {

            SRIService instance = new SRIService();
            String fuenteDatos = "";

            ContribuyenteCompletoDTO result = instance.obtenerInformacionContribuyenteCompleto(ruc, fuenteDatos);

            rucCorrecto = result.getNumeroRuc() != null;

        } catch (Exception e) {
            rucCorrecto = false;
        }

        return rucCorrecto;
    }
}
