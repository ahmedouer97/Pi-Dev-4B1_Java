package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.News;
import model.NewsNote;
import model.Store;

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
		NewsNote nn = new NewsNote();
		nn.setNews(news);
		em.persist(nn);
		em.persist(news);
		
	return news.getId();
		
	}
	
	@Override
	public void delNews(int id) {
	/*	System.out.println(" Delete with Succes");
	News news = em.find(News.class, id);
	if (news != null)
	{ em.remove(news);
	return true ;
	}
	return false;*/
		News e = em.find(News.class,id);
		em.remove(e);
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
		
		
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		News e = em.find(News.class,id);
		em.remove(e);
		
	}

	@Override
	public void ajouterNews(News news) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void affecterNewsNote(int idN, int idF) {
		NewsNote n = em.find(NewsNote.class, idN);
		News f = em.find(News.class, idF);
		n.setNews(f);
	}


	

}
