package com.projetCloud.backOffice.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ResponsableRegionController {
	
//	@Autowired
//	public ResponsableRegionServ responsableRegionServ;
//
//	@GetMapping("/listeResponsable")
//	public ModelAndView listeResponsable() {
//		ModelAndView modelView = new ModelAndView();
//		List<ResponsableRegion> responsables = responsableRegionServ.getResponsableRegions();
//		modelView.addObject("responsables", responsables);
//		modelView.setViewName("listeResponsable");
//		return modelView;
//	}
//
//	@GetMapping("/ficheResponsable")
//	public String detailsResponsable(@RequestParam(name="responsable") final Long idResponsable,Model model) {
//		ResponsableRegion responsable = responsableRegionServ.getResponsableRegionByIdResponsable(idResponsable);
//		model.addAttribute("responsable", responsable);
//		return "ficheResponsable";
//	}
}
