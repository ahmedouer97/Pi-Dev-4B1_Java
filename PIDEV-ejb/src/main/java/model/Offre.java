package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Offres")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String description;
	private String title;
	private float price;
	@Column(name="end_date")
	private Date endDate;

	private String picture;

	@Column(name="start_date")
	private Date startDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Offre(int id, String description, String title, float price, Date endDate, String picture, Date startDate) {
		super();
		this.id = id;
		this.description = description;
		this.title = title;
		this.price = price;
		this.endDate = endDate;
		this.picture = picture;
		this.startDate = startDate;
	}

	public Offre() {
		super();
	}

	public Offre(String description, String title, float price) {
		super();
		this.description = description;
		this.title = title;
		this.price = price;
	}
	
}
