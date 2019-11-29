package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductStores database table.
 * 
 */
@Embeddable
public class ProductStorePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProduitId", insertable=false, updatable=false)
	private int produitId;

	@Column(name="BoutiqueId", insertable=false, updatable=false)
	private int boutiqueId;

	public ProductStorePK() {
	}
	public int getProduitId() {
		return this.produitId;
	}
	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}
	public int getBoutiqueId() {
		return this.boutiqueId;
	}
	public void setBoutiqueId(int boutiqueId) {
		this.boutiqueId = boutiqueId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductStorePK)) {
			return false;
		}
		ProductStorePK castOther = (ProductStorePK)other;
		return 
			(this.produitId == castOther.produitId)
			&& (this.boutiqueId == castOther.boutiqueId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.produitId;
		hash = hash * prime + this.boutiqueId;
		
		return hash;
	}
}