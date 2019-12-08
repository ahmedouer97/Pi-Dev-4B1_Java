package managedbeans.ahmed;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Service.DeliveryService;
import model.Delivery;


@ManagedBean(name="DeliveryBean")
@SessionScoped
public class DeliveryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int iddel;
	private String name;
	private String lastname;
	private String location;
	private Integer iddelup;
	private List<Delivery> deliverys;
	@EJB
	DeliveryService delsev;
	public void adddelevry() {
		delsev.addDelivery(new Delivery(name,lastname,location));
		}
	
	public void remdelevry(int id) {
		delsev.removeDelivery(id);
		}
	public void modifier(Delivery dev) {
		this.setLastname(dev.getLastname());
		this.setLocation(dev.getLocation());
		this.setName(dev.getName());
		this.setIddelup(dev.getIddel());
		System.out.println("******************************** "+this.getLocation()+" ********************************************");
		}
	public void update( ) {
		delsev.updateDelivery(new Delivery(iddelup,name,lastname,location));
		System.out.println("******************************** "+this.getLocation()+" ********************************************");
		}
	public DeliveryBean() {
		super();
	}
	
	public Integer getIddelup() {
		return iddelup;
	}

	public void setIddelup(Integer iddelup) {
		this.iddelup = iddelup;
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
	public List<Delivery> getDeliverys() {
		deliverys=delsev.findAllDelivery();
		return deliverys;
	}
	public void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}
	
}
