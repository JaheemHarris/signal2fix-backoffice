package com.projetCloud.backOffice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projetCloud.backOffice.models.Region;
import com.projetCloud.backOffice.models.StatPourcentageEffectue;
import com.projetCloud.backOffice.models.StatRegionStatus;
import com.projetCloud.backOffice.models.StatRegionType;
import com.projetCloud.backOffice.models.Status;
import com.projetCloud.backOffice.models.TypeSignalement;
import com.projetCloud.backOffice.services.RegionService;
import com.projetCloud.backOffice.services.StatEffectueService;
import com.projetCloud.backOffice.services.StatRegionStatusService;
import com.projetCloud.backOffice.services.StatRegionTypeService;
import com.projetCloud.backOffice.services.StatusService;
import com.projetCloud.backOffice.services.TypeSignalementService;

@Controller
public class StatistiqueController {
	
	@Autowired
	private StatRegionTypeService regionTypeService;
	
	@Autowired
	private StatRegionStatusService regionStatusService;
	
	@Autowired
	private StatEffectueService effectueService;
	
	@Autowired
	private TypeSignalementService typeService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/stats1")
	public ModelAndView regionType(@RequestParam(name="region",required=false) final Long idRegion,@RequestParam(name="type",required=false)final Long idType) {
		ModelAndView modelView = new ModelAndView();
		List<StatRegionType> regionTypeStats = regionTypeService.listeStatRegionType(idRegion,idType);
		List<TypeSignalement> types = typeService.getTypeSignalements();
		List<Region> regions = regionService.getRegions();
		modelView.addObject("regionTypeStats", regionTypeStats);
		modelView.addObject("types", types);
		modelView.addObject("regions", regions);
		modelView.setViewName("stats1");
		return modelView;
	}
	
	@GetMapping("/stats2")
	public ModelAndView regionStatus(@RequestParam(name="region",required=false) final Long idRegion,@RequestParam(name="status",required=false)final Long idStatus) {
		ModelAndView modelView = new ModelAndView();
		List<StatRegionStatus> regionStatusStats = regionStatusService.listeStatRegionStatus(idRegion,idStatus);
		List<Region> regions = regionService.getRegions();
		List<Status> allStatus = statusService.getAllStatus();
		modelView.addObject("regionStatusStats", regionStatusStats);
		modelView.addObject("regions", regions);
		modelView.addObject("allStatus",allStatus);
		modelView.setViewName("stats2");
		return modelView;
	}
	
	@GetMapping("/stats3")
	public ModelAndView effectue(@RequestParam(name="region",required=false) final Long idRegion) {
		ModelAndView modelView = new ModelAndView();
		List<StatPourcentageEffectue> effectueStats = new ArrayList<StatPourcentageEffectue>();
		if(idRegion==null)
			effectueStats = effectueService.listeStatEffectue();
		else
			effectueStats = effectueService.listeStatEffectueByRegion(idRegion);
		List<Region> regions = regionService.getRegions();
		modelView.addObject("effectueStats", effectueStats);
		modelView.addObject("regions", regions);
		modelView.setViewName("stats3");
		return modelView;
	}
}
