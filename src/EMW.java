
public class EMW {
	private String emwCombo;
	private String emwCount;
	
	public EMW() {
		this.emwCombo = "";
		this.emwCount = "";
	}
	
	public EMW(String emwCombo) {
		this.emwCombo = emwCombo;
		this.emwCount = "";
	}
	
	public EMW(String emwCombo, String emwCount) {
		this.emwCombo = emwCombo;
		this.emwCount = emwCount;
	}
	
	public String getEmwCombo() {
		return emwCombo;
	}
	public void setEmwCombo(String emwCombo) {
		this.emwCombo = emwCombo;
	}
	public String getEmwCount() {
		return emwCount;
	}
	public void setEmwCount(String emwCount) {
		this.emwCount = emwCount;
	}
}
