package camasir.models;

public class KurutmaMakinesi extends Makine {
	private String tipi;
	
	public KurutmaMakinesi() {
		super();
	}

	public KurutmaMakinesi(int sicaklik, int sure, int kapasite, int devir, String mod, String renk,
			String kurutmaDerecesi, String tipi) {
		super(sicaklik, sure, kapasite, devir, mod, renk);
		this.tipi = tipi;
	}
	
	@Override
	public void calistir() {
		
	}
	public String getTipi() {
		return tipi;
	}
	public void setTipi(String tipi) {
		this.tipi = tipi;
	}
	

}
