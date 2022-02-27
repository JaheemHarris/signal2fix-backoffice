package com.projetCloud.backOffice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.TypeSignalement;
import com.projetCloud.backOffice.repositories.TypeSignalementRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeSignalementService {
	
	@Autowired
	private TypeSignalementRepository typeRepository;
	
	public List<TypeSignalement> getTypeSignalements(){
		return typeRepository.findAll();
	}
}
