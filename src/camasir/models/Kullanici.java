package camasir.models;

public abstract class Kullanici {
	private String TC;
	private String telNo;
	private String tamIsim;
	public Kullanici(String tC, String telNo, String tamIsim) {
		super();
		TC = tC;
		this.telNo = telNo;
		this.tamIsim = tamIsim;
	}
	public String getTC() {
		return TC;
	}
	public void setTC(String tC) {
		if(tC != null &&tC.length()== 11 && tC.matches("\\d+")) {
			TC = tC;
		}else {
			System.out.println("TC kimlik numarasi 11 karakter olmak zorundadir!");
		}
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getTamIsim() {
		return tamIsim;
	}
	public void setTamIsim(String tamIsim) {
		this.tamIsim = tamIsim;
	}
	


}
