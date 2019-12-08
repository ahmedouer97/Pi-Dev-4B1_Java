package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.NewsNote;

@Stateless
@LocalBean
public class NewsNoteService implements NewsNoteServiceRemote, NewsNoteServiceLocal {

	@PersistenceContext
	EntityManager em;
	@Override
	public void ajouterNote(NewsNote f) {
		// TODO Auto-generated method stub
		em.persist(f);
		System.out.println("1"+"ajout avec succes");
	}

	@Override
	public void supprimerNewsNote(int id_note) {
		// TODO Auto-generated method stub
		NewsNote f = em.find(NewsNote.class, id_note);
		System.out.println("2"+f);
		em.remove(f);
	}

	@Override
	public void updateNote(NewsNote n) {
		// TODO Auto-generated method stub
		em.merge(n);
	}

	@Override
	public NewsNote findNoteById(int id_note) {
		return em.find(NewsNote.class, id_note);
	}

	@Override
	public List<NewsNote> getAllNewsNotes() {
		// TODO Auto-generated method stub
		TypedQuery<NewsNote> query = em.createQuery("SELECT f FROM NewsNote f",NewsNote.class);  
	 	   try {
	 		 return query.getResultList();
	 	   }
	 	   catch (Exception e){
	 		   System.out.println("erreur");	   
	 	   }
	 	   return null;
	}
	 public NewsNoteService() {
	        // TODO Auto-generated constructor stub
	    }
	

}
