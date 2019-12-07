package Interface;

import java.util.List;




import javax.ejb.Remote;


import model.Conseil;

@Remote
public interface ConseilServiceRemote {
	
	void addConseil(Conseil conseil);
	
	void deleteConseil(Conseil conseil);
	
	Conseil findConseilById(int conseilId);

	void updateConseil(Conseil conseil);
		
		
	

	void deleteConseilById(int ConseilId);

	List<Conseil> findAllConseils();
/*	boolean uploadProfileImage(String conseilImagePath);*/
	
	

}
