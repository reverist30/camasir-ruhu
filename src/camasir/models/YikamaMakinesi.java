package camasir.models;

public class YikamaMakinesi extends Makine {
	private int maxDeterjanMiktari;

	public YikamaMakinesi(int sicaklik, int devirSayisi, String yikamaRengi, int maxDeterjanMiktari) {
		super(sicaklik, devirSayisi,  yikamaRengi);
		this.maxDeterjanMiktari = maxDeterjanMiktari;
	}

	public int getMaxDeterjanMiktari() {
		return maxDeterjanMiktari;
	}

	public void setMaxDeterjanMiktari(int maxDeterjanMiktari) {
		this.maxDeterjanMiktari = maxDeterjanMiktari;
	}
	

}
