package camasir.models;

public class KurutmaMakinesi extends Makine {
	private String kurutmaDerecesi;
	private String tipi;
	public KurutmaMakinesi(int sicaklik, int devirSayisi, String kurutmaDerecesi, String tipi, double kapasite) {
		super(sicaklik, devirSayisi, kapasite);
		this.kurutmaDerecesi = kurutmaDerecesi;
		this.tipi = tipi;
	}
	public String getKurutmaDerecesi() {
		return kurutmaDerecesi;
	}
	public void setKurutmaDerecesi(String kurutmaDerecesi) {
		this.kurutmaDerecesi = kurutmaDerecesi;
	}
	public String getTipi() {
		return tipi;
	}
	public void setTipi(String tipi) {
		this.tipi = tipi;
	}
	
	
	

}
