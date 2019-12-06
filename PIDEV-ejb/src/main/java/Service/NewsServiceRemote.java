package Service;

import java.util.List;

import javax.ejb.Remote;

import model.News;

@Remote
public interface NewsServiceRemote {

	List<News> getAllNews();

	int addNews(News news);

}
