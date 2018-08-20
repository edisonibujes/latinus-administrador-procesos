package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.CatalogoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;

/**
 * Created by Latinus on 25/7/16.
 */
public class CatalogoDAOImpl extends GenericoDAOImpl<Catalogo, Integer> implements CatalogoDAO {

    public CatalogoDAOImpl() {
        super(Catalogo.class);
    }

    public Catalogo obtenerCatalogoPorNemonico(String nemonico) {
        Catalogo catalogo;
        try {
            Query query = this.em.createQuery("SELECT c FROM Catalogo c WHERE c.nemonico = :nemonico");
            query.setParameter("nemonico", nemonico);
            catalogo = (Catalogo) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            catalogo = null;
        }
        return catalogo;
    }

    public List<Catalogo> catalogosPorNemonicoPadre(String nemonico) {
        List<Catalogo> catalogos;
        try {
            Query query = this.em.createQuery("SELECT c FROM Catalogo c WHERE c.catalogoPadre.nemonico = :nemonico");
            query.setParameter("nemonico", nemonico);
            catalogos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            catalogos = null;
        }
        return catalogos;
    }

}
