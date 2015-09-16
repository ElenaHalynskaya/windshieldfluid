package com.eftech.windshieldfluid.service;

import com.eftech.windshieldfluid.model.Fluid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.model.Capacity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;

@Service
@Transactional
public class FluidServiceImpl implements FluidService{
    
    @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public Fluid create(Fluid fluid){
        em.getTransaction().begin();
        if (fluid.getId() == 0) 
            //insert capacity
            em.persist(fluid);
        else 
            //update capacity
            em.merge(fluid);
        em.getTransaction().commit();
        return fluid;
    }
    @Override
    public void delete(Fluid fluid){
        em.getTransaction().begin();
        Fluid mergedFluid = em.merge(fluid);
        em.remove(mergedFluid);
        em.getTransaction().commit();
        
    }
    
    @Override
    public Fluid update(Fluid fluid){
        em.getTransaction().begin();
        em.merge(fluid);
        em.getTransaction().commit();
        return fluid;
    }
    
    @Override
    public Fluid findById(int id){
        return em.find(Fluid.class, id);
    }
    
    @Override
    public List<Fluid> findAll(){
        List<Fluid> fluids = em.createNamedQuery("Fluid.findAll",Fluid.class).getResultList();
        return fluids;
    }
}
