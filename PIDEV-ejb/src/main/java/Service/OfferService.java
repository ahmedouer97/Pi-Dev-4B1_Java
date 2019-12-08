package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Offer;
import Interface.OfferServiceRemote;

@Stateless
@LocalBean
public class OfferService implements OfferServiceRemote  {
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	public long getNombredevJPQL() {
		TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offer s where s.description like'offre'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}

	public long getPoureRequestJPQL() {
		TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offer s where s.description like'produit'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}

	public long getNombredsJPQL() {
		TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offer s where s.description like'service'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}

	public long getNombrecompJPQL() {
		TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offer s where s.description like'ligne'", Long.class);
				  long results =query.getSingleResult();
				  return results;
	}

	public long getNombrefinJPQL() {
		TypedQuery<Long> query = em.createQuery(
				   "SELECT COUNT(s) FROM Offer s where s ", Long.class);
				  long results =query.getSingleResult();
				  return results;	}


}
