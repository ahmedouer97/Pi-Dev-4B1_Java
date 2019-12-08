package Service;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Offre;
import Interface.OffreServiceRemote;
@Stateless
@LocalBean
public class OffreService implements OffreServiceRemote  {
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	public long getNombredevJPQL() {
		
		  TypedQuery<Long> query = em.createQuery(
			   "SELECT COUNT(s) FROM Offre s where s.description like'offre'", Long.class);
			  long results =query.getSingleResult();
			  return results;
	}


	
	public long getNombrefinJPQL() {
		 TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offre s where s.description like'produit'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}


	
	public long getNombrecompJPQL() {
		 TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offre s where s.description like'service'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}


	
	public long getNombredsJPQL() {
		 TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offre s where s.description like'ligne'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}


	
	public long getPoureRequestJPQL() {
		System.out.println(em);
		Query query=em.createQuery("SELECT COUNT(e) FROM Offre e");	
		long n=	(long)query.getSingleResult();
		return n;
	}
	public List<Offre> getAllOffres() {
		List<Offre> emp= em.createQuery("SELECT e FROM Offre e", Offre.class).getResultList();
		return emp;
	}
}
