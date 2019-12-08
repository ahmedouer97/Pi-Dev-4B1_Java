package Interface;

import javax.ejb.Remote;

@Remote
public interface OffreServiceRemote {

	long getNombredevJPQL();

	long getPoureRequestJPQL();

	long getNombredsJPQL();

	long getNombrecompJPQL();

	long getNombrefinJPQL() ;
}
