package com.projetCloud.backOffice.repositories;

import com.projetCloud.backOffice.models.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Utilisateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

    Optional<Utilisateur> findByEmailAndRole(String email, Role role);

    Optional<Utilisateur> findByIdAndRole(Long id, Role role);

    List<Utilisateur> findByRole(Role role);

    void deleteByIdAndRole(Long id,Role role);
}
