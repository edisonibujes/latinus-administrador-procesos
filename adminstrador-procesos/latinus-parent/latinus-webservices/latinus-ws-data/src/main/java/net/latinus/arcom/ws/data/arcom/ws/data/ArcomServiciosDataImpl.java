package net.latinus.arcom.ws.data.arcom.ws.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;


/**
 * @author alejomantillasam
 */
public class ArcomServiciosDataImpl implements ArcomServiciosData {

    private static final Logger LOG = LoggerFactory.getLogger(ArcomServiciosDataImpl.class);
    private TipoEventoDAO tipoEventoDAO;
    
    // Getters Setters DAOs

    public TipoEventoDAO getTipoEventoDAO() {
        return tipoEventoDAO;
    }

    public void setTipoEventoDAO(TipoEventoDAO tipoEventoDAO) {
        this.tipoEventoDAO = tipoEventoDAO;
    }
     
    // Metodos de la interfaz
    
    @Override
    public TipoEvento obtenerTipoEventoPorId(Integer id) {
        return tipoEventoDAO.read(id);
    }
    
}
