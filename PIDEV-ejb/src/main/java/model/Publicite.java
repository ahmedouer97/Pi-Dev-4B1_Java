package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Publicites database table.
 * 
 */
@Entity
@Table(name="Publicites")
@NamedQuery(name="Publicite.findAll", query="SELECT p FROM Publicite p")
public class Publicite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PubliciteId")
	private int publiciteId;

	@Column(name="DateDebut")
	private String dateDebut;

	@Column(name="DateFin")
	private String dateFin;

	@Column(name="DescriptionPub")
	private String descriptionPub;

	@Column(name="Image")
	private String image;

	@Column(name="NbVues")
	private int nbVues;

	@Column(name="NomPartenaire")
	private String nomPartenaire;

	@Column(name="TitrePub")
	private String titrePub;

	public Publicite() {
	}

	public int getPubliciteId() {
		return this.publiciteId;
	}

	public void setPubliciteId(int publiciteId) {
		this.publiciteId = publiciteId;
	}

	public String getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescriptionPub() {
		return this.descriptionPub;
	}

	public void setDescriptionPub(String descriptionPub) {
		this.descriptionPub = descriptionPub;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbVues() {
		return this.nbVues;
	}

	public void setNbVues(int nbVues) {
		this.nbVues = nbVues;
	}

	public String getNomPartenaire() {
		return this.nomPartenaire;
	}

	public void setNomPartenaire(String nomPartenaire) {
		this.nomPartenaire = nomPartenaire;
	}

	public String getTitrePub() {
		return this.titrePub;
	}

	public void setTitrePub(String titrePub) {
		this.titrePub = titrePub;
	}

}