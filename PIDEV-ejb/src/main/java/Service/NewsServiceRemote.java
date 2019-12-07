package Service;

import java.util.List;

import javax.ejb.Remote;

import model.News;

@Remote
public interface NewsServiceRemote {

void updateNews(News t);	
	
	List<News> getAllNews();

	News getNewsById(int id);

	int addNews(News news);

	void delNews(int id);

	void deleteUser(Integer id);

	//Object getAllNews();

	void ajouterNews(News news);

}
