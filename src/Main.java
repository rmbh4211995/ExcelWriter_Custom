import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Create CSV Table for Histogram of System Coverage on System Strategic Alignment Dashboard
 * @author RyanMichael
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		
	
		// set csv path files
        Path systemToCapability = Paths.get("C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\SystemToCapability.csv");
        Path capabilityToEMW = Paths.get("C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\CapabilityToEMW.csv");
        
        // read csv files 
        SSystem[] systems = CSVUtils.createSystems(systemToCapability, 2762);
        Capability[] capabilities = CSVUtils.createCapabilities(capabilityToEMW, 716);     
        
        // determine capability alignment
        CapHelper.determineCapabilityAlignment(capabilities);
        
//        for(Capability cap : capabilities) {
//        	System.out.println(cap.getJcaId() + " | " + cap.getCapability() + " | " + cap.getEmws() + " | " + cap.getEmwCount());
//        }
        
        // determine system alignment AND emw mappings for systems
        SystemHelper.determineSystemAlignment(systems, capabilities);
        
        // determine individual emws for all system capabilities
        List<SSystem> sysSingleEmw = SystemHelper.determineSystemToSingleEmw(systems);
        
        // find top 10 capabilities with the highest emw count
        List<Capability> top10Caps = CapHelper.findTop10Capabilities(capabilities);
        
//        for(SSystem sys : systems) {
//        	System.out.println(sys.getSystem() + " | " + sys.getEmwCombo() + " | " + sys.getCapability() + " | " + sys.getNumEmws());
//        }
        
        // give all the same systems the SAME emw mapping
        SystemHelper.setSystemEmwMapping(systems);
        
//        for(SSystem sys : systems) {
//        	System.out.println(sys.getSystem() + " | " + sys.getEmwCombo());
//        }
                
        // for all blank emw mappings set the combo to NONE && remove last comma from emwCombo
        SystemHelper.setNotAlignmentEmwCombo(systems);
        
        // create single alignment list (contains unique systems with their alignment & emw mappings)
        List<SSystem> alignmentSystems = SystemHelper.createAlignmentSystems(systems);
        
//        for(SSystem sys : alignmentSystems) {
//        	System.out.println(sys.getSystem() + " | " + sys.getAlignment() + " | " + sys.getEmwCombo());
//        }
        
        // determine total capabilities & aligned capabilities 
        CapHelper.determineTotalAndAligCap(alignmentSystems, systems, capabilities);
        
//        for(SSystem sys : alignmentSystems) {
//        	System.out.println(sys.getSystem() + " | " + sys.getAlignedCap() + " | " + sys.getTotalCap());
//        }
       
        // determine percent capability alignment (# aligned capabilities / total # of capabilities)
        CapHelper.determinePercentAlignment(alignmentSystems);
        
        // what systems have EXACTLY the same emw mappings as other systems 
        SystemHelper.findSystemsWithSameEmw(alignmentSystems);
        
        // get all unique emw combinations and their counts
        List<EMW> emwCombinations = EmwHelper.findAllEmwCombinations(alignmentSystems);
        
//        for(EMW emw : emwCombinations) {
//        	System.out.println(emw.getEmwCombo() + " | " + emw.getEmwCount());
//        }
                
//        for(SSystem sys : alignmentSystems) {
//        	System.out.println(sys.getSystem() + " | " + sys.getEmwCombo() + " | " + sys.getEmwComboCount());
//        }
        
        // find top 10 EMW combinations
        ArrayList<EMW> top10Emws = EmwHelper.findTop10EmwCombinations(emwCombinations);
        
        // match top 10 emw's to system emw's 
        SystemHelper.matchSystemsToTop10Emws(alignmentSystems, top10Emws);
     
        // find Top 10 Systems with the Highest EMW Count
        List<SSystem> top10Sys = SystemHelper.findTop10SystemsForEmw(alignmentSystems);
        
        // change emwCombo delimter " , " to " | " 
        SystemHelper.formatSysEmwCombo(alignmentSystems);

        // write output to csv's 
        ReportHelper.createSystemAlignmentReport(alignmentSystems);
        ReportHelper.createCapabilityAlignmentCoverageReport(capabilities);
        ReportHelper.createUniqueCapabilityReport(capabilities);
        ReportHelper.createSystemToSingleEMW(sysSingleEmw);
        ReportHelper.createTop10Capabilities(top10Caps);
        ReportHelper.createTop10Systems(top10Sys);
        ReportHelper.createTop10EmwCombos(top10Emws);
        ReportHelper.createTop10EmwCombosSysList(alignmentSystems);   
	}
}
