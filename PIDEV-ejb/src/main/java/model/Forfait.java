package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Forfaits")
@NamedQuery(name="Forfait.findAll", query="SELECT u FROM Forfait u")
public class Forfait implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Forfait() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;
	
	@Column(name="Nom")
	private String nom;

	@Column(name="prix")
	private float prix;
	
	@Column(name="Description")
	private String Description ;

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + iduser;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + Float.floatToIntBits(prix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forfait other = (Forfait) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (iduser != other.iduser)//
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		return true;
	}
	
	
	

}
