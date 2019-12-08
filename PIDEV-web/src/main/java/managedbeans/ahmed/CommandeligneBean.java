package managedbeans.ahmed;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Service.CommandeLigneSerive;
import Service.DeliveryService;
import model.CommandeLigne;
@ManagedBean(name="CommandeligneBean")
@SessionScoped
public class CommandeligneBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idcomlig;
	private Date datePasse;
	private double montantotal;
	private boolean passed;
	private boolean payed;
	private int quantité;
	private int review;
	private String location;
	private static int idchose;
	private List<CommandeLigne> commandelignes;
	public CommandeligneBean() {
		super();
	}
	@EJB
	CommandeLigneSerive cls;
	@EJB
	DeliveryService delsev;
	public List<CommandeLigne> getCommandelignes() {
		commandelignes=cls.findAllcomlig();
		return commandelignes;
	}
	public void affectercommande(int id) {
	
		delsev.AffecterCommande(id,location );
	}
	public void setCommandelignes(List<CommandeLigne> commandelignes) {
		this.commandelignes = commandelignes;
	}
	public void Affc(List<CommandeLigne> commandelignes) {
		this.commandelignes = commandelignes;
	}
	public int getIdcomlig() {
		return idcomlig;
	}
	public void setIdcomlig(int idcomlig) {
		this.idcomlig = idcomlig;
	}
	public Date getDatePasse() {
		return datePasse;
	}
	public void setDatePasse(Date datePasse) {
		this.datePasse = datePasse;
	}
	public double getMontantotal() {
		return montantotal;
	}
	public void setMontantotal(double montantotal) {
		this.montantotal = montantotal;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public boolean isPayed() {
		return payed;
	}
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public int getIdchose() {
		return idchose;
	}
	public void setIdchose(int idchose) {
		this.idchose = idchose;
	}
	public void addid(int idchose) {
		this.idchose = idchose;
	}
	public int showid() {
		
		return this.idchose;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
