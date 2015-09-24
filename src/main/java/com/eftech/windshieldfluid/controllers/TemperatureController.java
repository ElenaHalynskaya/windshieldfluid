package com.eftech.windshieldfluid.controllers;

import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.model.Temperature;
import com.eftech.windshieldfluid.service.CapacityService;
import com.eftech.windshieldfluid.service.TemperatureService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/temperatures")
public class TemperatureController {
    
        @Autowired
        private TemperatureService temperatureService;
	
        @RequestMapping(value = {"/","listTemperatures"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Temperature> temperatures = temperatureService.findAll();
                uiModel.addAttribute("temperatures", temperatures);
                uiModel.addAttribute("temperature",new Temperature());
                return "admin/temperature";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@Valid Temperature temperature, BindingResult bindingResult, Model uiModel){
             if (bindingResult.hasErrors())
            {
                List<Temperature> temperatures = temperatureService.findAll();
                uiModel.addAttribute("temperatures", temperatures);
                uiModel.addAttribute("temperature", temperature);
                return "admin/temperature";
            }
            temperatureService.save(temperature);
            return "redirect:/temperatures/";
 	}
        
         @RequestMapping(value= "/remove/{id}")
         public String remove(@PathVariable("id") Long id){
            Temperature temperature = temperatureService.findById(id);
            temperatureService.delete(temperature);
            return "redirect:/temperatures/";
         }
         
         @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("temperature", this.temperatureService.findById(id));
            uiModel.addAttribute("temperatures", this.temperatureService.findAll());
            return "admin/temperature";
    }
}
