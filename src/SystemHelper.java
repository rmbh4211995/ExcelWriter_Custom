import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SystemHelper {

	/**
	 * Determine the alignment for all systems AND
	 * the total number of EMWs that map to a system AND
	 * the number of EMWs that map to a system capability
	 * 
	 * @param systems Array of System objects
	 * @param capabilities Array of Capability objects 
	 */
	public static void determineSystemAlignment(SSystem[] systems, Capability[] capabilities) {
        // determine system alignment AND emw mappings for systems
        for(int ii = 0; ii < systems.length; ii++) {
        	String emwCombo = "";
        	
        	for(int jj = 0; jj < capabilities.length; jj++) {
        		if(systems[ii].getCapability().equals(capabilities[jj].getCapability()) && capabilities[jj].getAlignment().equals("Aligned")) {
        			systems[ii].setAlignment("Aligned");
        			//System.out.println(systems[ii].getSystem() + " | " + capabilities[jj].getEmws());
        			systems[ii].setNumEmws(capabilities[jj].getEmwCount());
        			systems[ii].setCapability(capabilities[jj].getCapability());
        			systems[ii].setCapEmwCount(capabilities[jj].getEmwCount());
        			systems[ii].setCapJcaId(capabilities[jj].getJcaId());
        			emwCombo = emwCombo.concat(capabilities[jj].getEmws() + ",");
        		}
        	}
        	if(systems[ii].getAlignment().equals("Not Aligned")) {
        		emwCombo = "None";
        	}
        	else {
        		systems[ii].setEmwCombo(emwCombo);
        		systems[ii].setCapabilityEmw(emwCombo);
        		//System.out.println(systems[ii].getSystem() + " | " + systems[ii].getEmwCombo() + " | " + systems[ii].getCapability());
        		//emwCombo = CSVUtils.removeDuplicateEMWs(emwCombo);
        		//systems[ii].setEmwCombo(emwCombo);
        		//System.out.println(systems[ii].getSystem() + " | " + systems[ii].getEmwCombo());
        	}
        	
        	//systems[ii].setEmwCombo(emwCombo);
        	//System.out.println(systems[ii].getSystem() + " | " + systems[ii].getEmwCombo() + " | " + systems[ii].getCapJcaId());
        }
	}
	
	/**
	 * Set all systems to have the same Emw mapping (same systems are listed multiple times in SystemToCapability.csv)
	 * 
	 * @param systems Array of System objects
	 */
	public static void setSystemEmwMapping(SSystem[] systems) {
        // give all the same systems the SAME emw mapping
        for(int ii = 0; ii < systems.length; ii++) {
        	String totalEmw = "";
        	for(int jj = 0;  jj < systems.length; jj++) {
        		if(systems[ii].getSystem().equals(systems[jj].getSystem())) {
        			totalEmw = totalEmw.concat(systems[jj].getEmwCombo());
        		}
        	}
        	totalEmw = CSVUtils.removeDuplicateEMWs(totalEmw);
        	systems[ii].setEmwCombo(totalEmw);
        	systems[ii].setEmwComboCount(CSVUtils.calculateEmwCoverage(systems[ii].getEmwCombo()));
        	//System.out.println(systems[ii].getSystem() + " | " + systems[ii].getEmwCombo() + " | " + systems[ii].getEmwComboCount());
        }
	}
	
	/**
	 * Determine the Top 10 Systems with the Highest EMW count AND
	 * create a csv containing those systems
	 * 
	 * @param systems List of System objects 
	 * @return msg String message indicating report generation success or failure
	 */
	public static List<SSystem> findTop10SystemsForEmw(List<SSystem> alignmentSystems) {
        
		// find Top 10 Systems with the Highest EMW Count
        List<SSystem> systemsList = new ArrayList<SSystem>();
        for(SSystem sys : alignmentSystems) {
        	if(!sys.getNumEmws().equals("")) {
            	systemsList.add(sys);	
        	}
        }
        
		// sort systems by highest emw count
        Collections.sort(systemsList, new Comparator<SSystem>() {
        	@Override public int compare(SSystem sys1, SSystem sys2) {
        		return Integer.parseInt(sys2.getEmwComboCount()) - Integer.parseInt(sys1.getEmwComboCount()); // Descending
        	}
        });
        
        // only return top 10 systems
        List<SSystem> top10Sys = new ArrayList<SSystem>();
        for(int ii = 0; ii < 10; ii++) {
        	top10Sys.add(systemsList.get(ii));
        }
        
        return top10Sys;
	}
	
	/**
	 * For all blank emw mappings set the combo to NONE AND
	 * remove last comma from emwCombo property
	 * 
	 * @param systems List of system objects
	 */
	public static void setNotAlignmentEmwCombo(SSystem[] systems) {
        // for all blank emw mappings set the combo to NONE && remove last comma from emwCombo
        for(int ii = 0; ii < systems.length; ii++) {
        	if(systems[ii].getEmwCombo().equals(",")) {
        		systems[ii].setEmwCombo("None ");
        	}
        	systems[ii].setEmwCombo(systems[ii].getEmwCombo().substring(0, systems[ii].getEmwCombo().length() - 1));
        	//System.out.println(systems[ii].getSystem() + " | " + systems[ii].getEmwCombo());
        }
	}
	
	/**
	 * 
	 * @param systems Array of System objects
	 * @return alignmentSystems arraylist of all systems with their alignment & emw mappings
	 */
	public static List<SSystem> createAlignmentSystems(SSystem[] systems) {
        // get aligned systems
        int aligned = 0;
        List<SSystem> alignedSystems = new ArrayList<SSystem>();
        
        for(int ii = 0; ii < systems.length; ii++) {
        	if(!SSystem.containsSystem(alignedSystems, systems[ii]) && systems[ii].getAlignment().equals("Aligned")) {
        		alignedSystems.add(systems[ii]);
        		aligned++;
        	}
        }
        
        // get not aligned systems
        int notAligned = 0;
        List<SSystem> notAlignedSystems = new ArrayList<SSystem>();
        
        for(int ii = 0; ii < systems.length; ii++) {
        	if(!SSystem.containsSystem(notAlignedSystems, systems[ii]) && systems[ii].getAlignment().equals("Not Aligned")) {
        		notAlignedSystems.add(systems[ii]);
        		notAligned++;
        	}
        }
        
        // remove systems that are aligned from unaligned list 
        List<SSystem> toRemove = new ArrayList<SSystem>();
        
        for(int ii = 0; ii < notAlignedSystems.size(); ii++) {
        	for(int jj = 0; jj < alignedSystems.size(); jj++) {
            	if(notAlignedSystems.get(ii).getSystem().equals(alignedSystems.get(jj).getSystem())) {
            		toRemove.add(notAlignedSystems.get(ii));
            		notAligned--;
            	}
        	}
        }
        
        for(SSystem remove : toRemove) {
        	notAlignedSystems.remove(remove);
        }
        
        // remove column header ("System", "Alignment")
        notAlignedSystems.remove(0);
        
        
        // create single alignment arraylist
        List<SSystem> alignmentSystems = new ArrayList<SSystem>();
        for(int ii = 0; ii < alignedSystems.size(); ii++) {
        	alignmentSystems.add(alignedSystems.get(ii));
        }
        
        for(int ii = 0; ii < notAlignedSystems.size(); ii++) {
        	alignmentSystems.add(notAlignedSystems.get(ii));
        }
        
        return alignmentSystems;
	}
	
	/**
	 * 
	 * @param alignmentSystems
	 */
	public static void findSystemsWithSameEmw(List<SSystem> alignmentSystems) {
        for(int ii = 0; ii <  alignmentSystems.size(); ii++) {
        	//System.out.println(alignmentSystems.get(ii).getSystem() + " | " + systems[ii].getEmwCombo());
        	int sameEmwComboCount = 0;
        	for(int jj = 0; jj < alignmentSystems.size(); jj++) {
        		if(alignmentSystems.get(ii).getEmwCombo().equals(alignmentSystems.get(jj).getEmwCombo())) {
        			//System.out.println("EMW Mapping: " + alignmentSystems.get(jj).getEmwCombo());
        			sameEmwComboCount++;
        		}
        	}
        	//System.out.println(sameEmwComboCount);
        	alignmentSystems.get(ii).setNumSysSameEMW(String.valueOf(sameEmwComboCount));
        }
	}
	
	/**
	 * 
	 * @param alignmentSystems
	 * @param top10Emws
	 */
	public static void matchSystemsToTop10Emws(List<SSystem> alignmentSystems, ArrayList<EMW> top10Emws) {
        for(int ii = 0; ii < alignmentSystems.size(); ii++) {
        	for(int jj = 0; jj < top10Emws.size(); jj++) {
        		if(alignmentSystems.get(ii).getEmwCombo().equals(top10Emws.get(jj).getEmwCombo())) {
        			alignmentSystems.get(ii).setTop10emwMatch(CSVUtils.formatEmwCombo(top10Emws.get(jj).getEmwCombo()));
        			alignmentSystems.get(ii).setTop10emwComboNum(String.valueOf(jj + 1));
        		}
        	}
        }
	}
	
	/**
	 * 
	 * @param alignmentSystems
	 */
	public static void formatSysEmwCombo(List<SSystem> alignmentSystems) {
        for(int ii = 0; ii < alignmentSystems.size(); ii++) {
        	alignmentSystems.get(ii).setEmwCombo(CSVUtils.formatEmwCombo(alignmentSystems.get(ii).getEmwCombo()));
        }
        
//        for(int ii = 0; ii < alignmentSystems.size(); ii++) {
//        	System.out.println(alignmentSystems.get(ii).getSystem() + " | " + alignmentSystems.get(ii).getEmwCombo() + " | " + alignmentSystems.get(ii).getTop10emwComboNum());
//        	alignmentSystems.get(ii).getTop10emwComboNum()
//        }
	}
	
	/**
	 * 
	 * @param systems
	 * @return
	 */
	public static List<SSystem> determineSystemToSingleEmw(SSystem[] systems) {
		
		List<SSystem> systemSingleEmw = new ArrayList<SSystem>();
		
		for(int ii = 0; ii < systems.length; ii++) {
			String capability = systems[ii].getCapability();
			String system = systems[ii].getSystem();
			String[] capabilityEmw = systems[ii].getCapabilityEmw().split(",");
			
			// don't add systems that do not map to an emw (Not Aligned systems)
			if(capabilityEmw.length != 1) {
				for(String capEmw : capabilityEmw) {
					SSystem tempObj = new SSystem(system, capability, "", capEmw);
					
					// set emw description for aligned capabilities
					String emwDescription = EmwHelper.setEmwDescriptions(tempObj.getCapabilityEmw());
					tempObj.setCapEmwDescription(emwDescription);
					tempObj.setCapJcaId(systems[ii].getCapJcaId());
					systemSingleEmw.add(tempObj);
				}
			}
		}
		
		return systemSingleEmw;
	}
}
