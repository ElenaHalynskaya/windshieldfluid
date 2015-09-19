package com.eftech.windshieldfluid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.service.CapacityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
//@ComponentScan("com.eftech.windshieldfluid.service")
@RequestMapping("/capacities")
public class CapacityController {
    
        @Autowired
        private CapacityService capacityService;
	
        @RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Capacity> capacities = capacityService.findAll();
                uiModel.addAttribute("capacities", capacities);
                return "admin/capacity";
	}
        
        @RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addCapacity(@ModelAttribute("capacity") Capacity capacity){
		this.capacityService.save(capacity);
		
		return "redirect:/";
		
	}
}
