package ManagedBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;

import Service.NewsNoteService;
import Service.NewsService;
import Service.NewsServiceLocal;
import model.News;
import model.NewsNote;

@ManagedBean(name ="NewsBean")
@SessionScoped
public class NewsBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre;
	private String image;
	private String contenue ;
	private String nomAuteur;
	private Date datePublish ;
	private List<News> Newss;
	//private News New ;
	@EJB
	NewsServiceLocal cm;
	@EJB
	NewsService cmm;
	@EJB
	NewsNoteService ns ;
	@EJB
	NewsService gs ;
	public void addNews () {
		cm.addNews(new News(titre,image,contenue,nomAuteur,datePublish));
		
	}
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
	public List<News> getAllNews(){
		Newss = cm.getAllNews();
		return Newss ;	
			
	}
	
	
public void supprimer(Integer Id) {
		
		System.out.println("Deleted");
		
		cm.deleteUser(Id);
	 
	
	}
public String onrate(RateEvent rateEvent,Integer id) {
	NewsNote f = new NewsNote();
	f=ns.findNoteById(id); 
	int n = ((Integer) rateEvent.getRating()).intValue(); 
	int p = f.getNbNote()+1; 
	int x = f.getNoteF();
	int k =(int) n+x/p; 
	System.out.println("f7al"+k);
	f.setNoteF(k); 
	f.setNbNote(p);
	ns.updateNote(f);

	

	String navigTo="Template/Pages/News/ListNews?faces-redirect=true";
	return navigTo;

}

}
