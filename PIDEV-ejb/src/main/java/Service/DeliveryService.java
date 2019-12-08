package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.plaf.SliderUI;

import Interface.Deliveryinter;
import model.CommandeLigne;
import model.Delivery;
@Stateless
@LocalBean
public class DeliveryService implements Deliveryinter{
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	String locsT[] = {"Tunis", "Manouba", "Ariana" };
	String locsM[] = {"Manouba", "Tunis", "Ariana" };
	String locsA[] = {"Ariana", "Tunis", "Manouba" };
	public int addDelivery(Delivery dev) {
		System.out.println("In adddev : ");
		em.persist(dev);
		System.out.println("Out of adddev" + dev.getIddel());
		return dev.getIddel();
	}

	@Override
	public void removeDelivery(int id) {
		System.out.println("In remove : ");
		em.remove(em.find(Delivery.class, id));
		System.out.println("Out of remove : ");
		
	}

	@Override
	public void updateDelivery(Delivery dev) {
		em.merge(dev);
		
	}
	
	public void AffecterCommande(int idcl,String Loc) {
		int id=-1;Delivery d=null;
		List<Delivery> dls=em.createQuery("from Delivery",
				Delivery.class).getResultList();
		if(Loc.equals("Tunis")) {
			for(int j=0;j<locsT.length;j++) {
				System.out.println("***************************** "+ locsT[j]+" *********************************************");
					for(int i=0;i<dls.size();i++) {
						System.out.println("***************************** "+dls.get(i).getLocation()+" *********************************************");
						if(dls.get(i).getLocation().equals(locsT[j])) {
							if(dls.get(i).getCommandeLignes().size()<10) {id=dls.get(i).getIddel();d=dls.get(i);}
							}	
						if(id!=-1)	break;
					}
						if(id!=-1)	break;
											}
		}
		else if(Loc.equals("Manouba")) {
			for(int j=0;j<locsM.length;j++) {
				System.out.println("M***************************** "+ locsM[j]+" *********************************************");
				for(int i=0;i<dls.size();i++) {
					System.out.println("M***************************** "+dls.get(i).getLocation()+" *********************************************");
					if(dls.get(i).getLocation().equals(locsM[j])) {
						if(dls.get(i).getCommandeLignes().size()<10) {id=dls.get(i).getIddel();d=dls.get(i);}
						}
					if(id!=-1)	break;
				}
					if(id!=-1)	break;
										}
		}
		else if(Loc.equals("Ariana")) {
			for(int j=0;j<locsA.length;j++) {
				System.out.println("A***************************** "+ locsA[j]+" *********************************************");
				for(int i=0;i<dls.size();i++) {
					System.out.println("Af***************************** "+dls.get(i).getLocation()+" *********************************************");
					if(dls.get(i).getLocation().equals(locsA[j])) {
						if(dls.get(i).getCommandeLignes().size()<10) {id=dls.get(i).getIddel();d=dls.get(i);}
						}	
					if(id!=-1)	break;
				}
					if(id!=-1)	break;
										}
		}
		System.out.println("***************************** "+ id+" *********************************************");
		if(d!=null&&id!=-1) {
		CommandeLigne cls=em.find(CommandeLigne.class, idcl);
		
		cls.setDelivery(d);}
	}
	@Override
	public Delivery findDeliveryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Delivery> findAllDelivery() {
		
		return em.createQuery("from Delivery",
				Delivery.class).getResultList();
	}
	
}
