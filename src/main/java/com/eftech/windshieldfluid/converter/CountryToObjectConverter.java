package com.eftech.windshieldfluid.converter;

import com.eftech.windshieldfluid.model.Country;
import com.eftech.windshieldfluid.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryToObjectConverter implements Converter<Object, Country>{
        
        @Autowired
	CountryService countryService;
        
        public Country convert(Object element) {
                Long id = Long.parseLong((String)element);
		Country country = countryService.findById(id);
		return country;
	}
}
