package com.projetCloud.backOffice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.StatRegionType;
import com.projetCloud.backOffice.repositories.StatRegionTypeRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatRegionTypeService {
	
	@Autowired
	private StatRegionTypeRepository regionTypeRepository;
	
	public List<StatRegionType> listeStatRegionType(final Long idRegion,final Long idType){
		return regionTypeRepository.findByFilters(idRegion,idType);
	}
}
