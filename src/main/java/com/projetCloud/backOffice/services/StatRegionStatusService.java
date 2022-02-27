package com.projetCloud.backOffice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.StatRegionStatus;
import com.projetCloud.backOffice.repositories.StatRegionStatusRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatRegionStatusService {
	
	@Autowired
	private StatRegionStatusRepository regionStatusRepository;
	
	public List<StatRegionStatus> listeStatRegionStatus(final Long idRegion,final Long idStatus){
		return regionStatusRepository.findByFilters(idRegion,idStatus);
	}
}
