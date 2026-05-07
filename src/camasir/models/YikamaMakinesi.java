package camasir.models;

public class YikamaMakinesi extends Makine{
	private int deterjanMiktari;
	
	public YikamaMakinesi() {
		super();
	}

	public YikamaMakinesi(int sicaklik, int sure, int kapasite, int devir, String mod, String renk,
			int deterjanMiktari) {
		super(sicaklik, sure, kapasite, devir, mod, renk);
		this.deterjanMiktari = deterjanMiktari;
	}

	@Override
	public void calistir() {
		
	}
	
	public int getdeterjanMiktari() {
		return deterjanMiktari;
	}

	public void setdeterjanMiktari(int deterjanMiktari) {
		this.deterjanMiktari = deterjanMiktari;
	}

}
