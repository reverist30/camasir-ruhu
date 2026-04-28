package camasir.models;

public abstract class Makine {
	
	private int sicaklik;
	private int devirSayisi;
	private String yikamaRengi;

	public Makine(int sicaklik, int devirSayisi, String yikamaRengi) {
		this.sicaklik = sicaklik;
		this.devirSayisi = devirSayisi;
		this.yikamaRengi = yikamaRengi;
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

	public String getYikamaRengi() {
		return yikamaRengi;
	}

	public void setYikamaRengi(String yikamaRengi) {
		this.yikamaRengi = yikamaRengi;
	}
	
	

}
