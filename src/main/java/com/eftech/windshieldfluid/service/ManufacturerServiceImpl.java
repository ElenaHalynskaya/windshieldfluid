package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Manufacturer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.model.Capacity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService{
    
    @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public Manufacturer create(Manufacturer manufacturer){
        em.getTransaction().begin();
        if (manufacturer.getId() == 0) 
            //insert capacity
            em.persist(manufacturer);
        else 
            //update capacity
            em.merge(manufacturer);
        em.getTransaction().commit();
        return manufacturer;
    }
    @Override
    public void delete(Manufacturer manufacturer){
        em.getTransaction().begin();
        Manufacturer mergedManufacturer = em.merge(manufacturer);
        em.remove(mergedManufacturer);
        em.getTransaction().commit();
        
    }
    
    @Override
    public Manufacturer update(Manufacturer manufacturer){
        em.getTransaction().begin();
        em.merge(manufacturer);
        em.getTransaction().commit();
        return manufacturer;
    }
    
    @Override
    public Manufacturer findById(int id){
        return em.find(Manufacturer.class, id);
    }
    
    @Override
    public List<Manufacturer> findAll(){
        List<Manufacturer> manufacturers = em.createNamedQuery("Manufacturer.findAll",Manufacturer.class).getResultList();
        return manufacturers;
    }

}
