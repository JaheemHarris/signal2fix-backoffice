package com.projetCloud.backOffice.services;

import java.util.ArrayList;
import java.util.Optional;

import com.projetCloud.backOffice.models.CustomUserDetails;
import com.projetCloud.backOffice.models.Role;
import com.projetCloud.backOffice.models.Utilisateur;
import com.projetCloud.backOffice.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UtilisateurRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Utilisateur> adminOpt = userRepository.findByEmailAndRole(email,new Role(Long.valueOf(1),"ADMIN"));
		Utilisateur admin = null;
		if(!adminOpt.isPresent())
			throw new UsernameNotFoundException(email);
		admin = adminOpt.get();
		return new CustomUserDetails(admin);
	}

}
