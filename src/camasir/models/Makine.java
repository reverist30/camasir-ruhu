package camasir.models;

public abstract class Makine {
	
	private int sicaklik;
	private int sure;
	private int kapasite;
	private int devir;
	private String mod;
	private String yikamaRengi;

	public Makine(int sicaklik, int sure, int kapasite, int devir, String mod, String yikamaRengi) {
		this.sicaklik = sicaklik;
		this.sure = sure;
		this.kapasite = kapasite;
		this.devir = devir;
		this.mod = mod;
		this.yikamaRengi = yikamaRengi;
	}

	public abstract void calistir();
	
	public int getSicaklik() {
		return sicaklik;
	}

	public void setSicaklik(int sicaklik) {
		this.sicaklik = sicaklik;
	}

	public int getDevir() {
		return devir;
	}

	public void setDevir(int devir) {
		this.devir = devir;
	}

	public String getYikamaRengi() {
		return yikamaRengi;
	}

	public void setYikamaRengi(String yikamaRengi) {
		this.yikamaRengi = yikamaRengi;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public int getSure() {
		return sure;
	}

	public void setSure(int sure) {
		this.sure = sure;
	}

	public int getKapasite() {
		return kapasite;
	}

	public void setKapasite(int kapasite) {
		this.kapasite = kapasite;
	}

}
