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

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductStorePK other = (ProductStorePK) obj;
		if (boutiqueId != other.boutiqueId)
			return false;
		if (produitId != other.produitId)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boutiqueId;
		result = prime * result + produitId;
		return result;
	}
	public ProductStorePK(int produitId, int boutiqueId) {
		super();
		this.produitId = produitId;
		this.boutiqueId = boutiqueId;
	}
	
	
	
}