package com.projetCloud.backOffice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.Signalement;
import com.projetCloud.backOffice.repositories.SignalementRepository;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignalementService {
	
	@Autowired
	private SignalementRepository signalementRepository;
	
	public Iterable<Signalement> getSignalements(){
		return signalementRepository.findAll();
	}
	
	public Optional<Signalement> getSignalement(final Long id){
		return signalementRepository.findById(id);
	}
	
	public Signalement saveSignalement(Signalement signalement) {
		Signalement savedSignalement = signalementRepository.save(signalement);
		return savedSignalement;
	}
	
	public Signalement updateSignalement(final Long id,Signalement signalement) {
		Optional<Signalement> signal = signalementRepository.findById(id);
		Signalement updatedSignalement = null;
		if(signal.isPresent()) {
			Signalement currentSignal = signal.get();
			if(signalement.getIdUtilisateur() != null)
				currentSignal.setIdUtilisateur(signalement.getIdUtilisateur());
			if(signalement.getIdType() != null)
				currentSignal.setIdType(signalement.getIdType());
			if(signalement.getIdRegion() != null)
				currentSignal.setIdRegion(signalement.getIdRegion());
			if(signalement.getIdStatus() != null)
				currentSignal.setIdStatus(signalement.getIdStatus());
			if(signalement.getDateSignalement() != null)
				currentSignal.setDateSignalement(signalement.getDateSignalement());
			if(signalement.getLatitude() !=null)
				currentSignal.setLatitude(signalement.getLatitude());
			if(signalement.getLongitude() != null)
				currentSignal.setLongitude(signalement.getLongitude());
			updatedSignalement = this.saveSignalement(currentSignal);
		}
		return updatedSignalement;
	}
}
