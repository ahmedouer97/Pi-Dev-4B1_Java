package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.Store;

@Remote
public interface ServiceStore  {
	public int addStore(Store Store);

	

	public String getStoreById(int StoreId);

	public void deleteStoreById(int StoreId);


	public long getNombreStoreJPQL();


	public List<Store> getStorebyVille(String ville);
	public List<Store> getStorebyType(String type);

	public List<Store> getAllStores();

}
