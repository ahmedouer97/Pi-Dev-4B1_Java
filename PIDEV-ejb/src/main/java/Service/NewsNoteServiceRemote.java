package Service;

import java.util.List;

import javax.ejb.Remote;

import model.NewsNote;

@Remote
public interface NewsNoteServiceRemote {

	public void ajouterNote (NewsNote f) ;
	public void supprimerNewsNote (int id_note) ;
	public void updateNote (NewsNote n) ;
	public NewsNote findNoteById(int id_note) ;
	 public List <NewsNote> getAllNewsNotes() ;
}
