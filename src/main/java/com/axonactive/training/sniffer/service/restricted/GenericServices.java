/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axonactive.training.sniffer.service.restricted;

import com.axonactive.training.sniffer.entity.restricted.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nvmuon
 * @param <E>
 * @param <B>
 */
public abstract class GenericServices<E extends GenericEntity, B> {

    @PersistenceContext(name = "snifferPU")
    EntityManager em;

    private final Class<E> entityClass;

    public GenericServices(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void save(E entity) {
        if (entity.getId() != null) {
            this.em.merge(entity);
        } else {
            this.em.persist(entity);
        }
    }

    public E findById(Integer id) {
        return em.find(entityClass, id);
    }

    public void remove(Integer id) {
        E entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }
    
    public abstract E toEntity(B bom);
    
    public abstract B toBom(E entity);
    
    public List<E> toEntities(List<B> boms) {
        if (boms == null) {
            return null;
        }
        List<E> entities = new ArrayList<>();
        for (B each : boms) {
            E entity = toEntity(each);
            if (entity != null) {
                entities.add(entity);
            }
        }
        return entities;
    }
    
    public List<B> toBoms(List<E> entities) {
        if (entities == null) {
            return null;
        }
        List<B> boms = new ArrayList<>();
        for (E each : entities) {
            B bom = toBom(each);
            if (bom != null) {
                boms.add(bom);
            }
        }
        return boms;
    }
}
