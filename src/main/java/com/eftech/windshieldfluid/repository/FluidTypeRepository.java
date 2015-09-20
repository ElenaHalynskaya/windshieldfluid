package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.FluidType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FluidTypeRepository extends CrudRepository<FluidType, Long>{
    
}
