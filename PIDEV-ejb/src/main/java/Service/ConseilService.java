package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.ConseilServiceLocal;
import Interface.ConseilServiceRemote;
import model.Conseil;



@Stateless
public class ConseilService implements ConseilServiceLocal, ConseilServiceRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
    public ConseilService() {
        
    }
    
	@Override
	public void addConseil(Conseil conseil) {
		entityManager.persist(conseil);
		System.out.println("bbb");
		
	}

	@Override
	public void deleteConseil(Conseil conseil) {
		entityManager.remove(entityManager.merge(conseil));	
		
	}

	@Override
	public Conseil findConseilById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateConseil(Conseil conseil) {
		entityManager.merge(conseil);
		
	}

	@Override
	public void deleteConseilById(int id) {
		entityManager.remove(findConseilById(id));
		
	}

	@Override
	

	public List<Conseil> findAllConseils() {
		List<Conseil> emp = entityManager.createQuery("Select e from Employes e",
				Conseil.class).getResultList();
				return emp;
		
	}

}
