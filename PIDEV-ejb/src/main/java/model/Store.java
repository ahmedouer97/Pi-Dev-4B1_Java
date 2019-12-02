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
	@Enumerated(EnumType.STRING)
	private Heure heureFerm;

	@Column(name="heure_ouv")
	@Enumerated(EnumType.STRING)
	private Heure heureOuv;

	@Column(name="Latitude")
	private BigDecimal latitude;

	@Column(name="Longitude")
	private BigDecimal longitude;

	@Column(name="Nom")
	private String nom;

	private int tel;

	@Enumerated(EnumType.STRING)
	private TypeBoutique type;

	@Column(name="Ville")
	@Enumerated(EnumType.STRING)
	private Ville ville;


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

	
	
	public Heure getHeureFerm() {
		return heureFerm;
	}

	public void setHeureFerm(Heure heureFerm) {
		this.heureFerm = heureFerm;
	}

	public Heure getHeureOuv() {
		return heureOuv;
	}

	public void setHeureOuv(Heure heureOuv) {
		this.heureOuv = heureOuv;
	}

	public TypeBoutique getType() {
		return type;
	}

	public void setType(TypeBoutique type) {
		this.type = type;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
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

	public Store( String nom, Ville ville,String adresse, String description, BigDecimal latitude,
			BigDecimal longitude, int tel, TypeBoutique type , Heure heureOuv,Heure heureFerm) {
		super();
		this.adresse = adresse;
		this.description = description;
		this.heureFerm = heureFerm;
		this.heureOuv = heureOuv;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nom = nom;
		this.tel = tel;
		this.type = type;
		this.ville = ville;
	}
	
	

}