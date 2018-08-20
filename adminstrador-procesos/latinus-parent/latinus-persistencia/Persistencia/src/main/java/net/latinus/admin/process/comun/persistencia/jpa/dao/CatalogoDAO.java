package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;

/**
 * Created by Latinus on 25/7/16.
 */
public interface CatalogoDAO extends GenericoDAO<Catalogo,Integer>{
    public static String BEAN_NAME = "catalogoDAO";  
    
    public Catalogo obtenerCatalogoPorNemonico (String nemonico);
    
    public List<Catalogo> catalogosPorNemonicoPadre (String nemonico);
    
}
