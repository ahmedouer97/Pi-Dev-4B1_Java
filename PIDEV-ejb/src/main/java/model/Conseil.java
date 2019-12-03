package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Conseil.findAll", query = "SELECT a FROM Conseil a")
public class Conseil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ConseilId")
	private int conseilId;
	
	@Column(name = "Title")
	private String Title;

	@Column(name = "Description")
	private String description;
	
	@Column(name = "ConseilImagePath")
	private String conseilImagePath;
	
	@Column(name = "ConseilDate")
	private Date ConseilDate;
	
	// bi-directional many-to-one association to ArtworkSale
	/*@OneToMany(mappedBy = "conseil",fetch=FetchType.EAGER)
	private List<Conseil> Conseils;
	*/
	public Conseil() {}

	public int getConseilId() {
		return conseilId;
	}

	public void setConseilId(int conseilId) {
		this.conseilId = conseilId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConseilImagePath() {
		return conseilImagePath;
	}

	public void setConseilImagePath(String conseilImagePath) {
		this.conseilImagePath = conseilImagePath;
	}

	public Date getConseilDate() {
		return ConseilDate;
	}

	public void setConseilDate(Date conseilDate) {
		ConseilDate = conseilDate;
	}
/*
	public List<Conseil> getConseils() {
		return Conseils;
	}

	public void setConseils(List<Conseil> conseils) {
		Conseils = conseils;
	}
	*/
	
		
		

}
