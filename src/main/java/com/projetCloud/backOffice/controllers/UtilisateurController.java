package com.projetCloud.backOffice.controllers;

import com.projetCloud.backOffice.models.Region;
import com.projetCloud.backOffice.models.Utilisateur;
import com.projetCloud.backOffice.services.RegionService;
import com.projetCloud.backOffice.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService userService;

    @Autowired
    private RegionService regionService;

    @GetMapping("/listeResponsable")
    public ModelAndView getAllResponsables(){
        List<Utilisateur> responsables = userService.getAllResponsables();
        ModelAndView modelView = new ModelAndView();
		modelView.addObject("responsables", responsables);
		modelView.setViewName("listeResponsable");
		return modelView;
    }

    @GetMapping("/ficheResponsable")
    public String getResponsable(@RequestParam(name="responsable") final Long idResponsable, Model model){
        Utilisateur responsable = userService.getResponsable(idResponsable);
        model.addAttribute("responsable",responsable);
        return "ficheResponsable";
    }

    @GetMapping("/ajoutResponsable")
    public ModelAndView getPageAjoutResponsable(Authentication authentication){
        ModelAndView modelView = new ModelAndView();
		List<Region> regions = regionService.getRegions();
		Utilisateur responsable = new Utilisateur();
        responsable.setRegion(new Region());
		modelView.addObject("nom",authentication.getName());
		modelView.addObject("regions", regions);
		modelView.addObject("responsable", responsable);
		modelView.setViewName("ajoutResponsable");
		return modelView;
    }

    @PostMapping("/ajoutResponsable")
    public String ajouterResponsable(@ModelAttribute Utilisateur responsable, Model model){
        Utilisateur  nouveauResponsable = userService.saveResponsable(responsable);
		model.addAttribute("responsable",nouveauResponsable);
		return "redirect:ajoutResponsable";
    }

    @GetMapping("/destituer")
    public String destituerResponsable(@RequestParam(name="responsable") final Long idResponsable){
        userService.deleteResponsable(idResponsable);
		return "redirect:/listeResponsable";
    }
}
