package Service;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interface.ServiceProductStore;
import model.Product;
import model.ProductStore;
import model.ProductStorePK;
import model.Store;

@Stateless
@LocalBean
public class ServiceProductStoreImpl implements ServiceProductStore {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public void addProductStore(int count, Product product, Store store) {
		ProductStorePK ProductStorePK=new ProductStorePK(product.getProduitId(),store.getBoutiqueId());
		
		ProductStore ProductStore=new ProductStore();
		ProductStore.setId(ProductStorePK);
		
		ProductStore.setCount(count);
		
		System.out.println("add productstore");
		em.persist(ProductStore);	
	}

	@Override
	public List<ProductStore> getProductStores() {
		TypedQuery<ProductStore> query = em.createQuery("Select e from ProductStore e", ProductStore.class);
		List<ProductStore> result = query.getResultList();
		return result;
	}
	
	
	public List<ProductStore> getStores()
	{
		TypedQuery<ProductStore> query = em.createQuery("Select e from ProductStore e where e.id.produitId=:produitId", ProductStore.class);
		query.setParameter("produitId", 1);
		return query.getResultList();

	}



}
