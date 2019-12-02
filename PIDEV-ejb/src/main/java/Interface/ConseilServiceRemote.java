package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.Conseil;

@Remote
public interface ConseilServiceRemote {
	
	void addConseil(Conseil conseil);
	
	void deleteConseil(Conseil conseil);
	
	Conseil findConseilById(int id);

	void updateConseil(Conseil conseil);

	void deleteConseilById(int id);

	List<Conseil> findAllConseils();

}
