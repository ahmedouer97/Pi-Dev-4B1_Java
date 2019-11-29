package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Commandes database table.
 * 
 */
@Entity
@Table(name="Commandes")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcom;

	private int nbrcom;

	private double prix;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="commande")
	private List<Bill> bills;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(referencedColumnName="idcom")
	private Bill bill;

	public Commande() {
	}

	public int getIdcom() {
		return this.idcom;
	}

	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}

	public int getNbrcom() {
		return this.nbrcom;
	}

	public void setNbrcom(int nbrcom) {
		this.nbrcom = nbrcom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setCommande(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setCommande(null);

		return bill;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}