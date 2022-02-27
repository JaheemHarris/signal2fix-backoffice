package com.projetCloud.backOffice.services;

import java.util.List;
import java.util.Optional;

import com.projetCloud.backOffice.models.Region;
import com.projetCloud.backOffice.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetCloud.backOffice.models.Utilisateur;
import com.projetCloud.backOffice.repositories.UtilisateurRepository;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public Iterable<Utilisateur> getUtilisateurs(){
		return utilisateurRepository.findAll();
	}
	
	public Optional<Utilisateur> getUtilisateur(final Long id){
		return utilisateurRepository.findById(id);
	}
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		return savedUtilisateur;
	}
	
	public Utilisateur updateUtilisateur(final Long id,Utilisateur utilisateur) {
		Optional<Utilisateur> user = utilisateurRepository.findById(id);
		Utilisateur updatedUtilisateur = null;
		if(user.isPresent()) {
			Utilisateur currentUser = user.get();
			if(utilisateur.getNom() != null)
				currentUser.setNom(utilisateur.getNom());
			if(utilisateur.getPrenom() != null)
				currentUser.setPrenom(utilisateur.getPrenom());
			if(utilisateur.getEmail() != null)
				currentUser.setEmail(utilisateur.getEmail());
			if(utilisateur.getMotDePasse() != null)
				currentUser.setMotDePasse(utilisateur.getMotDePasse());
			updatedUtilisateur = utilisateurRepository.save(currentUser);
		}
		return updatedUtilisateur;
	}

	public List<Utilisateur> getAllResponsables(){
		return utilisateurRepository.findByRole(new Role(Long.valueOf(2),"CHIEF"));
	}

	public Utilisateur getResponsable(Long id){
		Optional<Utilisateur> optUser = utilisateurRepository.findByIdAndRole(id,new Role(Long.valueOf(2),"CHIEF"));
		Utilisateur utilisateur = null;
		if(optUser.isPresent())
			utilisateur = optUser.get();
		return utilisateur;
	}

	public void deleteResponsable(Long id){
		utilisateurRepository.deleteByIdAndRole(id, new Role(Long.valueOf(2),"CHIEF"));
	}

	public Utilisateur saveResponsable(Utilisateur responsable){
		Utilisateur savedResponsable = null;
		responsable.setRole(new Role(Long.valueOf(2),"CHIEF"));
		savedResponsable = utilisateurRepository.save(responsable);
		return savedResponsable;
	}
}
