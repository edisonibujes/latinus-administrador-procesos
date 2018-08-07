/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.jpadao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class AbstractJPADAO {
    protected EntityManager em;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
    
}
