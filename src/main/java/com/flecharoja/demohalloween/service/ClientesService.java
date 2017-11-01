/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.demohalloween.service;

import com.flecharoja.demohalloween.model.Clientes;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Codecr
 */
@Stateless
public class ClientesService {

    @PersistenceContext
    private EntityManager em;
  
    
   public void add(Clientes c) {
       c.setFechaCreacion(new Date());
       em.persist(c);
   }
   
   public List<Clientes> getAll() {
      return em.createQuery("Select c from Clientes c").getResultList();
   }
    
   
   public void edit(Clientes c) {
       em.merge(c);
   }
   
    public Clientes find(Long id) {
        return em.find(Clientes.class, id);
    }
}
