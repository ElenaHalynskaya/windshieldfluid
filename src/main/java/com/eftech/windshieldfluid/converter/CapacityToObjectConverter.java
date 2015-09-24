package com.eftech.windshieldfluid.converter;

import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CapacityToObjectConverter implements Converter<Object, Capacity>{
        
        @Autowired
	CapacityService capacityService;
        
        public Capacity convert(Object element) {
                Long id = Long.parseLong((String)element);
		Capacity capacity = capacityService.findById(id);
		return capacity;
	}
}
