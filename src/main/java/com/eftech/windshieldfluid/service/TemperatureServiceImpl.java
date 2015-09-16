package com.eftech.windshieldfluid.service;

import com.eftech.windshieldfluid.model.Temperature;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TemperatureServiceImpl implements TemperatureService{
    @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public Temperature create(Temperature temperature){
        em.getTransaction().begin();
        if (temperature.getId() == 0) 
            //insert capacity
            em.persist(temperature);
        else 
            //update capacity
            em.merge(temperature);
        em.getTransaction().commit();
        return temperature;
    }
    @Override
    public void delete(Temperature temperature){
        em.getTransaction().begin();
        Temperature mergedTemperature = em.merge(temperature);
        em.remove(mergedTemperature);
        em.getTransaction().commit();
        
    }
    
    @Override
    public Temperature update(Temperature temperature){
        em.getTransaction().begin();
        em.merge(temperature);
        em.getTransaction().commit();
        return temperature;
    }
    
    @Override
    public Temperature findById(int id){
        return em.find(Temperature.class, id);
    }
    
    @Override
    public List<Temperature> findAll(){
        List<Temperature> temperatures = em.createNamedQuery("Temperature.findAll",Temperature.class).getResultList();
        return temperatures;
    }

}
