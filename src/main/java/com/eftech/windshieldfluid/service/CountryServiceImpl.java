package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Country;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eftech.windshieldfluid.repository.CountryRepository;
import com.google.common.collect.Lists;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.Repository;
import javax.persistence.TypedQuery;


@Service
@Transactional
public class CountryServiceImpl implements CountryService{
        
        private CountryRepository countryRepository;
 
	@Transactional(readOnly=true)
        @Override
	public List<Country> findAll() {
            return Lists.newArrayList(countryRepository.findAll());
        }

	@Transactional(readOnly=true)
        @Override
	public Country findById(Long id) {
		return countryRepository.findOne(id);
	}
        @Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public void delete(Country country) {
		countryRepository.delete(country);
	}
  
}
