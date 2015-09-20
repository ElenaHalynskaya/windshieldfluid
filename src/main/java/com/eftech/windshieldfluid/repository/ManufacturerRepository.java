package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long>{
    
}
