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

	public Kullanici() {

	}

	public String getTC() {
		return TC;
	}

	public void setTC(String tC) throws Exception {
		if (tC != null && tC.length() == 11 && tC.matches("\\d+")) { // bos mu 11 tane mi ve rakam mi?
			TC = tC;
		} else {
			throw new Exception("TC Kimlik numarası 11 hane olmalı!");
		}
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		if (telNo != null && telNo.length() == 10 && telNo.matches("\\d+")) {
			this.telNo = telNo;
		} else {
			System.out.println("Telefon numarası 10 karakter olmak zorundadır!");
		}
	}

	public String getTamIsim() {
		return tamIsim;
	}

	public void setTamIsim(String tamIsim) {
		this.tamIsim = tamIsim;
	}

	abstract void ekraniCalistir();
}