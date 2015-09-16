package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.FluidType;
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
public class FluidtypeServiceImpl implements FluidtypeService{
    
    @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public FluidType create(FluidType fluidtype){
        em.getTransaction().begin();
        if (fluidtype.getId() == 0) 
            //insert capacity
            em.persist(fluidtype);
        else 
            //update capacity
            em.merge(fluidtype);
        em.getTransaction().commit();
        return fluidtype;
    }
    @Override
    public void delete(FluidType fluidtype){
        em.getTransaction().begin();
        FluidType mergedFluidtype = em.merge(fluidtype);
        em.remove(mergedFluidtype);
        em.getTransaction().commit();
        
    }
    
    @Override
    public FluidType update(FluidType fluidtype){
        em.getTransaction().begin();
        em.merge(fluidtype);
        em.getTransaction().commit();
        return fluidtype;
    }
    
    @Override
    public FluidType findById(int id){
        return em.find(FluidType.class, id);
    }
    
    @Override
    public List<FluidType> findAll(){
        List<FluidType> fluidtypes = em.createNamedQuery("Fluidtype.findAll",FluidType.class).getResultList();
        return fluidtypes;
    }
}
