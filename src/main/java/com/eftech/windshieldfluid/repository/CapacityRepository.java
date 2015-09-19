package com.eftech.windshieldfluid.repository;

import com.eftech.windshieldfluid.model.Capacity;
import javax.annotation.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CapacityRepository extends CrudRepository<Capacity, Long>  {
    
}
