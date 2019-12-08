package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Message;
import model.User;

@Stateless
@LocalBean
public class MessageService {

	/**
     * Default constructor. 
     */
	@PersistenceContext
    EntityManager em; 
	
	
    public MessageService() {
        // TODO Auto-generated constructor stub
    }
    
    public void add(Message m) {
    	em.persist(m);
    }

    public List<Message> getMessages(User sender, User receiver){
		TypedQuery<Message> query;
		query = em.createQuery("select m from Message m "
				+ "where (m.sender.id=:idSender and m.receiver.id=:idReceiver) "
				+ "or (m.sender.id=:idReceiver and m.receiver.id=:idSender) "
				+ "order by m.idMessage", Message.class);
		query.setParameter("idSender", sender.getIduser());
		query.setParameter("idReceiver", receiver.getIduser());
		
		try {
			return query.getResultList();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
    }
}
