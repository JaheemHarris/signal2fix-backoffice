package com.projetCloud.backOffice.models;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="auth_user")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String prenom;

	private String email;
	
	@Column(name="motdepasse")
	private String motDePasse;

	@OneToOne
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "iduser",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "idrole",referencedColumnName = "id"))
	private Role role;


	@OneToOne
	@JoinTable(name = "chief_region",
			joinColumns = @JoinColumn(name = "iduser",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "idregion",referencedColumnName = "id"))
	private Region region;
}
