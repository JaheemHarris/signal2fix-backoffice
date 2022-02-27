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
@Table(name="view_stat_effectue")
public class StatPourcentageEffectue {
	@Id
	@Column(name="idregion")
	private Long idRegion;
	
	private String region;
	
	@Column(name="nombretotal")
	private Integer nombreTotal;
	
	@Column(name="nombretermine")
	private Integer nombreTermine;
	
	private Double effectue;
}
