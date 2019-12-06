package Service;



import javax.ejb.Local;

import model.News;

@Local
public interface NewsServiceLocal {



	void updateNews(News t);	

	News getNewsById(int id);

	int addNews(News news);

	Boolean delNews(int id);

	void deleteUser(Integer id);

	Object getAllNews();

	void ajouterNews(News news);

}
