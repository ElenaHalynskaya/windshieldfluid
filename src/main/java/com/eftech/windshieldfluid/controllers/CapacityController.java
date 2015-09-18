package com.eftech.windshieldfluid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.service.CapacityService;
import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/capacities")
public class CapacityController {
    
        @Autowired
	private CapacityService capacityService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model uiModel) {
		
		//List<Capacity> capacities = capacityService.findAll();
		//uiModel.addAttribute("capacities", capacities);
                Capacity c = new Capacity();
                c.setCapacityName(123);
                capacityService.save(c);
                uiModel.addAttribute("capacities", c);
		return "admin/capacity";
	}
}
