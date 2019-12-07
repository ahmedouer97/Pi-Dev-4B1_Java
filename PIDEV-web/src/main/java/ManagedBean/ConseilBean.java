/*package ManagedBean;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import javax.validation.constraints.Size;

import Service.ConseilService;
import model.Conseil;





@ManagedBean(name="conseilBean")
@SessionScoped
public class ConseilBean implements Serializable {

	/**
	 * 
	
	private static final long serialVersionUID = 1L;
	private int conseilId;
	private String Title;
	private String description;
	private String conseilImagePath;
	private Date ConseilDate;
	private List<Conseil> conseils;
	private Conseil conseil;
	private int conseilIdToBeUpdated;
	
	@EJB
	ConseilService conseilService;
	
	public void Ajouter() {
		conseilService.addConseil(new Conseil(conseilId,Title,description,ConseilDate));
		
		
	}
	public List<Conseil> getConseils() {
		conseils = conseilService.findAllConseils();
		return conseils;
		}
	
	public void removeConseil(int conseilId)
	{ conseilService.deleteConseilById(conseilId);
	}
	
	public void Afficher() {
		conseilService.findAllConseils();
	}
	
	public void modifier(Conseil conseil)
	{this.setTitle(conseil.getTitle());
	 this.setDescription(conseil.getDescription());
	 this.setConseilImagePath(conseil.getConseilImagePath());
	 this.setConseilIdToBeUpdated(conseil.getConseilId());
	 
	}
	
	/*public String editPerson() {
		editPerson = (Conseil) conseils.getRowData();
		return "edit";
	}
	
	public void mettreAjourConseil(){
		conseilService.updateConseil(new Conseil(conseilIdToBeUpdated,Title,description,conseilImagePath,ConseilDate));
		}
	

	public int getConseilId() {
		return conseilId;
	}

	public void setConseilId(int conseilId) {
		this.conseilId = conseilId;
	}
    @Size(min=4,message="title is 4 car min!")
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	@Size(min=2,message="title is 4 car min!")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	
	
	public Date getConseilDate() {
		return ConseilDate;
	}

	public void setConseilDate(Date conseilDate) {
		ConseilDate = conseilDate;
	}
	public ConseilService getConseilService() {
		return conseilService;
	}
	public void setConseilService(ConseilService conseilService) {
		this.conseilService = conseilService;
	}
	public Conseil getConseil() {
		return conseil;
	}
	public void setConseil(Conseil conseil) {
		this.conseil = conseil;
	}
	public int getConseilIdToBeUpdated() {
		return conseilIdToBeUpdated;
	}
	public void setConseilIdToBeUpdated(int conseilIdToBeUpdated) {
		this.conseilIdToBeUpdated = conseilIdToBeUpdated;
	}
	public String getConseilImagePath() {
		return conseilImagePath;
	}
	public void setConseilImagePath(String conseilImagePath) {
		this.conseilImagePath = conseilImagePath;
	}
	public void setConseils(List<Conseil> conseils) {
		this.conseils = conseils;
	}
	
	
	

	
	
	
	
	

} */
