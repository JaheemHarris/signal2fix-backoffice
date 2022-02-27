package com.projetCloud.backOffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long>{

}
