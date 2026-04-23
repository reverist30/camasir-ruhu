package camasir_ruhu_package;

public abstract class Makine {
	
	private int sicaklik;
	private int devirSayisi;
	private double kapasite;

	public Makine(int sicaklik, int devirSayisi, double kapasite) {
		this.sicaklik = sicaklik;
		this.devirSayisi = devirSayisi;
		this.kapasite = kapasite;
	}

	public int getSicaklik() {
		return sicaklik;
	}

	public void setSicaklik(int sicaklik) {
		this.sicaklik = sicaklik;
	}

	public int getDevirSayisi() {
		return devirSayisi;
	}

	public void setDevirSayisi(int devirSayisi) {
		this.devirSayisi = devirSayisi;
	}

	public double getKapasite() {
		return kapasite;
	}

	public void setKapasite(double kapasite) {
		this.kapasite = kapasite;
	}
	
	

}
