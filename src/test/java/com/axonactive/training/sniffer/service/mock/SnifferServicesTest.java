/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axonactive.training.sniffer.service.mock;

import com.axonactive.training.sniffer.entity.restricted.ProductType;
import com.axonactive.training.sniffer.entity.restricted.SnifferEntity;
import com.axonactive.training.sniffer.service.restricted.SnifferServices;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 *
 * @author nvmuon
 */
@RunWith(MockitoJUnitRunner.class)
public class SnifferServicesTest {
    
    @InjectMocks SnifferServices services;
    
    @Mock EntityManager em;
    
    @Test
    public void testSaveOKWhenValidEntityIsGiven() {
           
        
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                SnifferEntity entity = (SnifferEntity) invocation.getArguments()[0];
                entity.setId(1);
                return null;
            }
        }).when(em).persist(Mockito.any(SnifferEntity.class));
             
        SnifferEntity entity = new SnifferEntity("12345", "dust checker", "39B Truong Son", ProductType.SNIFFER);
        services.save(entity);
        assertEquals(new Integer(1), entity.getId());
    }
    
   @Test
   public void testFindOne() {
       SnifferEntity s = new SnifferEntity("123456789", "Dust checker2", "39B Truong Son, quan Tan Binh, TP.HCM", ProductType.SNIFFER);
       s.setId(1);
       Mockito.when(em.find(SnifferEntity.class, 1)).thenReturn(s);
       
       SnifferEntity other = this.services.findById(1);
       
       assertEquals("123456789", other.getProductCode());
   }
    
}
