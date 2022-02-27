package com.projetCloud.backOffice.models;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="signalement")
public class Signalement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idtype")
	private Long idType;
	
	@Column(name="idregion")
	private Long idRegion;
	
	@Column(name="iduser")
	private Long idUtilisateur;
	
	@Column(name="idstatus")
	private Long idStatus;
	
	private String description;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="datesignalement")
	private Date dateSignalement;

	@Column(name="heuresignalement")
	private LocalTime heureSignalement;
	
	private Double latitude;
	
	private Double longitude;
}
