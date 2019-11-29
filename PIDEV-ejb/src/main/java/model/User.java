package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to CommandeLigne
	@OneToMany(mappedBy="user")
	private List<CommandeLigne> commandeLignes;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<CommandeLigne> getCommandeLignes() {
		return this.commandeLignes;
	}

	public void setCommandeLignes(List<CommandeLigne> commandeLignes) {
		this.commandeLignes = commandeLignes;
	}

	public CommandeLigne addCommandeLigne(CommandeLigne commandeLigne) {
		getCommandeLignes().add(commandeLigne);
		commandeLigne.setUser(this);

		return commandeLigne;
	}

	public CommandeLigne removeCommandeLigne(CommandeLigne commandeLigne) {
		getCommandeLignes().remove(commandeLigne);
		commandeLigne.setUser(null);

		return commandeLigne;
	}

}