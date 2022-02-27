package com.projetCloud.backOffice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.StatRegionType;

@Repository
public interface StatRegionTypeRepository extends JpaRepository<StatRegionType,Long>{
	
	@Query(value="SELECT * FROM view_stat_region_type WHERE idregion is not null AND ( :idRegion is null or idregion = CAST(CAST(:idRegion AS VARCHAR) as INTEGER)) AND ( :idType is null or idtype = CAST(CAST(:idType AS VARCHAR) as INTEGER))",nativeQuery=true)
	public List<StatRegionType> findByFilters(@Param("idRegion") final Long idRegion,@Param("idType") final Long idType);

}
