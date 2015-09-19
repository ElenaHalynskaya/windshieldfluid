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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/capacities")
public class CapacityController {
    
        @Autowired
        private CapacityService capacityService;
	
        @RequestMapping(value = {"/","listCapacities"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Capacity> capacities = capacityService.findAll();
                uiModel.addAttribute("capacities", capacities);
                uiModel.addAttribute("capacity",new Capacity());
                return "admin/capacity";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("capacity") Capacity capacity){
            
            capacityService.save(capacity);
            return "redirect:/capacities/";
 	}
        
         @RequestMapping(value= "/remove/{id}")
         public String remove(@PathVariable("id") Long id){
            Capacity capacity = capacityService.findById(id);
            capacityService.delete(capacity);
            return "redirect:/capacities/";
         }
         
         @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("capacity", this.capacityService.findById(id));
            uiModel.addAttribute("capacities", this.capacityService.findAll());
            return "admin/capacity";
    }
        
}
