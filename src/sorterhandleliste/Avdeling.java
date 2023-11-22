package sorterhandleliste;

public class Avdeling {
	String navn;
	

	public Avdeling(String navn){
	this.navn=navn;

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}



	@Override
	public String toString() {
		return navn;
	}
}
