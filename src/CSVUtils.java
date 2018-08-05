import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class CSVUtils {

    static String csvSplitBy = ",";
	private static final char DEFAULT_SEPARATOR = ',';
    
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
    
	/**
	 * Open SystemToCapability.csv and store it's contents into an array of System objects
	 * 
	 * @param csvPath 		File path to CSV file
	 * @return systemList 	Array containing all SystemOA objects 
	 * @throws Exception
	 */
	public static SSystem[] createSystems(Path csvPath, int size) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(csvPath.toString()));
		String line = "";
		int index = 0;
		SSystem[] systemList = new SSystem[size];
		
		while ((line = br.readLine()) != null) {
			String[] data = line.split(csvSplitBy);
			
			SSystem tempObj = new SSystem(data[0], data[1]);
			tempObj.setAlignment("Not Aligned");
			systemList[index] = tempObj;
			index++;
		}
		
		br.close();
		
		return systemList;
	}
	
	/**
	 * Open CapabilityToEMW.csv and store it's contents into an array of Capability objects
	 * 
	 * @param csvPath 			File path to CSV file
	 * @return capabilityList 	Array containing all Capability objects 
	 * @throws Exception
	 */
	public static Capability[] createCapabilities(Path csvPath, int size) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(csvPath.toString()));
		String line = "";
		int index = 0;
		Capability[] capabilityList = new Capability[size];
		
		while ((line = br.readLine()) != null) {
			String[] data = line.split(csvSplitBy);
			
			Capability tempObj = new Capability(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11],
					data[12], data[13], data[14], data[15], data[16], data[17]);
			tempObj.setAlignment("Not Aligned");
			capabilityList[index] = tempObj;
			index++;
		}
		
		br.close();
		
		return capabilityList;
	}
	
	/**
	 * Remove duplicate emws and return a string of unique emws
	 * 
	 * @param emws			String containing a list of duplicate emw's covered by a system 
	 * @return uniqueEmws 	String containing a list of unique emw's covered by a system
	 * @throws Exception
	 */
	public static String removeDuplicateEMWs(String emws) {
		String[] parts = emws.split(",");
		Set<String> set = new LinkedHashSet<String>();
		String uniqueEMWs = "";
		
		// sort Ends, Means, Ways
		Arrays.sort(parts);
		
		for(int ii = 0; ii < parts.length; ii++) {
			set.add(parts[ii]);
		}
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			uniqueEMWs = uniqueEMWs.concat(it.next() + ",");
		}
    	
		return uniqueEMWs;
	}
	
	public static String formatEmwCombo(String emws) {
		String[] parts = emws.split(",");
		Arrays.sort(parts);
		
		String fEmwCombo = "";
		
		for(int ii = 0; ii < parts.length; ii++) {
			fEmwCombo = fEmwCombo.concat(parts[ii] + " | " );
		}
		
		if(fEmwCombo.equals("")) {
			fEmwCombo = "None ";
		}
		
		fEmwCombo = fEmwCombo.substring(0, fEmwCombo.length() - 2);
		return fEmwCombo;
	}
	
	public static String calculateEmwCoverage(String emwComboCount) {
		String[] parts = emwComboCount.split(",");
		
		return String.valueOf(parts.length);
	}
}
