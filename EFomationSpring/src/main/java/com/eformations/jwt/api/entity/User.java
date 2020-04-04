package com.eformations.jwt.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
    @Indexed(unique=true)
    private String username;
    
    private String password;
    
    private String cv;
    
    private float rating;
    
    private int nbr_reviewers;
    
    @DBRef
    ArrayList <Formations> rated_fromations;
    
    @DBRef
    ArrayList <Formations> formations;
    
    @DBRef
    private Set<Roles> roles;
    
    // C O N S T R U C T O R S
	public User() {	
		super();
	}

	public User(String username, String password, Set<Roles> roles) {

		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public User(String username, String password, String cv, float rating, int nbr_reviewers,
			ArrayList<Formations> rated_fromations, ArrayList<Formations> formations, Set<Roles> roles) {

		this.username = username;
		this.password = password;
		this.cv = cv;
		this.rating = rating;
		this.nbr_reviewers = nbr_reviewers;
		this.rated_fromations = rated_fromations;
		this.formations = formations;
		this.roles = roles;
	}

	// G E T T E R S   A N D   S E T T E R S
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNbr_reviewers() {
		return nbr_reviewers;
	}

	public void setNbr_reviewers(int nbr_reviewers) {
		this.nbr_reviewers = nbr_reviewers;
	}

	public ArrayList<Formations> getRated_fromations() {
		return rated_fromations;
	}

	public void setRated_fromations(ArrayList<Formations> rated_fromations) {
		this.rated_fromations = rated_fromations;
	}

	public ArrayList<Formations> getFormations() {
		return formations;
	}

	public void setFormations(ArrayList<Formations> formations) {
		this.formations = formations;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	
}
