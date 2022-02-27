package com.projetCloud.backOffice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.StatRegionStatus;

@Repository
public interface StatRegionStatusRepository extends JpaRepository<StatRegionStatus,Long>{
	
	@Query(value="SELECT * FROM view_stat_region_status WHERE idregion is not null AND ( :idRegion is null or idregion = CAST(CAST(:idRegion AS VARCHAR) as INTEGER)) AND ( :idStatus is null or idstatus = CAST(CAST(:idStatus AS VARCHAR) as INTEGER))",nativeQuery=true)
	List<StatRegionStatus> findByFilters(@Param("idRegion") final Long idRegion,@Param("idStatus") final Long idStatus);
}
