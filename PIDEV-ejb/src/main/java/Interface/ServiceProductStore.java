package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.Product;
import model.ProductStore;
import model.Store;


@Remote
public interface ServiceProductStore  {

	
	public void addProductStore(int count,Product product,Store store);

	public List<ProductStore> getProductStores();
	
	public List<ProductStore> getStores();

}
