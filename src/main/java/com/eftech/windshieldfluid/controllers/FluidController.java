package com.eftech.windshieldfluid.controllers;

import com.eftech.windshieldfluid.configuration.ConversionConfiguration;
import com.eftech.windshieldfluid.model.Capacity;
import com.eftech.windshieldfluid.model.Country;
import com.eftech.windshieldfluid.model.Fluid;
import com.eftech.windshieldfluid.model.FluidType;
import com.eftech.windshieldfluid.model.Manufacturer;
import com.eftech.windshieldfluid.model.Temperature;
import com.eftech.windshieldfluid.model.Use;
import com.eftech.windshieldfluid.service.CapacityService;
import com.eftech.windshieldfluid.service.CountryService;
import com.eftech.windshieldfluid.service.FluidService;
import com.eftech.windshieldfluid.service.FluidtypeService;
import com.eftech.windshieldfluid.service.ManufacturerService;
import com.eftech.windshieldfluid.service.TemperatureService;
import com.eftech.windshieldfluid.service.UseService;
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
@RequestMapping("/fluids")
public class FluidController {
     
        @Autowired
        private FluidService fluidService;
        @Autowired
        private CapacityService capacityService;
        @Autowired
        private CountryService countryService;
        @Autowired
        private FluidtypeService fluidtypeService;
        @Autowired
        private ManufacturerService manufacturerService;
        @Autowired
        private TemperatureService temperatureService;
         @Autowired
        private UseService useService;
        
	
        @RequestMapping(value = {"/","listFluids"}, method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Fluid> fluids = fluidService.findAll();
                uiModel.addAttribute("fluids", fluids);
                uiModel.addAttribute("fluid",new Fluid());
                List<Capacity> capacities = capacityService.findAll();
                uiModel.addAttribute("capacities",capacities);
                List<Country> countries = countryService.findAll();
                uiModel.addAttribute("countries",countries);
                List<FluidType> fluidtypes = fluidtypeService.findAll();
                uiModel.addAttribute("fluidtypes",fluidtypes);
                List<Manufacturer> manufacturers = manufacturerService.findAll();
                uiModel.addAttribute("manufacturers",manufacturers);
                List<Temperature> temperatures = temperatureService.findAll();
                uiModel.addAttribute("temperatures",temperatures);
                List<Use> uses = useService.findAll();
                uiModel.addAttribute("uses",uses);
                return "admin/fluid";
	}
        
        @RequestMapping(value= "/save", method = RequestMethod.POST)
        public String save(@Valid Fluid fluid, BindingResult bindingResult, Model uiModel){
            if (bindingResult.hasErrors())
            {
                List<Fluid> fluids = fluidService.findAll();
                uiModel.addAttribute("fluids", fluids);
                uiModel.addAttribute("fluid",fluid);
                List<Capacity> capacities = capacityService.findAll();
                uiModel.addAttribute("capacities",capacities);
                List<Country> countries = countryService.findAll();
                uiModel.addAttribute("countries",countries);
                List<FluidType> fluidtypes = fluidtypeService.findAll();
                uiModel.addAttribute("fluidtypes",fluidtypes);
                List<Manufacturer> manufacturers = manufacturerService.findAll();
                uiModel.addAttribute("manufacturers",manufacturers);
                List<Temperature> temperatures = temperatureService.findAll();
                uiModel.addAttribute("temperatures",temperatures);
                List<Use> uses = useService.findAll();
                uiModel.addAttribute("uses",uses);
                return "admin/fluid";
            }
            fluidService.save(fluid);
            return "redirect:/fluids/";
 	}
	
        @RequestMapping(value= "/remove/{id}")
        public String remove(@PathVariable("id") Long id){
            Fluid fluid = fluidService.findById(id);
            fluidService.delete(fluid);
            
            return "redirect:/fluids/";
            
         }
        
        @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model uiModel){
            uiModel.addAttribute("fluid", this.fluidService.findById(id));
            uiModel.addAttribute("fluids", this.fluidService.findAll());
            List<Capacity> capacities = capacityService.findAll();
            uiModel.addAttribute("capacities",capacities);
            List<Country> countries = countryService.findAll();
            uiModel.addAttribute("countries",countries);
            List<FluidType> fluidtypes = fluidtypeService.findAll();
            uiModel.addAttribute("fluidtypes",fluidtypes);
            List<Manufacturer> manufacturers = manufacturerService.findAll();
            uiModel.addAttribute("manufacturers",manufacturers);
            List<Temperature> temperatures = temperatureService.findAll();
            uiModel.addAttribute("temperatures",temperatures);
            List<Use> uses = useService.findAll();
            uiModel.addAttribute("uses",uses);
            return "admin/fluid";
    }
    
    @Autowired
    private ConversionConfiguration conversionConfiguration;
     
    //@InitBinder
    //private void initBinder(ServletRequestDataBinder binder){
      //     binder.setConversionService(conversionConfiguration.getConversionService());
    //}
}
