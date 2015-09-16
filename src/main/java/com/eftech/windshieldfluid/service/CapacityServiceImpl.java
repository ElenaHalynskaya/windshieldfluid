package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Capacity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;

@Service
//@Repository
@Transactional
public class CapacityServiceImpl implements CapacityService{
    
    @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public Capacity create(Capacity capacity){
        em.getTransaction().begin();
        if (capacity.getId() == 0) 
            //insert capacity
            em.persist(capacity);
        else 
            //update capacity
            em.merge(capacity);
        em.getTransaction().commit();
        return capacity;
    }
    @Override
    public void delete(Capacity capacity){
        em.getTransaction().begin();
        Capacity mergedCapacity = em.merge(capacity);
        em.remove(mergedCapacity);
        em.getTransaction().commit();
        
    }
    
    @Override
    public Capacity update(Capacity capacity){
        em.getTransaction().begin();
        em.merge(capacity);
        em.getTransaction().commit();
        return capacity;
    }
    
    @Override
    public Capacity findById(int id){
        return em.find(Capacity.class, id);
    }
    
    @Override
    public List<Capacity> findAll(){
        List<Capacity> capacities = em.createNamedQuery("Capacity.findAll",Capacity.class).getResultList();
        return capacities;
    }
    
}
