package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Fluid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FluidRepository extends CrudRepository<Fluid, Long>{
    
}