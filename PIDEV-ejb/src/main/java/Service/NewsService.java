package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.News;

/**
 * Session Bean implementation class NewsService
 */
@Stateless
@LocalBean
public class NewsService implements NewsServiceRemote, NewsServiceLocal {

    /**
     * Default constructor. 
     */
    public NewsService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "pidev-ejb")
	private EntityManager em;
	
	
	
	
    @Override
	public int addNews(News news) {
		
		em.persist(news);
		
	return news.getId();
		
	}
	
	@Override
	public Boolean delNews(int id) {
		System.out.println(" Delete with Succes");
	News news = em.find(News.class, id);
	if (news != null)
	{ em.remove(news);
	return true ;
	}
	return false;
	}
	
	
	@Override
	public List<News> getAllNews() {
		TypedQuery<News> query;
		
		query=em.createQuery("SELECT e FROM News e",News.class);
		List<News> Newss = query.getResultList();
		return Newss;
		 
		
		
	}

	@Override
	public void updateNews(News t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterNews(News news) {
		// TODO Auto-generated method stub
		
	}


	

}
