package ManagedBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.validation.constraints.Size;

import Service.ConseilService;
import model.Conseil;





@ManagedBean(name="conseilBean")
@SessionScoped
public class ConseilBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int conseilId;
	private String Title;
	private String description;
	private String conseilImagePath;
	private Date ConseilDate;
	private List<Conseil> conseils;
	private Conseil conseil;
	private static int conseilIdToBeUpdated;
	 private Part file;
	
	@EJB
	ConseilService conseilService;
	/****************************************************************************************/
	
	public String Ajouter () throws IOException {
		
		
        InputStream input=file.getInputStream();
        String namefile = file.getSubmittedFileName().substring(33);
        File f=new File("C:\\Users\\SHAYMA\\Desktop\\upload\\"+namefile);
        System.out.println("hhhhhhhhhhhhhhhhhhhhhh"    +namefile);
        
        if(!f.exists()){
            f.createNewFile();
        }
        

 
 System.out.println("path.iile"+namefile);
 String conseilImagePath= "C:\\Users\\SHAYMA\\Desktop\\upload"+namefile;
	 System.out.println("pathfiiiiiile"+conseilImagePath);

	 conseilService.addConseil(new Conseil(conseilId,Title,description,conseilImagePath,ConseilDate));


 FileOutputStream output=new FileOutputStream(f);
 byte[] buffer=new byte[1024];
 int length;
 while((length=input.read(buffer))>0){
     output.write(buffer, 0, length);
 }
 
 input.close();
 output.close();
 

 
 FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("add succes"));
	
	return "welcome?faces-redirect=true";
}


	public List<Conseil> getConseils() {
		conseils = conseilService.findAllConseils();
		return conseils;
		}
	
	public String removeConseil(int conseilId)
	{ conseilService.deleteConseilById(conseilId);
	return "welcome?faces-redirect=true";
	}
	
	public void Afficher() {
		conseilService.findAllConseils();
	}
	
	public String modifier(Conseil conseil)
	{this.setTitle(conseil.getTitle());
	 this.setDescription(conseil.getDescription());
	 this.setConseilImagePath(conseil.getConseilImagePath());
	 this.conseilIdToBeUpdated=conseil.getConseilId();
	 return "modifierConseil?faces-redirect=true";
	
	}

	public String mettreAjourConseil() throws IOException{
		
		
		 InputStream input=file.getInputStream();
	        String namefile = file.getSubmittedFileName().substring(33);
	        File f=new File("C:\\Users\\SHAYMA\\Desktop\\upload\\"+namefile);
	        System.out.println("hhhhhhhhhhhhhhhhhhhhhh"    +namefile);
	        
	        if(!f.exists()){
	            f.createNewFile();
	        }
	        

	 
	 System.out.println("path.iile"+namefile);
	 String conseilImagePath= "C:\\Users\\SHAYMA\\Desktop\\upload"+namefile;
		 System.out.println("pathfiiiiiile"+conseilImagePath);
		
		conseilService.updateConseil(new Conseil(this.getConseilIdToBeUpdated(),Title,description,conseilImagePath,ConseilDate));
		
		 FileOutputStream output=new FileOutputStream(f);
	        byte[] buffer=new byte[1024];
	        int length;
	        while((length=input.read(buffer))>0){
	            output.write(buffer, 0, length);
	        }
	        
	        input.close();
	        output.close();
	        return "welcome?faces-redirect=true";
		}
	
	public String addConseil()
	{
	return "ajoutConseil?faces-redirect=true";}
	

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
	public void setConseilImagePath(String string) {
		this.conseilImagePath = string;
	}
	public void setConseils(List<Conseil> conseils) {
		this.conseils = conseils;
	}


	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	

}
