package Service;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interface.ServiceProduct;
import model.Product;


@Stateless
@LocalBean
public class ServiceProductImpl implements ServiceProduct {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	public Product getProductById(int ProductId) {
		Product b = em.find(Product.class, ProductId);
		return b;
	}

	public List<Product> getProductbyId() {
		TypedQuery <Product> query = em.createQuery("select e from Product e where e.produitId=:produitId ", Product.class);
		query.setParameter("produitId", 1);
		return query.getResultList();

		
				
						
	}
						

	
	public List<Product> getAllProducts() {
		List<Product> b = em.createQuery("SELECT s FROM Product s",Product.class).getResultList();
				return b;
	}



}
