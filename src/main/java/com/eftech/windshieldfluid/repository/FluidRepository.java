package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Fluid;
import org.springframework.data.repository.CrudRepository;

public interface FluidRepository extends CrudRepository<Fluid, Long>{
    
}