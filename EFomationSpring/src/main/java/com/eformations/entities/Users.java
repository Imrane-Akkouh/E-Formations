package com.eformations.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
    @Indexed(unique=true)
    private String username;
    
    private String password; 
    
    private float rating;
    
    private int nbr_reviewers;
    
    private ArrayList<String> rated_fromations;
    
    private ArrayList<String> formations;
    
    @DBRef
    private Set<Roles> roles;
    
    // C O N S T R U C T O R S
	public Users() {	
		super();
	}

	public Users(String username, String password, Set<Roles> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.rating = 0;
		this.nbr_reviewers = 0;
		this.rated_fromations = new ArrayList<String>();
		this.formations = new ArrayList<String>();
	}

	public Users(String username, String password, String cv, float rating, int nbr_reviewers,
			ArrayList<String> rated_fromations, ArrayList<String> formations, Set<Roles> roles) {
		this.username = username;
		this.password = password;
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

	public ArrayList<String> getRated_fromations() {
		return rated_fromations;
	}

	public void setRated_fromations(ArrayList<String> rated_fromations) {
		this.rated_fromations = rated_fromations;
	}

	public ArrayList<String> getFormations() {
		return formations;
	}

	public void setFormations(ArrayList<String> formations) {
		this.formations = formations;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	
}
