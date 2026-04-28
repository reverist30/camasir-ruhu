package camasir.models;

public class Memur extends Kullanici {
	
	private String personelID;

	public Memur(String tC, String telNo, String tamIsim, String personelID) {
		super(tC, telNo, tamIsim);
		this.personelID = personelID;
	}

	public String getPersonelID() {
		return personelID;
	}

	public void setPersonelID(String personelID) {
		this.personelID = personelID;
	}
	

}
