package Interface;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Service.ServiceStore;
import model.Store;

@Stateless
@LocalBean
public class ServiceStoreImpl implements ServiceStore {

	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	@Override
	public int addStore(Store Store) {
		em.persist(Store);
		return Store.getBoutiqueId();
	}

	
	public String getStoreById(int StoreId) {
		Store b = em.find(Store.class, StoreId);
		return b.getNom();
	}

	
	public void deleteStoreById(int StoreId) {
		Store e = em.find(Store.class,StoreId);
		em.remove(e);
	}

	
	public long getNombreStoreJPQL() {
		TypedQuery<Long> query = em.createQuery("select count(e) from Store e", Long.class);
		return query.getSingleResult();
	}

	
	public List<Store> getStorebyVille(String ville) {
		TypedQuery <Store> query = em.createQuery("select e from Store e where e.ville=:ville ", Store.class);
		query.setParameter("ville", ville);
		return query.getResultList();

		
				
						
	}

	
	public List<Store> getStorebyType(String type) {
		TypedQuery <Store> query = em.createQuery("select e from Store e where e.type=:type ", Store.class);
		query.setParameter("type", type);
		return query.getResultList();

		
				
						
	}

	
	public List<Store> getAllStores() {
		List<Store> b = em.createQuery("Select e from Store e",
				Store.class).getResultList();
				return b;
	}



}
