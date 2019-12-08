package ManagedBean;



import java.io.Serializable;
import java.util.List;
import java.util.Locale;


import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.OffreService;
import model.Offre;

@Named("filterView")
@ViewScoped
public class FilterView implements Serializable {
 
	 private List<Offre> offres;
	    private static final long serialVersionUID = 1L;
	 
	    private List<Offre> filteredOffre;
	   
	 
	    @Inject
	    private OffreService offreservice;
	 
	    
	    public boolean filterByPrice(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim();
	        if (filterText == null || filterText.equals("")) {
	            return true;
	        }
	 
	        if (value == null) {
	            return false;
	        }
	 
	        return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
	    }
	 
	    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
	        if (filterText == null || filterText.equals("")) {
	            return true;
	        }
	        int filterInt = getInteger(filterText);
	 
	        Offre offre = (Offre) value;
	        return 
	                 offre.getDescription().toLowerCase().contains(filterText)
	                || offre.getTitle().toLowerCase().contains(filterText) 
	                || offre.getPrice() < filterInt;
	    }
	 
	    private int getInteger(String string) {
	        try {
	            return Integer.valueOf(string);
	        }
	        catch (NumberFormatException ex) {
	            return 0;
	        }
	    }

		public List<Offre> getOffres() {
			return offres;
		}

		public void setOffres(List<Offre> offres) {
			this.offres = offres;
		}

		public List<Offre> getFilteredOffre() {
			return filteredOffre;
		}

		public void setFilteredOffre(List<Offre> filteredOffre) {
			this.filteredOffre = filteredOffre;
		}

		public OffreService getService() {
			return offreservice;
		}

		public void setService(OffreService service) {
	        this.offreservice = service;
	    }
    
}