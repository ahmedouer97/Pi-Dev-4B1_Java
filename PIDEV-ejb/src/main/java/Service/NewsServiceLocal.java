package Service;



import java.util.List;

import javax.ejb.Local;

import model.News;

@Local
public interface NewsServiceLocal {


	void affecterNewsNote(int idN, int idF) ;
	
	void updateNews(News t);	
	
	List<News> getAllNews();

	News getNewsById(int id);

	int addNews(News news);

	void delNews(int id);

	void deleteUser(Integer id);

	//Object getAllNews();

	void ajouterNews(News news);

}
