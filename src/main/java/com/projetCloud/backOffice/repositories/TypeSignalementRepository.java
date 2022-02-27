package com.projetCloud.backOffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.TypeSignalement;

@Repository
public interface TypeSignalementRepository extends JpaRepository<TypeSignalement,Long>{

}
