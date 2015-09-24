package com.eftech.windshieldfluid.converter;

import com.eftech.windshieldfluid.model.Manufacturer;
import com.eftech.windshieldfluid.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerToObjectConverter implements Converter<Object, Manufacturer>{
        
        @Autowired
	ManufacturerService manufacturerService;
        
        public Manufacturer convert(Object element) {
                Long id = Long.parseLong((String)element);
		Manufacturer manufacturer = manufacturerService.findById(id);
		return manufacturer;
	}
}
