package camasir.models;

public class Ogrenci extends Kullanici {
	private String odaNo;
	private boolean randevuHakkı;
	public Ogrenci(String tC, String telNo, String tamIsim, String odaNo, boolean randevuHakkı) {
		super(tC, telNo, tamIsim);
		this.odaNo = odaNo;
		this.randevuHakkı = randevuHakkı;
	}
	
	public String getOdaNo() {
		return odaNo;
	}
	public void setOdaNo(String odaNo) {
		this.odaNo = odaNo;
	}
	public boolean isRandevuHakkı() {
		return randevuHakkı;
	}
	public void setRandevuHakkı(boolean randevuHakkı) {
		this.randevuHakkı = randevuHakkı;
	}
	public void ekraniCalistir() {
		
		
	}
}
