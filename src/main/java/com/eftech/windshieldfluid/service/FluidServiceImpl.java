package com.eftech.windshieldfluid.service;

import com.eftech.windshieldfluid.model.Fluid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.repository.FluidRepository;
import com.google.common.collect.Lists;
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
    
     private FluidRepository fluidRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<Fluid> findAll() {
            return Lists.newArrayList(fluidRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public Fluid findById(Long id) {
		return fluidRepository.findOne(id);
	}
        @Override
	public Fluid save(Fluid fluid) {
		return fluidRepository.save(fluid);
	}

	@Override
	public void delete(Fluid fluid) {
		fluidRepository.delete(fluid);
	}
   
}
