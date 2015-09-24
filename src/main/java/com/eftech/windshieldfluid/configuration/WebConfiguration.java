package com.eftech.windshieldfluid.configuration;


import com.eftech.windshieldfluid.converter.CapacityToObjectConverter;
import com.eftech.windshieldfluid.converter.CountryToObjectConverter;
import com.eftech.windshieldfluid.converter.FluidTypeToObjectConverter;
import com.eftech.windshieldfluid.converter.ManufacturerToObjectConverter;
import com.eftech.windshieldfluid.converter.TemperatureToObjectConverter;
import com.eftech.windshieldfluid.converter.UseToObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;  
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;  
import org.springframework.web.servlet.view.UrlBasedViewResolver;  

@Configuration
@EnableWebMvc
@ComponentScan("com.eftech.windshieldfluid")
public class WebConfiguration extends WebMvcConfigurerAdapter {
   
        
    @Bean  
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }  
    @Autowired
    private CapacityToObjectConverter capacityToObjectConverter;
    @Autowired 
    private CountryToObjectConverter countryToObjectConverter;
    @Autowired
    private FluidTypeToObjectConverter fluidtypeToObjectConverter;
    @Autowired 
    private ManufacturerToObjectConverter manufacturerToObjectConverter;
    @Autowired
    private TemperatureToObjectConverter temperatureToObjectConverter;
    @Autowired
    private UseToObjectConverter useToObjectConverter;
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(capacityToObjectConverter);
        registry.addConverter(countryToObjectConverter);
        registry.addConverter(fluidtypeToObjectConverter);
        registry.addConverter(manufacturerToObjectConverter);
        registry.addConverter(temperatureToObjectConverter);
        registry.addConverter(useToObjectConverter);
    }
    
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/*");
    }
    */
     @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}
