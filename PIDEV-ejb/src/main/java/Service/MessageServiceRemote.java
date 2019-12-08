package Service;

import java.util.List;

import javax.ejb.Remote;

import model.Message;
import model.User;

@Remote
public interface MessageServiceRemote {

	void add(Message m) ;
	List<Message> getMessages(User sender, User receiver) ;
}
