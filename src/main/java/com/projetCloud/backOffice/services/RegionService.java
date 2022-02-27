package com.projetCloud.backOffice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.Region;
import com.projetCloud.backOffice.repositories.RegionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	public List<Region> getRegions(){
		return regionRepository.findAll();
	}
	
	public Optional<Region> getRegion(final Long id){
		return regionRepository.findById(id);
	}
	
	public Region saveRegion(Region region) {
		Region savedregion = regionRepository.save(region);
		return savedregion;
	}
	
	public Region updateRegion(final Long id,Region region) {
		Optional<Region> responsible = regionRepository.findById(id);
		Region updatedregion = null;
		if(responsible.isPresent()) {
			Region currentregion = responsible.get();
			if(region.getNom() != null)
				currentregion.setNom(region.getNom());
			updatedregion = regionRepository.save(currentregion);
		}
		return updatedregion;
	}
}
