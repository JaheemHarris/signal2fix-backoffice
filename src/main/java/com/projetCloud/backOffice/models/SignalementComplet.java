package com.projetCloud.backOffice.models;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Immutable
@Table(name="view_signalementdetails")
public class SignalementComplet {
	
	@Id
	@Column(name="idsignalement")
	private Long idSignalement;
	
	@Column(name="idtype")
	private Long idType;

	private String type;
	
	@Column(name="idregion")
	private Long idRegion;

	private String region;
	
	@Column(name="iduser")
	private Long idUtilisateur;
	
	private String nom;
	
	private String prenom;
	
	@Column(name="idstatus")
	private Long idStatus;
	
	private String status;

	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datesignalement")
	private Date dateSignalement;

	@Column(name = "heuresignalement")
	private LocalTime heureSignalement;
	
	private Double latitude;

	private Double longitude;
}
