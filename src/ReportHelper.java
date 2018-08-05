import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportHelper {

	public static void createSystemAlignmentReport(List<SSystem> alignmentSystems) throws Exception {
    	String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\SystemAlignmentCoverageReport.csv";
    	FileWriter writer = new FileWriter(outputfile);
    	CSVUtils.writeLine(writer, Arrays.asList("System", "Alignment", "Aligned Cap", "Total Cap", "Percent Grouping", "Percent", "EMW Coverage", "Systems with Same EMW Coverage", "EMW Combo Count", "Top 10 EMW Match", "Top 10 EMW Combo #"));
    	
    	for(SSystem system : alignmentSystems) {
    		List<String> list = new ArrayList<>();
    		list.add(system.getSystem());
    		list.add(system.getAlignment());
    		list.add(system.getAlignedCap());
    		list.add(system.getTotalCap());
    		list.add(system.getPercentGrouping());
    		list.add(system.getPercentCoverage());
    		list.add(system.getEmwCombo());
    		list.add(system.getNumSysSameEMW());
    		list.add(system.getEmwComboCount());
    		list.add(system.getTop10emwMatch());
    		list.add(system.getTop10emwComboNum());
        	CSVUtils.writeLine(writer, list);
    	}
    	
    	writer.flush();
    	writer.close();
	}
	
	public static void createCapabilityAlignmentCoverageReport(Capability[] capabilities) throws Exception{
		String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\CapabilityAlignmentCoverageReport.csv";
    	FileWriter writer = new FileWriter(outputfile);
    	CSVUtils.writeLine(writer, Arrays.asList("JCA ID", "Capability", "EMW", "Emw Count"));
    	
    	for(Capability cap : capabilities) {
    		List<String> list = new ArrayList<>();
    		list.add(cap.getJcaId());
    		list.add(cap.getCapability());
    		list.add(CSVUtils.formatEmwCombo(cap.getEmws()));
    		list.add(cap.getEmwCount());
    		CSVUtils.writeLine(writer, list);
    	}
    	
    	writer.flush();
    	writer.close();
	}
	
	public static void createUniqueCapabilityReport(Capability[] capabilities) throws Exception {
    	// Find Unique Capability Count by EMW (only 1 End, Mean, or Way)
    	String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\UniqueCapabilityReport.csv";
    	FileWriter writer = new FileWriter(outputfile);
    	CSVUtils.writeLine(writer, Arrays.asList("JCA ID", "Capability", "EMW", "Emw Count", "EMW Description"));
    	
    	for(Capability cap : capabilities) {
    		if(cap.getEmwCount().equals("1")) {
    			// set emw description
    			cap.setEmwDescription(EmwHelper.setEmwDescriptions(cap.getEmws()));
    			
        		List<String> list = new ArrayList<>();
        		list.add(cap.getJcaId());
        		list.add(cap.getCapability());
        		list.add(cap.getEmws());
        		list.add(cap.getEmwCount());
        		list.add(cap.getEmwDescription());
        		CSVUtils.writeLine(writer, list);
    		}
    	}
    	
    	writer.flush();
    	writer.close();
	}
	
	public static void createSystemToSingleEMW(List<SSystem> sysSingleEmw) throws Exception {
		// Find all individual emws that are mapped to a capability for a system
		String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\SystemToSingleEmwReport.csv";
		FileWriter writer = new FileWriter(outputfile);
		CSVUtils.writeLine(writer, Arrays.asList("System", "JCA ID", "Capability", "EMW", "EMW Description"));
		
		for(SSystem sys : sysSingleEmw) {
			List<String> list = new ArrayList<>();
			list.add(sys.getSystem());
			list.add(sys.getCapJcaId());
			list.add(sys.getCapability());
			list.add(sys.getCapabilityEmw());
			list.add(sys.getCapEmwDescription());
			CSVUtils.writeLine(writer, list);
		}
		
		writer.flush();
		writer.close();
	}
	
	public static void createTop10Capabilities(List<Capability> capList) throws Exception {
		// Find top 10 capabilities with the highest emw count
		String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\Top10CapabilitiesReport.csv";
		FileWriter writer = new FileWriter(outputfile);
		CSVUtils.writeLine(writer, Arrays.asList("JCA ID", "Capability", "EMWs", "Emw Count"));
		
		for(Capability cap : capList) {
			List<String> list = new ArrayList<>();
			list.add(cap.getJcaId());
			list.add(cap.getCapability());
			list.add(CSVUtils.formatEmwCombo(cap.getEmws()));
			list.add(cap.getEmwCount());
			CSVUtils.writeLine(writer, list);
		}
		
		writer.flush();
		writer.close();
	}
	
	public static void createTop10Systems(List<SSystem> top10Sys) throws Exception {
    	String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\Top10SystemsAlignmentReport.csv";
		FileWriter writer = new FileWriter(outputfile);
		
		CSVUtils.writeLine(writer, Arrays.asList("System", "EMW", "EMW Description", "Total EMWs for Entire System"));

		for (SSystem sys : top10Sys) {
			String system = sys.getSystem();
			//System.out.println(sys.getEmwCombo());
			String[] emws = sys.getEmwCombo().split(" | ");
			String total = sys.getEmwComboCount();
			
			if(emws.length != 1) {
				for(String emw : emws) {
					if(!emw.contentEquals("|")) {
						List<String> list = new ArrayList<>();
						list.add(system);
						list.add(emw);
						list.add(EmwHelper.setEmwDescriptions(emw));
						list.add(total);
						//System.out.println(emw);
						CSVUtils.writeLine(writer, list);
					}
				}
			}
		}

		writer.flush();
		writer.close();
	}
	
	public static void createTop10EmwCombos(List<EMW> top10Emws) throws Exception {
    	String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\Top10EmwCombinations.csv";
		FileWriter writer = new FileWriter(outputfile);
		
		CSVUtils.writeLine(writer, Arrays.asList("EMW Combination", "Total Number of Systems", "Top 10 EMW Combo #"));
		
		int num = 1;
		for (EMW emwCombo : top10Emws) {
			List<String> list = new ArrayList<>();
			list.add(CSVUtils.formatEmwCombo(emwCombo.getEmwCombo()));
			list.add(emwCombo.getEmwCount());
			list.add(String.valueOf(num));
			CSVUtils.writeLine(writer, list);
			num++;
		}

		writer.flush();
		writer.close();
	}
	
	public static void createTop10EmwCombosSysList(List<SSystem> alignmentSystems) throws Exception {
    	String outputfile = "C:\\Users\\RyanMichael\\eclipse-workspace\\SystemHistogram\\Top10EmwCombinationsTable.csv";
		FileWriter writer = new FileWriter(outputfile);
		
		CSVUtils.writeLine(writer, Arrays.asList("Emw Combination", "Combination", "System"));
		for(SSystem sys : alignmentSystems) {
			if(!sys.getTop10emwComboNum().equals("")) {
				List<String> list = new ArrayList<>();
				list.add(sys.getTop10emwMatch());
				list.add("Combination " + sys.getTop10emwComboNum());
				list.add(sys.getSystem());
				CSVUtils.writeLine(writer, list);
			}
		}
		
		writer.flush();
		writer.close();
	}
}
