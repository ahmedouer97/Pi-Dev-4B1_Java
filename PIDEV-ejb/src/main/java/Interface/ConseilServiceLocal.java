package Interface;

import java.util.List;

import javax.ejb.Local;

import model.Conseil;

@Local
public interface ConseilServiceLocal {
	
void addConseil(Conseil conseil);
	
	void deleteConseil(Conseil conseil);
	
	Conseil findConseilById(int id);

	

	void deleteConseilById(int id);

	List<Conseil> findAllConseils();

}
