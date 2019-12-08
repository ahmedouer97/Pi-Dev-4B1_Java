package Interface;

import javax.ejb.Remote;

@Remote
public interface OfferServiceRemote {

	long getNombredevJPQL();

	long getPoureRequestJPQL();

	long getNombredsJPQL();

	long getNombrecompJPQL();

	long getNombrefinJPQL() ;
	
}
