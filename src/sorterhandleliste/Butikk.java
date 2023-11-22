package sorterhandleliste;

import java.util.HashMap;

public class Butikk {
	
		HashMap<Avdeling, Integer> layout;

		
		
		
		public Butikk(HashMap<Avdeling, Integer> layout){
		this.layout=layout;
	
		}

		public HashMap<Avdeling, Integer> getlayout() {
			return layout;
		}

		public void setlayout(HashMap<Avdeling, Integer> layout) {
			this.layout = layout;
		}
}
