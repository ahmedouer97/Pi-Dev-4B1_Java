package ManagedBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Interface.ServiceStore;
import model.Heure;
import model.Store;
import model.TypeBoutique;
import model.Ville;

@ManagedBean(name = "StoreBean")
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

private List<Store> stores;

@EJB
ServiceStore ServiceStore;

public void addStore() {
	ServiceStore.addStore(new Store(nom,ville,adresse,description,latitude,
longitude, tel,  type , heureFerm,  heureOuv)  );
}
public List<Store> getAllStores() {
stores = ServiceStore.getAllStores();
return stores;
}

public void removeStore(Integer employeId)
{ ServiceStore.deleteStoreById(employeId);
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




}
