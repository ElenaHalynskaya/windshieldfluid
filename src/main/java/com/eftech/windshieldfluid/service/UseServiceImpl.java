package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Use;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;


@Service
@Transactional
public class UseServiceImpl implements UseService{
    
     @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public Use create(Use use){
        em.getTransaction().begin();
        if (use.getId() == 0) 
            //insert capacity
            em.persist(use);
        else 
            //update capacity
            em.merge(use);
        em.getTransaction().commit();
        return use;
    }
    @Override
    public void delete(Use use){
        em.getTransaction().begin();
        Use mergedUse = em.merge(use);
        em.remove(mergedUse);
        em.getTransaction().commit();
        
    }
    
    @Override
    public Use update(Use use){
        em.getTransaction().begin();
        em.merge(use);
        em.getTransaction().commit();
        return use;
    }
    
    @Override
    public Use findById(int id){
        return em.find(Use.class, id);
    }
    
    @Override
    public List<Use> findAll(){
        List<Use> uses = em.createNamedQuery("Use.findAll",Use.class).getResultList();
        return uses;
    }
}
