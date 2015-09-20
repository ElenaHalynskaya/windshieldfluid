package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CountryRepository extends CrudRepository<Country, Long>{
    
}
