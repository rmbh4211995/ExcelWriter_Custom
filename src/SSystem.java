import java.util.List;

public class SSystem {
	private String system;
	private String capability;
	private String alignment;
	private String percentCoverage;
	private String alignedCap;
	private String totalCap;
	private String percentGrouping;
	private String emwCombo;
	private String numSysSameEMW;
	private String emwComboCount;
	private String top10emwMatch;
	private String top10emwComboNum;
	private String numEmws;
	private String capabilityEmw;
	private String capEmwCount;
	private String capEmwDescription;
	private String capJcaId;
	private int sqlId;
	
	public SSystem() {
		this.system = "";
		this.capability = "";
		this.alignment = "Not Aligned";
		this.percentCoverage = "";
		this.alignedCap = "";
		this.totalCap = "";
		this.percentGrouping = "";
		this.emwCombo = "";
		this.numSysSameEMW = "";
		this.emwComboCount = "";
		this.top10emwMatch = "";
		this.top10emwComboNum = "";
		this.numEmws = "";
		this.capabilityEmw = "";
		this.capEmwCount = "";
		this.capEmwDescription = "";
		this.capJcaId = "";
		this.sqlId = 0;
	}
	
	public SSystem(String system, String capability) {
		this.setSystem(system);
		this.setCapability(capability);
		this.setAlignment("Not Aligned");
		this.setPercentCoverage("");
		this.setAlignedCap("");
		this.setTotalCap("");
		this.percentGrouping = "";
		this.emwCombo = "";
		this.numSysSameEMW = "";
		this.emwComboCount = "";
		this.top10emwMatch = "";
		this.top10emwComboNum = "";
		this.numEmws = "";
		this.capabilityEmw = "";
		this.capEmwCount = "";
		this.capEmwDescription = "";
		this.capJcaId = "";
	}
	
	public SSystem(String system, String capability, String alignment) {
		this.setSystem(system);
		this.setCapability(capability);
		this.setAlignment(alignment);
		this.setPercentCoverage("");
		this.setAlignedCap("");
		this.setTotalCap("");
		this.percentGrouping = "";
		this.emwCombo = "";
		this.numSysSameEMW = "";
		this.emwComboCount = "";
		this.top10emwMatch = "";
		this.top10emwComboNum = "";
		this.numEmws = "";
		this.capabilityEmw = "";
		this.capEmwCount = "";
		this.capEmwDescription = "";
		this.capJcaId = "";
	}
	
	public SSystem(String system, String capability, String alignment, String capEmw) {
		this.setSystem(system);
		this.setCapability(capability);
		this.setAlignment(alignment);
		this.setPercentCoverage("");
		this.setAlignedCap("");
		this.setTotalCap("");
		this.percentGrouping = "";
		this.emwCombo = "";
		this.numSysSameEMW = "";
		this.emwComboCount = "";
		this.top10emwMatch = "";
		this.top10emwComboNum = "";
		this.numEmws = "";
		this.capabilityEmw = capEmw;
		this.capEmwCount = "";
		this.capEmwDescription = "";
		this.capJcaId = "";
	}
	
	public static boolean containsSystem(SSystem[] array, SSystem compare) {
		boolean value = false;
		
		for(int ii = 0; ii < array.length; ii++) {
			if(array[ii].getSystem().equals(compare.getSystem())) {
				value = true;
			}
		}
		
		return value; 
	}
	
	public static boolean containsSystem(List<SSystem> list, SSystem compare) {
		boolean value = false;
		
		for(int ii = 0; ii < list.size(); ii++) {
			if(list.get(ii).getSystem().equals(compare.getSystem())) {
				value = true;
			}
		}
		
		return value; 
	}
	
	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getPercentCoverage() {
		return percentCoverage;
	}

	public void setPercentCoverage(String percentCoverage) {
		this.percentCoverage = percentCoverage;
	}

	public String getAlignedCap() {
		return alignedCap;
	}

	public void setAlignedCap(String alignedCap) {
		this.alignedCap = alignedCap;
	}

	public String getTotalCap() {
		return totalCap;
	}

	public void setTotalCap(String totalCap) {
		this.totalCap = totalCap;
	}

	public String getPercentGrouping() {
		return percentGrouping;
	}

	public void setPercentGrouping(String percentGrouping) {
		this.percentGrouping = percentGrouping;
	}

	public String getEmwCombo() {
		return emwCombo;
	}

	public void setEmwCombo(String emwCombo) {
		this.emwCombo = emwCombo;
	}

	public String getNumSysSameEMW() {
		return numSysSameEMW;
	}

	public void setNumSysSameEMW(String numSysSameEMW) {
		this.numSysSameEMW = numSysSameEMW;
	}

	public String getEmwComboCount() {
		return emwComboCount;
	}

	public void setEmwComboCount(String emwComboCount) {
		this.emwComboCount = emwComboCount;
	}

	/**
	 * @return the top10emwMatch
	 */
	public String getTop10emwMatch() {
		return top10emwMatch;
	}

	/**
	 * @param top10emwMatch the top10emwMatch to set
	 */
	public void setTop10emwMatch(String top10emwMatch) {
		this.top10emwMatch = top10emwMatch;
	}

	/**
	 * @return the top10emwComboNum
	 */
	public String getTop10emwComboNum() {
		return top10emwComboNum;
	}

	/**
	 * @param top10emwComboNum the top10emwComboNum to set
	 */
	public void setTop10emwComboNum(String top10emwComboNum) {
		this.top10emwComboNum = top10emwComboNum;
	}

	/**
	 * @return the numEmws
	 */
	public String getNumEmws() {
		return numEmws;
	}

	/**
	 * @param numEmws the numEmws to set
	 */
	public void setNumEmws(String numEmws) {
		this.numEmws = numEmws;
	}

	/**
	 * @return the capabilityEmw
	 */
	public String getCapabilityEmw() {
		return capabilityEmw;
	}

	/**
	 * @param capabilityEmw the capabilityEmw to set
	 */
	public void setCapabilityEmw(String capabilityEmw) {
		this.capabilityEmw = capabilityEmw;
	}

	/**
	 * @return the capEmwCount
	 */
	public String getCapEmwCount() {
		return capEmwCount;
	}

	/**
	 * @param capEmwCount the capEmwCount to set
	 */
	public void setCapEmwCount(String capEmwCount) {
		this.capEmwCount = capEmwCount;
	}

	/**
	 * @return the capEmwDescription
	 */
	public String getCapEmwDescription() {
		return capEmwDescription;
	}

	/**
	 * @param capEmwDescription the capEmwDescription to set
	 */
	public void setCapEmwDescription(String capEmwDescription) {
		this.capEmwDescription = capEmwDescription;
	}

	/**
	 * @return the capJcaId
	 */
	public String getCapJcaId() {
		return capJcaId;
	}

	/**
	 * @param capJcaId the capJcaId to set
	 */
	public void setCapJcaId(String capJcaId) {
		this.capJcaId = capJcaId;
	}

	/**
	 * @return the sqlId
	 */
	public int getSqlId() {
		return sqlId;
	}

	/**
	 * @param sqlId the sqlId to set
	 */
	public void setSqlId(int sqlId) {
		this.sqlId = sqlId;
	}
}
