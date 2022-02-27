package com.projetCloud.backOffice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Signalement;

@Repository
public interface SignalementRepository extends CrudRepository<Signalement,Long>{

}
