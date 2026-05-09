package camasir.models;

public class Ogrenci extends Kullanici {
	private String odaNo;
	private int randevuHakki;
	public Ogrenci(String tC, String telNo, String tamIsim, String odaNo,int randevuHakki) {
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
	public int getRandevuHakki() {
		return randevuHakki;
	}
	public void setRandevuHakki(int randevuHakki) {
		this.randevuHakki = randevuHakki;
	}
	public void ekraniCalistir() {
		
		
	}
}
