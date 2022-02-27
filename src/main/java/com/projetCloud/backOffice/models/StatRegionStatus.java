package com.projetCloud.backOffice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Immutable
@Table(name="view_stat_region_status")
public class StatRegionStatus {
	@Id
	private Long id;
	
	@Column(name="idregion")
	private Long idRegion;
	
	private String region;
	
	@Column(name="idstatus")
	private Long idStatus;
	
	private String status;
	
	private Integer nombre;
}
