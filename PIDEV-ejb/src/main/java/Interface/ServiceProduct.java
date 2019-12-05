package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.Product;


@Remote
public interface ServiceProduct  {

	

	public String getProductById(int ProductId);



	public List<Product> getAllProducts();

}
