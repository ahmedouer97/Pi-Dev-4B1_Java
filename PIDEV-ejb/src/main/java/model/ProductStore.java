package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ProductStores database table.
 * 
 */
@Entity
@Table(name="ProductStores")
@NamedQuery(name="ProductStore.findAll", query="SELECT p FROM ProductStore p")
public class ProductStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductStorePK id;

	private int count;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ProduitId", insertable=false, updatable=false)
	private Product product;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="BoutiqueId" , insertable=false, updatable=false)
	private Store store;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productStore")
	private List<Product> products;

	public ProductStore() {
	}

	public ProductStorePK getId() {
		return this.id;
	}

	public void setId(ProductStorePK id) {
		this.id = id;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductStore(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductStore(null);

		return product;
	}

}