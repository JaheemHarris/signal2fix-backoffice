package com.projetCloud.backOffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long>{
}
