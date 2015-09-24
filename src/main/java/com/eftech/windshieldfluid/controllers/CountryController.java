package com.eftech.windshieldfluid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.eftech.windshieldfluid.model.Country;
import com.eftech.windshieldfluid.service.CountryService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/countries")
public class CountryController {
      
        @Autowired
        private CountryService countryService;
	
        @RequestMapping(value = {"/","listCountries"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Country> countries = countryService.findAll();
                uiModel.addAttribute("countries", countries);
                uiModel.addAttribute("country",new Country());
                return "admin/country";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@Valid Country country, BindingResult bindingResult, Model uiModel){
            if (bindingResult.hasErrors())
            {
                List<Country> countries = countryService.findAll();
                uiModel.addAttribute("countries", countries);
                uiModel.addAttribute("country", country);
                return "admin/country";
            }
            countryService.save(country);
            return "redirect:/countries/";
 	}
        
         @RequestMapping(value= "/remove/{id}")
         public String remove(@PathVariable("id") Long id){
            Country country = countryService.findById(id);
            countryService.delete(country);
            return "redirect:/countries/";
         }
         
         @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("country", this.countryService.findById(id));
            uiModel.addAttribute("countries", this.countryService.findAll());
            return "admin/country";
    }
}
