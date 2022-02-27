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
@Table(name="view_stat_region_type")
public class StatRegionType {
	
	@Id
	private Long id;
	
	@Column(name="idregion")
	private Long idRegion;
	
	private String region;
	
	@Column(name="idtype")
	private Long idType;
	
	private String type;
	private Integer nombre;
}
