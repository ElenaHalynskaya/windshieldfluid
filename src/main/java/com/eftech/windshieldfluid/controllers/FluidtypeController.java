package com.eftech.windshieldfluid.controllers;

import com.eftech.windshieldfluid.model.FluidType;
import com.eftech.windshieldfluid.service.FluidtypeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fluidtypes")
public class FluidtypeController {
      
        @Autowired
        private FluidtypeService fluidtypeService;
	
        @RequestMapping(value = {"/","listFluidtypes"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<FluidType> fluidtypes = fluidtypeService.findAll();
                uiModel.addAttribute("fluidtypes", fluidtypes);
                uiModel.addAttribute("fluidtype",new FluidType());
                return "admin/fluidtype";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@Valid FluidType fluidtype, BindingResult bindingResult, Model uiModel){
            if (bindingResult.hasErrors())
            {
               List<FluidType> fluidtypes = fluidtypeService.findAll();
                uiModel.addAttribute("fluidtypes", fluidtypes);
                uiModel.addAttribute("fluidtype",fluidtype);
                return "admin/fluidtype";
            }
            fluidtypeService.save(fluidtype);
            return "redirect:/fluidtypes/";
 	}
        
         @RequestMapping(value= "/remove/{id}")
         public String remove(@PathVariable("id") Long id){
            FluidType fluidtype = fluidtypeService.findById(id);
            fluidtypeService.delete(fluidtype);
            return "redirect:/fluidtypes/";
         }
         
         @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("fluidtype", this.fluidtypeService.findById(id));
            uiModel.addAttribute("fluidtypes", this.fluidtypeService.findAll());
            return "admin/fluidtype";
    }
}
