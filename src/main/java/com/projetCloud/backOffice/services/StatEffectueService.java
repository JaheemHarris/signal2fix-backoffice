package com.projetCloud.backOffice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.StatPourcentageEffectue;
import com.projetCloud.backOffice.repositories.StatEffectueRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatEffectueService {
	
	@Autowired
	private StatEffectueRepository statEffectueRepository;
	
	public List<StatPourcentageEffectue> listeStatEffectue(){
		return statEffectueRepository.findRegionNotNull();
	}
	
	public List<StatPourcentageEffectue> listeStatEffectueByRegion(final Long idRegion){
		return statEffectueRepository.findByIdRegion(idRegion);
	}
}
