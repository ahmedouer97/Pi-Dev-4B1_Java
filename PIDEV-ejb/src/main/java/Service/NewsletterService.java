package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.NewsletterServiceRemote;
import model.Newsletter;




@Stateless
@LocalBean
public class NewsletterService implements NewsletterServiceRemote{
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	public void ajouterNewsletter(Newsletter e) {
		em.persist(e);		
	}
	public List<Newsletter> getAllNewsletters() {
		List<Newsletter> emp= em.createQuery("SELECT e FROM Newsletter e", Newsletter.class).getResultList();
		return emp;
	}
	public void deleteNewsletterById(int id) {
		
		Newsletter e = em.find(Newsletter.class, id);
		 em.remove(e);

	}
public void updateNewsletter(Newsletter e) {
		 em.merge(e);

	}
}
