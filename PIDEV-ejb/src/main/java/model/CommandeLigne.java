package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the CommandeLignes database table.
 * 
 */
@Entity
@Table(name="CommandeLignes")
@NamedQuery(name="CommandeLigne.findAll", query="SELECT c FROM CommandeLigne c")
public class CommandeLigne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcomlig;

	@Column(name="date_passe")
	private Date datePasse;

	private double montantotal;

	private boolean passed;

	private boolean payed;

	private int quantité;

	private int review;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="idbill")
	private Bill bill;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ProduitId")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	@ManyToOne
	@JoinColumn(name="iddelivery")
	Delivery delivery; 
	public CommandeLigne() {
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public int getIdcomlig() {
		return this.idcomlig;
	}

	public void setIdcomlig(int idcomlig) {
		this.idcomlig = idcomlig;
	}

	public Date getDatePasse() {
		return this.datePasse;
	}

	public void setDatePasse(Date datePasse) {
		this.datePasse = datePasse;
	}

	public double getMontantotal() {
		return this.montantotal;
	}

	public void setMontantotal(double montantotal) {
		this.montantotal = montantotal;
	}

	public boolean getPassed() {
		return this.passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public boolean getPayed() {
		return this.payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public int getQuantité() {
		return this.quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	public int getReview() {
		return this.review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}