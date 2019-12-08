package ManagedBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Interface.ServiceStore;
import model.Heure;
import model.Store;
import model.TypeBoutique;
import model.Ville;

@ManagedBean(name = "storeBean") 	
@SessionScoped
public class StoreBean implements Serializable {
private static final long serialVersionUID = 1L;
private int boutiqueId;
private String nom;
private Ville ville;
private String adresse;
private BigDecimal latitude;
private BigDecimal longitude;
private String description;
private TypeBoutique type;
private Heure heureFerm;
private Heure heureOuv;
private int tel;
private int updateid;

private List<Store> filteredStore;

private List<Store> stores;

@EJB
ServiceStore ServiceStore;

public void addStore() {
	ServiceStore.addStore(new Store(nom,ville,adresse,description,latitude,
longitude, tel,  type ,heureOuv, heureFerm  )  );
}
public List<Store> getAllStores() {
stores = ServiceStore.getAllStores();
System.out.println(stores);
return stores;
}

public void removeStore(Integer boutiqueId)
{ ServiceStore.deleteStoreById(boutiqueId);
}

// modify

public void modifyStore(Store Store) {
	this.setNom(Store.getNom());
	this.setVille(Store.getVille());
	this.setAdresse(Store.getAdresse());
	this.setLatitude(Store.getLatitude());
	this.setLongitude(Store.getLongitude());
	this.setDescription(Store.getDescription());
	this.setTel(Store.getTel());
	this.setHeureOuv(Store.getHeureOuv());
	this.setHeureFerm(Store.getHeureFerm());
	this.setUpdateid(Store.getBoutiqueId());
}
public void updateStore() {
	
	ServiceStore.modifyStore(new Store(updateid,nom,ville,adresse,description,latitude,
			longitude, tel,  type ,heureOuv, heureFerm  ) );
}



public int getBoutiqueId() {
	return boutiqueId;
}
public void setBoutiqueId(int boutiqueId) {
	this.boutiqueId = boutiqueId;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Ville getVille() {
	return ville;
}
public void setVille(Ville ville) {
	this.ville = ville;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public BigDecimal getLatitude() {
	return latitude;
}
public void setLatitude(BigDecimal latitude) {
	this.latitude = latitude;
}
public BigDecimal getLongitude() {
	return longitude;
}
public void setLongitude(BigDecimal longitude) {
	this.longitude = longitude;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public TypeBoutique getType() {
	return type;
}
public void setType(TypeBoutique type) {
	this.type = type;
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
public int getTel() {
	return tel;
}
public void setTel(int tel) {
	this.tel = tel;
}
public List<Store> getStores() {
	return stores;
}
public void setStores(List<Store> stores) {
	this.stores = stores;
}
public ServiceStore getServiceStore() {
	return ServiceStore;
}
public void setServiceStore(ServiceStore serviceStore) {
	ServiceStore = serviceStore;
}

public int getUpdateid() {
	return updateid;
}
public void setUpdateid(int updateid) {
	this.updateid = updateid;
}
public List<Store> getFilteredStore() {
	return filteredStore;
}
public void setFilteredStore(List<Store> filteredStore) {
	this.filteredStore = filteredStore;
}

///////////////////////////////////////////////////

private int getInteger(String string) {
    try {
        return Integer.valueOf(string);
    }
    catch (NumberFormatException ex) {
        return 0;
    }
}


public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
    if (filterText == null || filterText.equals("")) {
        return true;
    }
    int filterInt = getInteger(filterText);

    Store store = (Store) value;
    return store.getNom().toLowerCase().contains(filterText)
            || store.getAdresse().toLowerCase().contains(filterText)
            || store.getType().toString().toLowerCase().contains(filterText)
            ||store.getVille().toString().toLowerCase().contains(filterText)
            || store.getDescription().toLowerCase().contains(filterText);
}


}
