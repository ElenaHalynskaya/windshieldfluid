package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Manufacturer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.repository.ManufacturerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService{
    
       @Autowired
        private ManufacturerRepository manufacturerRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<Manufacturer> findAll() {
            return Lists.newArrayList(manufacturerRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public Manufacturer findById(Long id) {
		return manufacturerRepository.findOne(id);
	}
        @Override
	public Manufacturer save(Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public void delete(Manufacturer manufacturer) {
		manufacturerRepository.delete(manufacturer);
	}
  
}
