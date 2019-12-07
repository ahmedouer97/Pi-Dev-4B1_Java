/*package Service;

import java.util.Date;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
//import javax.ejb.Stateless;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import Interface.ConseilServiceRemote;
import model.Conseil;



@Stateless
@LocalBean
public class ConseilService implements ConseilServiceRemote {

	@PersistenceContext(name="pidev-ejb")
	private EntityManager entityManager;
	
	
	
    public ConseilService() {
        
    }
    
	@Override
	
	public void addConseil(Conseil conseil) {
		Date conseilDate = new Date();
		Conseil cons = new Conseil(conseil.getConseilId(),conseil.getTitle(),conseil.getDescription(),conseilDate);
		entityManager.persist(cons);
		entityManager.flush();
		
	}

	@Override
	public void deleteConseil(Conseil conseil) {
		entityManager.remove(entityManager.merge(conseil));	
		
	}

	@Override
	public Conseil findConseilById(int conseilId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void deleteConseilById(int ConseilId) {
		Conseil c = entityManager.find(Conseil.class,ConseilId);
		entityManager.remove(c);
		
	}

	@Override
	

	public List<Conseil> findAllConseils() {
		List<Conseil> emp = entityManager.createQuery("Select e from Conseil e",
				Conseil.class).getResultList();
				return emp;
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void updateConseil(Conseil conseil) {
		entityManager.merge(conseil);
		
	}



	


	
	

	
	
	
	
	

}*/
