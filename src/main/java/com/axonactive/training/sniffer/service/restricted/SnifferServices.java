/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axonactive.training.sniffer.service.restricted;

import com.axonactive.training.sniffer.data.bom.Sniffer;
import com.axonactive.training.sniffer.entity.restricted.ProductType;
import com.axonactive.training.sniffer.entity.restricted.SnifferEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author nvmuon
 */
@Stateless
public class SnifferServices extends GenericServices<SnifferEntity, Sniffer> {

    public SnifferServices() {
        super(SnifferEntity.class);
    }

    public SnifferEntity findByCode(String code) {
        Query query = em.createQuery("SELECT s FROM SnifferEntity s WHERE s.productCode = :productCode", SnifferEntity.class);
        query.setParameter("productCode", code);
        List<SnifferEntity> found = query.getResultList();
        return found.isEmpty() ? null : found.get(0);
    }

    public List<SnifferEntity> findAll() {
        Query query = em.createQuery("SELECT s FROM SnifferEntity s", SnifferEntity.class);
        return query.getResultList();
    }
    
    public void deleteByCode(String productCode) {
         SnifferEntity entity = this.findByCode(productCode);

        if (entity != null) {
           this.remove(entity.getId());
        }
    }

    @Override
    public SnifferEntity toEntity(Sniffer bom) {
        SnifferEntity entity = this.findByCode(bom.getProductCode());

        if (entity == null) {
            entity = new SnifferEntity();
        }
        entity.setProductCode(bom.getProductCode());
        entity.setAddress(bom.getAddress());
        entity.setName(bom.getName());
        entity.setRegisterDate(bom.getRegisterDate());
        entity.setType(ProductType.valueOf(bom.getType()));
        return entity;
    }

    @Override
    public Sniffer toBom(SnifferEntity entity) {
        if (entity == null) {
            return null;
        }
        Sniffer bom = new Sniffer();
        bom.setAddress(entity.getAddress());
        bom.setName(entity.getName());
        bom.setProductCode(entity.getProductCode());
        bom.setRegisterDate(entity.getRegisterDate());
        bom.setType(entity.getType().name());
        return bom;
    }

    
}
