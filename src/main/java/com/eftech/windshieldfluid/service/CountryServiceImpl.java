package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Country;
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
public class CountryServiceImpl implements CountryService{

    @PersistenceContext
    private final EntityManager em = Persistence.createEntityManagerFactory("com.eftech_WindshieldFluid_war_1.0-SNAPSHOTPU").createEntityManager();
    
    @Override
    public Country create(Country country){
        em.getTransaction().begin();
        if (country.getId() == 0) 
            //insert capacity
            em.persist(country);
        else 
            //update capacity
            em.merge(country);
        em.getTransaction().commit();
        return country;
    }
    @Override
    public void delete(Country country){
        em.getTransaction().begin();
        Country mergedCountry = em.merge(country);
        em.remove(mergedCountry);
        em.getTransaction().commit();
        
    }
    
    @Override
    public Country update(Country country){
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
        return country;
    }
    
    @Override
    public Country findById(int id){
        return em.find(Country.class, id);
    }
    
    @Override
    public List<Country> findAll(){
        List<Country> countries = em.createNamedQuery("Country.findAll",Country.class).getResultList();
        return countries;
    }
}
