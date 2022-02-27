package com.projetCloud.backOffice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.SignalementComplet;

@Repository
public interface SignalementCompletRepository extends JpaRepository<SignalementComplet,Long>{

	@Query(value="SELECT * FROM view_signalementDetails WHERE idregion = ?1",nativeQuery=true)
	List<SignalementComplet> findByRegion(final Long idRegion);

	@Query(value="SELECT * FROM view_signalements_non_affectes WHERE ( :idRegion is null or idregion = CAST(CAST(:idRegion AS VARCHAR) as INTEGER)) AND ( :idType is null or idtype = CAST(CAST(:idType AS VARCHAR) as INTEGER))",nativeQuery=true)
	List<SignalementComplet> findByRegionIsNull(@Param("idRegion") final Long idRegion,@Param("idType") final Long idType);

	@Query(value="SELECT * FROM view_signalements_non_affectes WHERE idsignalement = :id",nativeQuery = true)
	Optional<SignalementComplet> findSignalementNonAffectesById(@Param("id") final Long id);
	
	@Query(value="SELECT * FROM view_signalementDetails WHERE ( :idRegion is null or idregion = CAST(CAST(:idRegion AS VARCHAR) as INTEGER)) AND ( :idType is null or idtype = CAST(CAST(:idType AS VARCHAR) as INTEGER)) AND ( :idStatus is null or idstatus = CAST(CAST(:idStatus AS VARCHAR) as INTEGER))",nativeQuery=true)
	List<SignalementComplet> findByAllFilters(@Param("idRegion") final Long idRegion,@Param("idType") final Long idType,@Param("idStatus") final Long idStatus);
}
