package Service;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.ServiceProduct;
import model.Product;


@Stateless
@LocalBean
public class ServiceProductImpl implements ServiceProduct {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	public String getProductById(int ProductId) {
		Product b = em.find(Product.class, ProductId);
		return b.getNom();
	}

		
						

	
	public List<Product> getAllProducts() {
		List<Product> b = em.createQuery("SELECT s FROM Product s",Product.class).getResultList();
				return b;
	}



}
