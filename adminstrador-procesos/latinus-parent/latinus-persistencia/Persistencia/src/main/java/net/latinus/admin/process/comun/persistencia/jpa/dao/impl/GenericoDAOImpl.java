/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.io.Serializable;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GenericoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.jpadao.AbstractJPADAO;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Edison
 */
public class GenericoDAOImpl<T, PK extends Serializable> extends AbstractJPADAO implements GenericoDAO<T, PK> {

    private Class<T> type;

    public GenericoDAOImpl(Class<T> type) {
        this.type = type;
    }

    @Transactional(readOnly = true)
    public void create(T newInstance) {
        em.persist(newInstance);
        em.flush();
    }

    public T read(PK id) {
        return em.find(type, id);
    }

    @Transactional
    public void update(T persistentObject) {
        em.merge(persistentObject);
        em.flush();
    }

    /**
     * Deletes a persistent object.
     *
     * @param persistentObject the persistent object
     */
    @Transactional
    public void delete(T persistentObject) {
        em.remove(em.merge(persistentObject));
        em.flush();
    }

}
