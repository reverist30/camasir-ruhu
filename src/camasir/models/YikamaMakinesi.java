package camasir.models;

public class YikamaMakinesi extends Makine {
	private int maxDeterjanMiktari;

	public YikamaMakinesi(int sicaklik, int devirSayisi, double kapasite, int maxDeterjanMiktari) {
		super(sicaklik, devirSayisi, kapasite);
		this.maxDeterjanMiktari = maxDeterjanMiktari;
	}

	public int getMaxDeterjanMiktari() {
		return maxDeterjanMiktari;
	}

	public void setMaxDeterjanMiktari(int maxDeterjanMiktari) {
		this.maxDeterjanMiktari = maxDeterjanMiktari;
	}
	

}
