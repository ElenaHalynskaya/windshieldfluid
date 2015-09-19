package com.eftech.windshieldfluid.service;

import com.eftech.windshieldfluid.model.Temperature;
import com.eftech.windshieldfluid.repository.TemperatureRepository;
import com.google.common.collect.Lists;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TemperatureServiceImpl implements TemperatureService{
    
    private TemperatureRepository temperatureRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<Temperature> findAll() {
            return Lists.newArrayList(temperatureRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public Temperature findById(Long id) {
		return temperatureRepository.findOne(id);
	}
        @Override
	public Temperature save(Temperature temperature) {
		return temperatureRepository.save(temperature);
	}

	@Override
	public void delete(Temperature temperature) {
		temperatureRepository.delete(temperature);
	}
   
}
