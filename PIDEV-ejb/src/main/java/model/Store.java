package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the Stores database table.
 * 
 */
@Entity
@Table(name="Stores")
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BoutiqueId")
	private int boutiqueId;

	@Column(name="Adresse")
	private String adresse;

	@Column(name="Description")
	private String description;

	@Column(name="heure_ferm")
	private String heureFerm;

	@Column(name="heure_ouv")
	private String heureOuv;

	@Column(name="Latitude")
	private BigDecimal latitude;

	@Column(name="Longitude")
	private BigDecimal longitude;

	@Column(name="Nom")
	private String nom;

	private int tel;

	private String type;

	@Column(name="Ville")
	private String ville;

	//bi-directional many-to-one association to ProductStore
	@OneToMany(mappedBy="store")
	private List<ProductStore> productStores;

	public Store() {
	}

	public int getBoutiqueId() {
		return this.boutiqueId;
	}

	public void setBoutiqueId(int boutiqueId) {
		this.boutiqueId = boutiqueId;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeureFerm() {
		return this.heureFerm;
	}

	public void setHeureFerm(String heureFerm) {
		this.heureFerm = heureFerm;
	}

	public String getHeureOuv() {
		return this.heureOuv;
	}

	public void setHeureOuv(String heureOuv) {
		this.heureOuv = heureOuv;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<ProductStore> getProductStores() {
		return this.productStores;
	}

	public void setProductStores(List<ProductStore> productStores) {
		this.productStores = productStores;
	}

	public ProductStore addProductStore(ProductStore productStore) {
		getProductStores().add(productStore);
		productStore.setStore(this);

		return productStore;
	}

	public ProductStore removeProductStore(ProductStore productStore) {
		getProductStores().remove(productStore);
		productStore.setStore(null);

		return productStore;
	}

}