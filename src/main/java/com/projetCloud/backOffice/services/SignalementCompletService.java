package com.projetCloud.backOffice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.SignalementComplet;
import com.projetCloud.backOffice.repositories.SignalementCompletRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignalementCompletService {
	
	@Autowired
	private SignalementCompletRepository signalCompletRepo;
	
	public List<SignalementComplet> filter(final Long idRegion,final Long idType,final Long idStatus){
		return signalCompletRepo.findByAllFilters(idRegion, idType, idStatus);
	}
	
	public SignalementComplet getSignalementCompletById(final Long idSignalement) {
		Optional<SignalementComplet> signalOpt = signalCompletRepo.findById(idSignalement);
		SignalementComplet signalement = null;
		if(signalOpt.isPresent())
			signalement = signalOpt.get();
		return signalement;
	}

	public SignalementComplet getSignalementNonAffectesById(final Long idSignalement) {
		Optional<SignalementComplet> signalOpt = signalCompletRepo.findSignalementNonAffectesById(idSignalement);
		SignalementComplet signalement = null;
		if(signalOpt.isPresent())
			signalement = signalOpt.get();
		return signalement;
	}
	
	public List<SignalementComplet> getSignalementsNonAffectes(final Long idRegion,final Long idType){
		return signalCompletRepo.findByRegionIsNull(idRegion,idType);
	}
	
	public List<SignalementComplet> getSignalementDetails() {
		return signalCompletRepo.findAll();
	}
}
