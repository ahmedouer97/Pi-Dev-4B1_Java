package ManagedBean;

import java.io.Serializable;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.servlet.http.Part;
import java.io.File;


import Service.NewsletterService;
import model.Newsletter;
import utils.Util;



@ManagedBean(name = "newsletterBean")
@SessionScoped
public class NewsletterBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String description; 
	private String title; 
	private String picture;
	private Part file;
	private Integer idToBeUpdated;
	private List<Newsletter> newsletters;
	@EJB
	NewsletterService newsletterService;
	public void addNewsletter() {
	newsletterService.ajouterNewsletter(new Newsletter(description, title,picture));
	String folderName1 = Util.serverI;
	try {
		uploadimage(folderName1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public NewsletterService getNewsletterService() {
		return newsletterService;
	}
	public void setNewsletterService(NewsletterService newsletterService) {
		this.newsletterService = newsletterService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NewsletterBean(String description, String title, String picture, NewsletterService newsletterService) {
		super();
		this.description = description;
		this.title = title;
		this.picture = picture;
		this.newsletterService = newsletterService;
	}
	public NewsletterBean() {
		super();
	}
	
	public Integer getIdToBeUpdated() {
		return idToBeUpdated;
	}
	public void setIdToBeUpdated(Integer idToBeUpdated) {
		this.idToBeUpdated = idToBeUpdated;
	}
	public void setNewsletters(List<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}
	public List<Newsletter> getNewsletters() {
		newsletters = newsletterService.getAllNewsletters();
		return newsletters;
		}
	public void removeNewsletter(int id)
	{ newsletterService.deleteNewsletterById(id);
	}
	public void modifier(Newsletter newsletter)
	{this.setDescription(newsletter.getDescription());
	this.setTitle(newsletter.getTitle());
	this.setPicture(newsletter.getPicture());
	this.setIdToBeUpdated(newsletter.getId());
	}
	public void mettreAjourNewsletter(){
		newsletterService.updateNewsletter(new Newsletter(idToBeUpdated,description ,title,picture));
		}
	public NewsletterBean(String description, String title, String picture, Integer idToBeUpdated,
			List<Newsletter> newsletters, NewsletterService newsletterService) {
		super();
		this.description = description;
		this.title = title;
		this.picture = picture;
		this.idToBeUpdated = idToBeUpdated;
		this.newsletters = newsletters;
		this.newsletterService = newsletterService;
	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public NewsletterBean(String description, String title, Part file) {
		super();
		this.description = description;
		this.title = title;
		this.file = file;
	}
	 public String uploadimage(String folderName1) throws IOException {
			
			if (file != null) {
			
			InputStream in = file.getInputStream();
			File f = new File(folderName1 + "\\" + file.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			return "succes-image-uplaod?faces-redirect=true";


			}
			else {
				return "succes-image-uplaod?faces-redirect=true";

				
			}
}
	public NewsletterBean(String description, String title, Part file, NewsletterService newsletterService) {
		super();
		this.description = description;
		this.title = title;
		this.file = file;
		this.newsletterService = newsletterService;
	}
	 
}