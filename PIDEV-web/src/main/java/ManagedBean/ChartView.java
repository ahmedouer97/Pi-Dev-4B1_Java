package ManagedBean;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;


@ManagedBean
@ViewScoped
public class ChartView implements Serializable{
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1;
	
	public  ChartView() {
		pieModel1 = new PieChartModel();
		pieModel1.set("Offre", 100);
		pieModel1.set("Produit", 325);
		pieModel1.set("Service", 702);
		pieModel1.set("Ligne", 421);
}
public PieChartModel getModel() {
	 	 return pieModel1;
}
public PieChartModel getPieModel1() {
	return pieModel1;
}
public void setPieModel1(PieChartModel pieModel1) {
	this.pieModel1 = pieModel1;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public ChartView(PieChartModel pieModel1) {
	super();
	this.pieModel1 = pieModel1;
}

}
