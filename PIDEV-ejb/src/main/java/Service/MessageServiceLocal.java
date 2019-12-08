package Service;

import java.util.List;

import javax.ejb.Local;

import model.Message;
import model.User;

@Local
public interface MessageServiceLocal {

	void add(Message m) ;
	List<Message> getMessages(User sender, User receiver) ;
	
}
