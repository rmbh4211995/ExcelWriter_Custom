import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EmwHelper {

	// emw descriptions
	private static String e1  = "Empower and Care for Our People";
	private static String e2  = "Optimize Operations Across the Military Health System";
	private static String e3  = "Co-create Optimal Outcomes for Health Well-Being and Readines";
	private static String e4  = "Deliver Solutions to Combatant Commands";
	private static String w1  = "Build Robust Improvement Capability";
	private static String w2  = "Ensure that Everyone Can Succeed";
	private static String w3  = "Gather Develop and Prioritize Requirements";
	private static String w4  = "Unify and Fully Integrate the Enterprise Support Activities";
	private static String w5  = "Manage and Administer MTFs";
	private static String w6  = "Modernize Private Sector Component of TRICARE Program in Support of Readiness and Health";
	private static String w7  = "Deliver and Sustain Electronic Health Record";
	private static String w8  = "Improve Readiness Health and Experience";
	private static String w9  = "Strengthen Strategic Partnerships and Alliances";
	private static String w10 = "Deploy Solutions for 21st Century";
	private static String m1  = "Optimize Critical Internal Management Processes";
	
	/**
	 * 
	 * @param alignmentSystems
	 * @return
	 */
	public static List<EMW> findAllEmwCombinations(List<SSystem> alignmentSystems) {
        // get all emw combinations
        Set<String> emwStrings = new LinkedHashSet<String>();
        for (int ii = 0; ii < alignmentSystems.size(); ii++) {
        	emwStrings.add(alignmentSystems.get(ii).getEmwCombo());
        }
        
		// create set of all possible emw combinations
		List<EMW> emwCombinations = new ArrayList<EMW>();
		for (String emws : emwStrings) {
			emwCombinations.add(new EMW(emws));
		}
		
		// create count for all possible emw combinations
		for (int ii = 0; ii < emwCombinations.size(); ii++) {
			int emwCount = 0;
			for (int jj = 0; jj < alignmentSystems.size(); jj++) {
				if (emwCombinations.get(ii).getEmwCombo().equals(alignmentSystems.get(jj).getEmwCombo())) {
					emwCount++;
				}
			}
			emwCombinations.get(ii).setEmwCount(String.valueOf(emwCount));
		}
    
		return emwCombinations;
	}
	
	
	/**
	 * 
	 * @param emwCombinations
	 * @return
	 */
	public static ArrayList<EMW> findTop10EmwCombinations(List<EMW> emwCombinations) {
		// sort emwCombinations
		Collections.sort(emwCombinations, new Comparator<EMW>() {
			@Override
			public int compare(EMW emw1, EMW emw2) {
				return Integer.parseInt(emw2.getEmwCount()) - Integer.parseInt(emw1.getEmwCount()); // Descending
			}
		});

		// add top 10 emwCombinations
		ArrayList<EMW> top10Emws = new ArrayList<EMW>();
		for (int ii = 0; ii < 11; ii++) {
			top10Emws.add(emwCombinations.get(ii));
			// System.out.println(top10Emws.get(ii).getEmwCombo() + " = " +
			// top10Emws.get(ii).getEmwCount());
		}

		// remove "None" emw combination
		top10Emws.remove(1);
		
		return top10Emws;
	}
	
	/**
	 * 
	 * @param emw
	 * @return
	 */
	public static String setEmwDescriptions(String emw) {
		String description = "";
		
		if(emw.equals("E1")) {
			description = e1;
		}
		if(emw.equals("E2")) {
			description = e2;
		}
		if(emw.equals("E3")) {
			description = e3;
		}
		if(emw.equals("E4")) {
			description = e4;
		}
		if(emw.equals("W1")) {
			description = w1;
		}
		if(emw.equals("W2")) {
			description = w2;
		}
		if(emw.equals("W3")) {
			description = w3;
		}
		if(emw.equals("W4")) {
			description = w4;
		}
		if(emw.equals("W5")) {
			description = w5;
		}
		if(emw.equals("W6")) {
			description = w6;
		}
		if(emw.equals("W7")) {
			description = w7;
		}
		if(emw.equals("W8")) {
			description = w8;
		}
		if(emw.equals("W9")) {
			description = w9;
		}
		if(emw.equals("W10")) {
			description = w10;
		}
		if(emw.equals("M1")) {
			description = m1;
		}
		
		return description;
	}
}
