package Service;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interface.ServiceStore;
import model.Store;

@Stateless
@LocalBean
public class ServiceStoreImpl implements ServiceStore {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	public int addStore(Store Store) {
		em.persist(Store);
		return Store.getBoutiqueId();
	}

	
	public Store getStoreById(int StoreId) {
		Store b = em.find(Store.class, StoreId);
		return b;
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
		List<Store> b = em.createQuery("SELECT s FROM Store s",Store.class).getResultList();
				return b;
	}

	
	public void modifyStore(Store Store) {
		em.merge(Store);
	}
	


}
