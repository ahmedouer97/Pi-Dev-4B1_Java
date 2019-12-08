package ManagedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import Service.OfferService;
import javafx.scene.chart.PieChart;
import model.Offer;

@ManagedBean
public class OfferBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1 = new PieChartModel();
	private PieChartModel pieModel2;
	@EJB
	OfferService OfferService;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		long res1 = OfferService.getNombredevJPQL();
		long res2 = OfferService.getNombrecompJPQL();
		long res3 = OfferService.getNombrefinJPQL();
		long res4 = OfferService.getNombredsJPQL();
		long res5 = OfferService.getPoureRequestJPQL();
		this.pieModel1.set("offre", res1 * 60/ res5);
		this.pieModel1.set("produit", res2 * 60 / res5);
		this.pieModel1.set("service", res3 * 60 / res5);
		this.pieModel1.set("ligne", res4 * 60/ res5);

		
		return pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		createPieModel1();

	}

	private void createPieModel1() {

	
	}

	public void setPieModel1(PieChartModel pieModel1) {
		
		this.pieModel1 = pieModel1;
	}
	
}
