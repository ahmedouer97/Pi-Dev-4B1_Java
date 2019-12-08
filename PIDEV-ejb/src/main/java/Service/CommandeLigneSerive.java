package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.CommandeligneService;
import model.CommandeLigne;
@Stateless
@LocalBean
public class CommandeLigneSerive implements CommandeligneService {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	public int addcomlig(CommandeLigne comm) {
		System.out.println("In adddev : ");
		em.persist(comm);
		System.out.println("Out of adddev" + comm.getIdcomlig());
		return comm.getIdcomlig();
	}

	
	public void removecomlig(int id) {
		System.out.println("In remove : ");
		em.remove(em.find(CommandeLigne.class, id));
		System.out.println("Out of remove : ");

	}

	
	public void updatecomlig(CommandeLigne comm) {
		em.merge(comm);

	}

	
	public CommandeLigne findcomligById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<CommandeLigne> findAllcomlig() {
		// TODO Auto-generated method stub
		return em.createQuery("from CommandeLigne",
				CommandeLigne.class).getResultList();
	}

}
