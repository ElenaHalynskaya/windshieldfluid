package com.eftech.windshieldfluid.converter;

import com.eftech.windshieldfluid.model.Use;
import com.eftech.windshieldfluid.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UseToObjectConverter implements Converter<Object, Use>{
    
        @Autowired
	UseService useService;
        
        public Use convert(Object element) {
                Long id = Long.parseLong((String)element);
		Use use = useService.findById(id);
		return use;
	}
}
