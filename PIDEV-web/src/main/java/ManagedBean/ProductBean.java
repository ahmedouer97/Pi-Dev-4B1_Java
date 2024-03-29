package ManagedBean;

import java.io.Serializable;


import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Interface.ServiceProduct;
import model.Product;


@ManagedBean(name = "productBean") 	
@SessionScoped
public class ProductBean implements Serializable {
private static final long serialVersionUID = 1L;

private int produitId;

private String brand;

private String category;

private String description;

private String image;

private String network;


private String nom;

private double prix;


private int quantite;
private int selectedproduct;

private List<Product> products;
private List<Product> productt;

@EJB
ServiceProduct ServiceProduct;


public List<Product> getAllProducts() {
	products = ServiceProduct.getAllProducts();
System.out.println(products);
return products;
}

public List<Product> getProductbyId( ) {
	/*FacesContext fc = FacesContext.getCurrentInstance();
    Map<String,String> params = 
       fc.getExternalContext().getRequestParameterMap();
    data =  params.get("nom");*/ 
	productt = ServiceProduct.getProductbyId();

return productt;
}



public int getProduitId() {
	return produitId;
}

public void setProduitId(int produitId) {
	this.produitId = produitId;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getNetwork() {
	return network;
}

public void setNetwork(String network) {
	this.network = network;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public double getPrix() {
	return prix;
}

public void setPrix(double prix) {
	this.prix = prix;
}

public int getQuantite() {
	return quantite;
}

public void setQuantite(int quantite) {
	this.quantite = quantite;
}


public List<Product> getProducts() {
	return products;
}



public void setProducts(List<Product> products) {
	this.products = products;
}



public ServiceProduct getServiceProduct() {
	return ServiceProduct;
}

public void setServiceProduct(ServiceProduct serviceProduct) {
	ServiceProduct = serviceProduct;
}

public int getSelectedproduct() {
	return selectedproduct;
}

public void setSelectedproduct(int selectedproduct) {
	this.selectedproduct = selectedproduct;
}

public List<Product> getProductt() {
	return productt;
}

public void setProductt(List<Product> productt) {
	this.productt = productt;
}






}
