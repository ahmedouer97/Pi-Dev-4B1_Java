package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News implements Serializable{
	
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
    @Column(name = "titre")
	private String titre;
	@Column(name = "image")
	private String image;
    @Column(name = "contenue")
	private String contenue;
    @Column(name = "nomAuteur")
	private String nomAuteur;
    @Column(name = "datePublish")
    private Date datePublish ;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
	
	 
	public Date getDatePublish() {
		return datePublish;
	}
	public void setDatePublish(Date datePublish) {
		this.datePublish = datePublish;
	}
	public News(String titre, String image, String contenue, String nomAuteur) {
		super();
		this.titre = titre;
		this.image = image;
		this.contenue = contenue;
		this.nomAuteur = nomAuteur;
	}
	public News(int id, String titre, String image, String contenue, String nomAuteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.image = image;
		this.contenue = contenue;
		this.nomAuteur = nomAuteur;
	}
	public News() {
		super();
	}
	public News(int id, String titre, String image, String contenue, String nomAuteur, Date datePublish) {
		super();
		this.id = id;
		this.titre = titre;
		this.image = image;
		this.contenue = contenue;
		this.nomAuteur = nomAuteur;
		this.datePublish = datePublish;
	}
	public News(String titre, String image, String contenue, String nomAuteur, Date datePublish) {
		super();
		this.titre = titre;
		this.image = image;
		this.contenue = contenue;
		this.nomAuteur = nomAuteur;
		this.datePublish = datePublish;
	}
	
	
	
	

}
