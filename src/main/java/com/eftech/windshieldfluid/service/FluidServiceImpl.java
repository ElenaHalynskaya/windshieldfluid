package com.eftech.windshieldfluid.service;

import com.eftech.windshieldfluid.model.Fluid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.repository.FluidRepository;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class FluidServiceImpl implements FluidService{
    
        @Autowired
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
