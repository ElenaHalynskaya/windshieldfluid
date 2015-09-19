package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Manufacturer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.repository.ManufacturerRepository;
import com.google.common.collect.Lists;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService{
    
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
