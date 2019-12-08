package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.Product;


@Remote
public interface ServiceProduct  {

	

	public Product getProductById(int ProductId);

	public List<Product> getProductbyId();

	public List<Product> getAllProducts();
	
	

}
