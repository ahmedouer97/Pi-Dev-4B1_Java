package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Products database table.
 * 
 */
@Entity
@Table(name="Products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProduitId")
	private int produitId;

	@Column(name="Brand")
	private String brand;

	@Column(name="Category")
	private String category;

	@Column(name="Description")
	private String description;

	@Column(name="Image")
	private String image;

	@Column(name="Network")
	private String network;

	@Column(name="Nom")
	private String nom;

	@Column(name="Prix")
	private double prix;

	@Column(name="Quantite")
	private int quantite;

	//bi-directional many-to-one association to CommandeLigne
	@OneToMany(mappedBy="product")
	private List<CommandeLigne> commandeLignes;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="product")
	private List<Offer> offers;

	//bi-directional many-to-one association to ProductStore
	@OneToMany(mappedBy="product")
	private List<ProductStore> productStores;

	

	public Product() {
	}

	public int getProduitId() {
		return this.produitId;
	}

	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNetwork() {
		return this.network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public List<CommandeLigne> getCommandeLignes() {
		return this.commandeLignes;
	}

	public void setCommandeLignes(List<CommandeLigne> commandeLignes) {
		this.commandeLignes = commandeLignes;
	}

	public CommandeLigne addCommandeLigne(CommandeLigne commandeLigne) {
		getCommandeLignes().add(commandeLigne);
		commandeLigne.setProduct(this);

		return commandeLigne;
	}

	public CommandeLigne removeCommandeLigne(CommandeLigne commandeLigne) {
		getCommandeLignes().remove(commandeLigne);
		commandeLigne.setProduct(null);

		return commandeLigne;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setProduct(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setProduct(null);

		return offer;
	}



	
}