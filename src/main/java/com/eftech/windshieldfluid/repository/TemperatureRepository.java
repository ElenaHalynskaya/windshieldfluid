package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Temperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TemperatureRepository extends CrudRepository<Temperature, Long>{
    
}
