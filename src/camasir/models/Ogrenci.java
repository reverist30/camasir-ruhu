package camasir.models;

public class Ogrenci extends Kullanici {
	private String odaNo;
	private boolean randevuHakki;
	public Ogrenci(String tC, String telNo, String tamIsim, String odaNo, boolean randevuHakki) {
		super(tC, telNo, tamIsim);
		this.odaNo = odaNo;
		this.randevuHakki = randevuHakki;
	}
	
	public String getOdaNo() {
		return odaNo;
	}
	public void setOdaNo(String odaNo) {
		this.odaNo = odaNo;
	}
	public boolean isRandevuHakki() {
		return randevuHakki;
	}
	public void setRandevuHakki(boolean randevuHakki) {
		this.randevuHakki = randevuHakki;
	}
	public void ekraniCalistir() {
		
		
	}
}
