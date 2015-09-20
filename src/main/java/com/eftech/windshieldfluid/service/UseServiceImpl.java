package com.eftech.windshieldfluid.service;

import java.util.List;

import com.eftech.windshieldfluid.model.Use;
import com.eftech.windshieldfluid.repository.UseRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class UseServiceImpl implements UseService{
    
        @Autowired
        private UseRepository useRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<Use> findAll() {
            return Lists.newArrayList(useRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public Use findById(Long id) {
		return useRepository.findOne(id);
	}
        @Override
	public Use save(Use use) {
		return useRepository.save(use);
	}

	@Override
	public void delete(Use use) {
		useRepository.delete(use);
	}
  
}
