package camasir.models;

import camasir.interfaces.IEkonomik;
import camasir.interfaces.IGuvenlik;

public class YikamaMakinesi extends Makine implements IEkonomik, IGuvenlik{
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

	@Override
	public void cocukKilidiAktifEt(boolean durum) {
		
		
	}

	@Override
	public boolean kapakKilitliMi() {

		return false;
	}

	@Override
	public void tasarrufModuAc() {
	
		
	}

	@Override
	public int tahminiEnerjiTuketimi() {
	
		return 0;
	}

}
