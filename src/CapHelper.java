import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CapHelper {
	
	/**
	 * Determine which EMWs map to a capability AND
	 * the total number of EMWs that map to a capability
	 * 
	 * @param capabilities Array of Capability objects 
	 */
	public static void determineCapabilityAlignment(Capability[] capabilities) {
		// determine capability alignment
        for(int ii = 0; ii < capabilities.length; ii++) {
        	String emws = "";
        	int emwCount = 0;
        	if(capabilities[ii].getE1().equals("1")) {
        		emwCount++;
        		emws = emws.concat("E1,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getE2().equals("1")) {
        		emwCount++;
        		emws = emws.concat("E2,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getE3().equals("1")) {
        		emwCount++;
        		emws = emws.concat("E3,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getE4().equals("1")) {
        		emwCount++;
        		emws = emws.concat("E4,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW1().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W1,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW2().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W2,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW3().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W3,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW4().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W4,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW5().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W5,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW6().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W6,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW7().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W7,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW8().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W8,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW9().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W9,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getW10().equals("1")) {
        		emwCount++;
        		emws = emws.concat("W10,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	if(capabilities[ii].getM1().equals("1")) {
        		emwCount++;
        		emws = emws.concat("M1,");
        		capabilities[ii].setAlignment("Aligned");
        	}
        	
        	if(emws.equals("")) {
        		emws = "N/A ";
        	}
        	// remove last comma or space
        	emws = emws.substring(0, emws.length() - 1);
        	
        	capabilities[ii].setEmwCount(String.valueOf(emwCount));
        	capabilities[ii].setEmws(emws);
        	//System.out.println(capabilities[ii].getJcaId() + " | " + capabilities[ii].getCapability() + " | " + capabilities[ii].getEmws() + " | " + capabilities[ii].getEmwCount());
        }
	}
    
    public static void determineTotalAndAligCap(List<SSystem> alignmentSystems, SSystem[] systems, Capability[] capabilities) {
        // determine total capabilities
        for(int ii = 0; ii < alignmentSystems.size(); ii++) {
        	int totalCap = 0;
        	for(int jj = 0; jj < systems.length; jj++) {
        		if(alignmentSystems.get(ii).getSystem().equals(systems[jj].getSystem())) {
        			totalCap++;
        		}
        	}
        	alignmentSystems.get(ii).setTotalCap(String.valueOf(totalCap));
        }
        
        // determine aligned capabilities 
        for(int ii = 0; ii < alignmentSystems.size(); ii++) {
        	int alignedCap = 0;
        	for(int jj = 0; jj < systems.length; jj++) {
        		for(int kk = 0; kk < capabilities.length; kk++) {
        			if(alignmentSystems.get(ii).getSystem().equals(systems[jj].getSystem()) && systems[jj].getCapability().equals(capabilities[kk].getCapability())
        			   && capabilities[kk].getAlignment().equals("Aligned")) {
        				alignedCap++;
        			}
        		}
        	}
       	
       	//System.out.println("Aligned cap: " + alignedCap);
        alignmentSystems.get(ii).setAlignedCap(String.valueOf(alignedCap));
        
        }
    }
    
    public static void determinePercentAlignment(List<SSystem> alignmentSystems) {
    	// determine percent capability alignment (# aligned capabilities / total # of capabilities)
        for(int ii = 0; ii < alignmentSystems.size(); ii++) {
        	String perGrouping = "";
        	int percent = Integer.parseInt(alignmentSystems.get(ii).getAlignedCap()) * 100 / Integer.parseInt(alignmentSystems.get(ii).getTotalCap());
        	//System.out.println(percent);
        	
        	if(percent >= 0 && percent <= 10) {
        		perGrouping = "0-10%";
        	}
        	else if(percent > 10 && percent <= 20) {
        		perGrouping = "10-20%";
        	}
        	else if(percent > 20 && percent <= 30) {
        		perGrouping = "20-30%";
        	}
        	else if(percent > 30 && percent <= 40) {
        		perGrouping = "30-40%";
        	}
        	else if(percent > 40 && percent <= 50) {
        		perGrouping = "40-50%";
        	}
        	else if(percent > 50 && percent <= 60) {
        		perGrouping = "50-60%";
        	}
        	else if(percent > 60 && percent <= 70) {
        		perGrouping = "60-70%";
        	}
        	else if(percent > 70 && percent <= 80) {
        		perGrouping = "70-80%";
        	}
        	else if(percent > 80 && percent <= 90) {
        		perGrouping = "80-90%";
        	}
        	else if(percent > 90 && percent <= 100) {
        		perGrouping = "90-100%";
        	}
        	else {
        		percent = 100; // percent > 100
        		perGrouping = "90-100%";
        	}
        	
        	alignmentSystems.get(ii).setPercentCoverage(String.valueOf(percent) + "%");
        	alignmentSystems.get(ii).setPercentGrouping(String.valueOf(perGrouping));
        }
    }
    
    public static List<Capability> findTop10Capabilities(Capability[] capabilities) {
    	
    	List<Capability> capList = new ArrayList<Capability>(Arrays.asList(capabilities));
    	
		// sort capabilities by highest emwCount
		Collections.sort(capList, new Comparator<Capability>() {
			@Override
			public int compare(Capability cap1, Capability cap2) {
				return Integer.parseInt(cap2.getEmwCount()) - Integer.parseInt(cap1.getEmwCount()); // Descending
			}
		});
		
		//  for(int ii = 0; ii < 10; ii++) {
		//		System.out.println(capList.get(ii).getCapability() + " | " + capList.get(ii).getEmws() + " | " + capList.get(ii).getEmwCount());
		//	}
		
		List<Capability> top10Caps = new ArrayList<Capability>();
		for(int ii = 0; ii < 10; ii++) {
			top10Caps.add(capList.get(ii));
		}

		return top10Caps;
    }
}
