package ManagedBean;

import java.io.Serializable;



import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Heure;

import model.TypeBoutique;
import model.Ville;

@ManagedBean(name = "data")
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;


public Ville[] getVilles()
{ return Ville.values(); }


public Heure[] getHeures()
{ return Heure.values().clone(); }


public TypeBoutique[] getTypeBoutiques()
{ return TypeBoutique.values(); }



}