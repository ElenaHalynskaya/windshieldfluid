package com.eftech.windshieldfluid.converter;

import com.eftech.windshieldfluid.model.FluidType;
import com.eftech.windshieldfluid.service.FluidtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FluidTypeToObjectConverter implements Converter<Object, FluidType>{
    
        @Autowired
	FluidtypeService fluidtypeService;
        
        public FluidType convert(Object element) {
                Long id = Long.parseLong((String)element);
		FluidType fluidtype = fluidtypeService.findById(id);
		return fluidtype;
	}
}
