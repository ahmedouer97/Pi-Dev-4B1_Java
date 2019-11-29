package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Packs database table.
 * 
 */
@Entity
@Table(name="Packs")
@NamedQuery(name="Pack.findAll", query="SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int packId;

	private int quantity;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	@JoinColumn(name="OfferId")
	private Offer offer;

	//bi-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="PackId", referencedColumnName="PackId")
	private Promotion promotion;

	//bi-directional many-to-one association to Promotion
	@OneToMany(mappedBy="pack")
	private List<Promotion> promotions;

	public Pack() {
	}

	public int getPackId() {
		return this.packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public Promotion addPromotion(Promotion promotion) {
		getPromotions().add(promotion);
		promotion.setPack(this);

		return promotion;
	}

	public Promotion removePromotion(Promotion promotion) {
		getPromotions().remove(promotion);
		promotion.setPack(null);

		return promotion;
	}

}