package model;


public enum Heure {

		  //Objets directement construits
		  heure1 ("8h"),
		  heure2 ("8h30"),
		  heure3 ("9h"),
		  heure4 ("9h30"),
		  heure5 ("10h"),
		  heure6 ("10h30"),
		  heure7 ("11h"),
		  heure8 ("11h30"),
		  heure9 ("12h"),
		  heure10 ("12h30"),
		  heure11 ("13h"),
		  heure12 ("13h30"),
		  heure13 ("14h"),
		  heure14 ("14h30"),
		  heure15 ("15h"),
		  heure16 ("15h30"),
		  heure17 ("16h"),
		  heure18 ("16h30"),
		  heure19 ("17h"),
		  heure20 ("17h30"),
		  heure21("18h"),
		  heure22("18h30"),;
		   
		  private String name = "";
		   
		  //Constructeur
		  Heure(String name){
		    this.name = name;
		  }
		   
		  public String toString(){
		    return name;
		  }
		
}
