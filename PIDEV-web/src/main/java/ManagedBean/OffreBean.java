package ManagedBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Service.OffreService;

import model.Offre;

@ManagedBean
public class OffreBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String description;
	private String title;
	private float price;	
	private Date endDate;
	private String picture;
	private Date startDate;
	
	private List<Offre> offres;
	@EJB
	OffreService OffreService;

	
	public List<Offre> getOffres() {
		offres = OffreService.getAllOffres();
		return offres;
		}

	public OffreService getOffreService() {
		return OffreService;
	}

	public void setOffreService(OffreService offreService) {
		OffreService = offreService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
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

	
	

	public OffreBean(String description, String title, float price, Date endDate, String picture, Date startDate
			, List<Offre> offres, Service.OffreService offreService) {
		super();
		this.description = description;
		this.title = title;
		this.price = price;
		this.endDate = endDate;
		this.picture = picture;
		this.startDate = startDate;
		
		this.offres = offres;
		OffreService = offreService;
	}

	

	public OffreBean() {
		super();
	}
	

}
