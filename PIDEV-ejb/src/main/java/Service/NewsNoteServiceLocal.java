package Service;

import java.util.List;

import javax.ejb.Local;

import model.NewsNote;

@Local
public interface NewsNoteServiceLocal {
	
	public void ajouterNote (NewsNote f) ;
	public void supprimerNewsNote (int id_note) ;
	public void updateNote (NewsNote n) ;
	public NewsNote findNoteById(int id_note) ;
	 public List <NewsNote> getAllNewsNotes() ;

}
