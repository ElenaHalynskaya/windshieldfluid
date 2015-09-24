package com.eftech.windshieldfluid.converter;

import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.model.Temperature;
import com.eftech.windshieldfluid.service.CapacityService;
import com.eftech.windshieldfluid.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TemperatureToObjectConverter implements Converter<Object, Temperature>{
    
        @Autowired
	TemperatureService temperatureService;
        
        public Temperature convert(Object element) {
                Long id = Long.parseLong((String)element);
		Temperature temperature = temperatureService.findById(id);
		return temperature;
	}
}
