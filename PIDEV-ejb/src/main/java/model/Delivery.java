package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddel;
	private String name;
	private String lastname;
	private String location;
	@OneToMany(mappedBy="delivery",fetch=FetchType.EAGER)
	private List<CommandeLigne> commandelignes;
	public Delivery() {
		super();
	}
	
	public Delivery(String name, String lastname, String location) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.location = location;
	}

	public Delivery(int iddel, String name, String lastname, String location) {
		super();
		this.iddel = iddel;
		this.name = name;
		this.lastname = lastname;
		this.location = location;
	}

	public int getIddel() {
		return iddel;
	}
	public void setIddel(int iddel) {
		this.iddel = iddel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<CommandeLigne> getCommandeLignes() {
		return commandelignes;
	}
	public void setCommandeLignes(List<CommandeLigne> commandeLignes) {
		this.commandelignes = commandeLignes;
	}
	
}
