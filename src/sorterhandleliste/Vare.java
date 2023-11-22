package sorterhandleliste;

public class Vare {
	String navn;
	Avdeling avdeling;
	
	public Vare(String navn, Avdeling avd){
		this.navn=navn;
		this.avdeling=avd;
		}

	
	
	@Override
	public String toString() {
		return navn;
	}



	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}



	
	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}
	
	
	
}
