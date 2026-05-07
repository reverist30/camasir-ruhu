package camasir.models;

public class KurutmaMakinesi extends Makine {
	private String kurutmaDerecesi;
	private String tipi;
	
	public KurutmaMakinesi(int sicaklik, int sure, int kapasite, int devir, String mod, String yikamaRengi,
			String kurutmaDerecesi, String tipi) {
		super(sicaklik, sure, kapasite, devir, mod, yikamaRengi);
		this.kurutmaDerecesi = kurutmaDerecesi;
		this.tipi = tipi;
	}
	
	@Override
	public void calistir() {
		
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
