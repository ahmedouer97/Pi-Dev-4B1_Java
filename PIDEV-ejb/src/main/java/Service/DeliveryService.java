package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.Deliveryinter;
import model.Delivery;
@Stateless
@LocalBean
public class DeliveryService implements Deliveryinter{
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	public int addDelivery(Delivery dev) {
		System.out.println("In adddev : ");
		em.persist(dev);
		System.out.println("Out of adddev" + dev.getIddel());
		return dev.getIddel();
	}

	@Override
	public void removeDelivery(int id) {
		System.out.println("In remove : ");
		em.remove(em.find(Delivery.class, id));
		System.out.println("Out of remove : ");
		
	}

	@Override
	public void updateDelivery(Delivery dev) {
		em.merge(dev);
		
	}

	@Override
	public Delivery findDeliveryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Delivery> findAllDelivery() {
		
		return em.createQuery("from Delivery",
				Delivery.class).getResultList();
	}

}
