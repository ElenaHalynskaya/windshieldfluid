package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Use;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UseRepository extends CrudRepository<Use, Long>{
    
}
