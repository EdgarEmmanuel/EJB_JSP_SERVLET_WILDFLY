package module.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	
	@OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_village",referencedColumnName = "id")
	private Village village;
	
	public Client () {
		
	}
	
	public Village getVillage() {
		return village;
	}



	public void setVillage(Village village) {
		this.village = village;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
	
}

