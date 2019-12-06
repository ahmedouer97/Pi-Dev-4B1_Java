package Interface;

import java.util.List;

import model.Delivery;

public interface Deliveryinter {
	public int addDelivery(Delivery dev);
	public void removeDelivery(int id);
	public void updateDelivery(Delivery user);
	public Delivery findDeliveryById(int id);
	public List<Delivery> findAllDelivery();
}
