package com.eftech.windshieldfluid.controllers;

import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.model.Use;
import com.eftech.windshieldfluid.service.CapacityService;
import com.eftech.windshieldfluid.service.UseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/uses")
public class UseController {
        
        @Autowired
        private UseService useService;
	
        @RequestMapping(value = {"/","listUses"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Use> uses = useService.findAll();
                uiModel.addAttribute("uses", uses);
                uiModel.addAttribute("use",new Use());
                return "admin/use";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("use") Use use){
            
            useService.save(use);
            return "redirect:/uses/";
 	}
        
         @RequestMapping(value= "/remove/{id}")
         public String remove(@PathVariable("id") Long id){
            Use use = useService.findById(id);
            useService.delete(use);
            return "redirect:/uses/";
         }
         
         @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("use", this.useService.findById(id));
            uiModel.addAttribute("uses", this.useService.findAll());
            return "admin/use";
    }
}
