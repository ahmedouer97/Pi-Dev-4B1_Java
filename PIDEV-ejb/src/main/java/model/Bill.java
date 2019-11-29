package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Bills database table.
 * 
 */
@Entity
@Table(name="Bills")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbill;

	@Column(name="date_created")
	private Date dateCreated;

	@Column(name="date_end")
	private Date dateEnd;
	private boolean payed;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="idcom")
	private Commande commande;

	//bi-directional many-to-one association to CommandeLigne
	@OneToMany(mappedBy="bill")
	private List<CommandeLigne> commandeLignes;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="bill")
	private List<Commande> commandes;

	public Bill() {
	}

	public int getIdbill() {
		return this.idbill;
	}

	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public boolean getPayed() {
		return this.payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<CommandeLigne> getCommandeLignes() {
		return this.commandeLignes;
	}

	public void setCommandeLignes(List<CommandeLigne> commandeLignes) {
		this.commandeLignes = commandeLignes;
	}

	public CommandeLigne addCommandeLigne(CommandeLigne commandeLigne) {
		getCommandeLignes().add(commandeLigne);
		commandeLigne.setBill(this);

		return commandeLigne;
	}

	public CommandeLigne removeCommandeLigne(CommandeLigne commandeLigne) {
		getCommandeLignes().remove(commandeLigne);
		commandeLigne.setBill(null);

		return commandeLigne;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setBill(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setBill(null);

		return commande;
	}

}