package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.repository.CapacityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.collect.Lists;

@Service
@Transactional
public class CapacityServiceImpl implements CapacityService{
        
        @Autowired
        private CapacityRepository capacityRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<Capacity> findAll() {
            
            return Lists.newArrayList(capacityRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public Capacity findById(Long id) {
		return capacityRepository.findOne(id);
	}
        @Override
	public Capacity save(Capacity capacity) {
                Capacity createdCapacity = capacity;
		return capacityRepository.save(createdCapacity);
	}

	@Override
	public void delete(Capacity capacity) {
		capacityRepository.delete(capacity);
	}
    
   
    
    
}
