package com.eftech.windshieldfluid.controllers;

import com.eftech.windshieldfluid.model.Manufacturer;
import com.eftech.windshieldfluid.service.ManufacturerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    
        @Autowired
        private ManufacturerService manufacturerService;
	
        @RequestMapping(value = {"/","listManufacturers"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Manufacturer> manufacturers = manufacturerService.findAll();
                uiModel.addAttribute("manufacturers", manufacturers);
                uiModel.addAttribute("manufacturer",new Manufacturer());
                return "admin/manufacturer";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("manufacturer") Manufacturer manufacturer){
            
            manufacturerService.save(manufacturer);
            return "redirect:/manufacturers/";
 	}
        
         @RequestMapping(value= "/remove/{id}")
         public String remove(@PathVariable("id") Long id){
            Manufacturer manufacturer = manufacturerService.findById(id);
            manufacturerService.delete(manufacturer);
            return "redirect:/manufacturers/";
         }
         
         @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("manufacturer", this.manufacturerService.findById(id));
            uiModel.addAttribute("manufacturers", this.manufacturerService.findAll());
            return "admin/manufacturer";
    }
}
