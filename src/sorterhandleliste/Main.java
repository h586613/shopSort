package sorterhandleliste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


import javax.swing.JOptionPane;
//import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		String varenavn=null;
		Avdeling vareavdeling = null;
		Butikk butikk = new Butikk(new HashMap<Avdeling, Integer>());
		List<Vare> handleliste = new ArrayList<>();
		List<String> importerthandleliste = new ArrayList<>(
				Arrays.asList( new String[]{
						
						}
					));
		
		
		//1. lim inn liste
		
		//eller

		//har ingen liste: vil skrive inn én og én vare og hvilken avdeling den tilhører
		//det som gir færrest klikk: "kryss av de varene som tilhører <Avdeling.navn>" pga mange-til-én
	
		String[] avdelinger = new String[]{
				"Frukt og grønnsaker",
				"Kjøleskap",
				"Kjøtt",
				"Ost",
				"Bakevarer",
				"Pålegg",
				"Frysedisk",
				"Meieri",
				"Drikke",
				"Snop",
				"Husholdningsprodukter",
				"Rengjøringsprodukter",
				"Krydder og oljer",
				"Tørrvarer",
				"Taco",
				"Dyremat",
				"Alkohol"
				};

		
				List<String> avdelingsnavn = new ArrayList<>(Arrays.asList(avdelinger));

				for (String s : avdelingsnavn) {
					butikk.getlayout().put(new Avdeling(s), avdelingsnavn.indexOf(s));
				}
		
		
		
			for (String s : importerthandleliste) {

				vareavdeling = (Avdeling) JOptionPane.showInputDialog(null, null,
						"Velg hvilken avdeling " + s + " hører til i", JOptionPane.QUESTION_MESSAGE, null,
						butikk.getlayout().keySet().toArray(), butikk.getlayout().keySet().toArray()[0]);

				if (vareavdeling == null) {
					break;
				}

				handleliste.add(new Vare(s, vareavdeling));
			}


		
		
		
		do {
			varenavn = JOptionPane.showInputDialog("Legge til ny vare", "Skriv inn varenavn");
			if (varenavn == null) {
				break;
			}
			vareavdeling = (Avdeling) JOptionPane.showInputDialog(null, null, "Velg hvilken avdeling "+ varenavn.toLowerCase() +" hører til i",
					JOptionPane.QUESTION_MESSAGE, null, butikk.getlayout().keySet().toArray(), butikk.getlayout().keySet().toArray()[0]);
			if (vareavdeling == null) {
				break;
			}
			handleliste.add(new Vare(varenavn, vareavdeling));
		} while (varenavn != null && vareavdeling != null);
		

		
		if (!handleliste.isEmpty()) {
			System.out.println();
			System.out.println("Før sortering:");
			System.out.println();
			handleliste.stream().map(v -> v.getNavn()).distinct().forEach(System.out::println);
			System.out.println();
			System.out.println();
		}

		
		
//		Comparator<Vare> paaAvdeling = (v1, v2) -> layout.get(v1.getAvdeling()) - layout.get(v2.getAvdeling());

		
		
		
		
		if (!handleliste.isEmpty()) {
			System.out.println("Etter sortering:");
			System.out.println();

		}
	
		
		
		
		handleliste.stream()
							.sorted(getButikkLayoutComparator(butikk))
							.map(v -> v.getAvdeling().toString())
							.distinct()
							.forEach(s -> {
											System.out.println(s.toUpperCase() + ":");
											handleliste.stream()
											.filter(v -> v.getAvdeling().getNavn().equals(s))
											.map(v -> "- " + v.getNavn())
											.distinct()
											.forEach(System.out::println);
											System.out.println();
											});
		
	}
	
	

	
	public static Comparator<Vare> paaAvdeling(HashMap<Avdeling,Integer> layout){
		return (v1, v2) -> layout.get(v1.getAvdeling()) - layout.get(v2.getAvdeling());
	}
	
	
	
	public static Comparator<Vare> getButikkLayoutComparator(Butikk butikk){
		return paaAvdeling(butikk.getlayout());
	}
}
