package com.eftech.windshieldfluid.service;

import com.eftech.windshieldfluid.model.Fluid;
import java.util.List;

import com.eftech.windshieldfluid.model.FluidType;
import com.eftech.windshieldfluid.repository.FluidTypeRepository;
import com.google.common.collect.Lists;
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
public class FluidtypeServiceImpl implements FluidtypeService{
    
    private FluidTypeRepository fluidtypeRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<FluidType> findAll() {
            return Lists.newArrayList(fluidtypeRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public FluidType findById(Long id) {
		return fluidtypeRepository.findOne(id);
	}
        @Override
	public FluidType save(FluidType fluidtype) {
		return fluidtypeRepository.save(fluidtype);
	}

	@Override
	public void delete(FluidType fluidtype) {
		fluidtypeRepository.delete(fluidtype);
	}
   
}
