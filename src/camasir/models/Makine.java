package camasir.models;

public abstract class Makine {
	
	private int sicaklik;
	private int sure;
	private int kapasite;
	private int devir;
	private String mod;
	private String renk;
	
	public Makine() {
	}

	public Makine(int sicaklik, int sure, int kapasite, int devir, String mod, String renk) {
		this.sicaklik = sicaklik;
		this.sure = sure;
		this.kapasite = kapasite;
		this.devir = devir;
		this.mod = mod;
		this.renk = renk;
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

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
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
