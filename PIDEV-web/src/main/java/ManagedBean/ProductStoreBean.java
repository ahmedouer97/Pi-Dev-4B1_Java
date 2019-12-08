package ManagedBean;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EmbeddedId;

import Interface.ServiceProduct;
import Interface.ServiceProductStore;
import Interface.ServiceStore;
import model.Product;
import model.ProductStore;
import model.ProductStorePK;
import model.Store;
@ManagedBean(name="productStoreBean")
@SessionScoped
public class ProductStoreBean {

	@EmbeddedId
	private ProductStorePK id;

	private int count;
	
	Integer selectedProductID;
	Integer selectedStoreID;
	
	Product product;
	Store store;
	
	List<Product> Products;
	List<Store> Stores;
	List<ProductStore> ProductStores;
	@EJB
	ServiceProduct serviceproduct;
	@EJB
	ServiceStore servicestore;
	@EJB
	ServiceProductStore serviceproductstore;
	
	
	
	public List<Store> getAllStores() {
		Stores = servicestore.getAllStores();
		System.out.println(Stores);
		return Stores;
		}
	
	public List<Product> getAllProducts() {
		Products = serviceproduct.getAllProducts();
		System.out.println(Products);
		return Products;
		}
	
	public List<ProductStore> getStoresBYProduct() {
		ProductStores = serviceproductstore.getStores();
		System.out.println(ProductStores);
		return ProductStores;
		}
	
	
	
	
	public ProductStorePK getId() {
		return id;
	}
	public void setId(ProductStorePK id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Integer getSelectedProductID() {
		return selectedProductID;
	}
	public void setSelectedProductID(Integer selectedProductID) {
		this.selectedProductID = selectedProductID;
	}
	public Integer getSelectedStoreID() {
		return selectedStoreID;
	}
	public void setSelectedStoreID(Integer selectedStoreID) {
		this.selectedStoreID = selectedStoreID;
	}
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> products) {
		Products = products;
	}
	public List<Store> getStores() {
		return Stores;
	}
	public void setStores(List<Store> stores) {
		Stores = stores;
	}
	public List<ProductStore> getProductStores() {
		return ProductStores;
	}
	public void setProductStores(List<ProductStore> productStores) {
		ProductStores = productStores;
	}
	public ServiceProduct getServiceproduct() {
		return serviceproduct;
	}
	public void setServiceproduct(ServiceProduct serviceproduct) {
		this.serviceproduct = serviceproduct;
	}
	public ServiceStore getServicestore() {
		return servicestore;
	}
	public void setServicestore(ServiceStore servicestore) {
		this.servicestore = servicestore;
	}
	public ServiceProductStore getServiceproductstore() {
		return serviceproductstore;
	}
	public void setServiceproductstore(ServiceProductStore serviceproductstore) {
		this.serviceproductstore = serviceproductstore;
	}
	
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}


	public void addProductStore() {
	
	
		serviceproductstore.addProductStore(count, serviceproduct.getProductById(selectedProductID), servicestore.getStoreById(selectedStoreID));
		
		FacesContext.getCurrentInstance().addMessage("formficheeval:btn", new FacesMessage("product store Succefully Added"));
		//navigateTo="/pages/mangeEvaluation?faces-redirect=true";	
		//navigateTo="****************************************************aaaat";		

		
	}
	
}
