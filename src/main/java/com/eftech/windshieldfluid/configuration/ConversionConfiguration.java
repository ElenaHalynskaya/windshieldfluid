package com.eftech.windshieldfluid.configuration;

import com.eftech.windshieldfluid.converter.CapacityToObjectConverter;
import com.eftech.windshieldfluid.converter.CountryToObjectConverter;
import com.eftech.windshieldfluid.converter.FluidTypeToObjectConverter;
import com.eftech.windshieldfluid.converter.ManufacturerToObjectConverter;
import com.eftech.windshieldfluid.converter.TemperatureToObjectConverter;
import com.eftech.windshieldfluid.converter.UseToObjectConverter;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConversionConfiguration{
   
    @Autowired
    private CapacityToObjectConverter capacityToObjectConverter;
    
     @Autowired
    CountryToObjectConverter countryToObjectConverter;
    
    @Autowired
    FluidTypeToObjectConverter fluidtypeToObjectConverter;
    
    @Autowired
    ManufacturerToObjectConverter manufacturerToObjectConverter;
    
    @Autowired
    TemperatureToObjectConverter temperatureToObjectConverter;
    
    @Autowired
    UseToObjectConverter useToObjectConverter;
   
    @Autowired
    private ConversionService conversionService;
    
    @Bean
    public ConversionService getConversionService()
    {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(capacityToObjectConverter);
        bean.setConverters(converters);
        bean.afterPropertiesSet();
        conversionService = bean.getObject();
        return conversionService;
    }
}
