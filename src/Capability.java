
public class Capability {
	private String jcaId;
	private String capability;
	private String emwCount;
	private String e1;
	private String e2;
	private String e3;
	private String e4;
	private String w1;
	private String w2;
	private String w3;
	private String w4;
	private String w5;
	private String w6;
	private String w7;
	private String w8;
	private String w9;
	private String w10;
	private String m1;
	private String alignment;
	private String emws;
	private String emwDescription;

	public Capability() {
		this.capability = "";
		this.emwCount = "";
		this.e1 = "";
		this.e2 = "";
		this.e3 = "";
		this.e4 = "";
		this.w1 = "";
		this.w2 = "";
		this.w3 = "";
		this.w4 = "";
		this.w5 = "";
		this.w6 = "";
		this.w7 = "";
		this.w8 = "";
		this.w9 = "";
		this.w10 = "";
		this.m1 = "";
		this.alignment = "";
		this.emws = "";
		this.jcaId = "";
		this.emwDescription = "";
	}
	
	public Capability(String capability) {
		this.capability = capability;
		this.emwCount = "";
		this.e1 = "";
		this.e2 = "";
		this.e3 = "";
		this.e4 = "";
		this.w1 = "";
		this.w2 = "";
		this.w3 = "";
		this.w4 = "";
		this.w5 = "";
		this.w6 = "";
		this.w7 = "";
		this.w8 = "";
		this.w9 = "";
		this.w10 = "";
		this.m1 = "";
		this.alignment = "";
		this.emws = "";
		this.jcaId = "";
		this.emwDescription = "";
	}
	public Capability(String capability, String emwCount, String e1, String e2, String e3, String e4, String w1,
			String w2, String w3, String w4, String w5, String w6, String w7, String w8, String w9, String w10,
			String m1) {
		this.capability = capability;
		this.emwCount = emwCount;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.e4 = e4;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
		this.w4 = w4;
		this.w5 = w5;
		this.w6 = w6;
		this.w7 = w7;
		this.w8 = w8;
		this.w9 = w9;
		this.w10 = w10;
		this.m1 = m1;
		this.alignment = "";
		this.emws = "";
		this.jcaId = "";
		this.emwDescription = "";
	}
	public Capability(String capability, String emwCount, String e1, String e2, String e3, String e4, String w1,
			String w2, String w3, String w4, String w5, String w6, String w7, String w8, String w9, String w10,
			String m1, String id) {
		this.capability = capability;
		this.emwCount = emwCount;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.e4 = e4;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
		this.w4 = w4;
		this.w5 = w5;
		this.w6 = w6;
		this.w7 = w7;
		this.w8 = w8;
		this.w9 = w9;
		this.w10 = w10;
		this.m1 = m1;
		this.alignment = "";
		this.emws = "";
		this.jcaId = id;
		this.emwDescription = "";
	}

	public String getCapability() {
		return capability;
	}
	
	public void setCapability(String capability) {
		this.capability = capability;
	}
	
	public String getEmwCount() {
		return emwCount;
	}
	
	public void setEmwCount(String emwCount) {
		this.emwCount = emwCount;
	}
	
	public String getE1() {
		return e1;
	}
	
	public void setE1(String e1) {
		this.e1 = e1;
	}
	
	public String getE2() {
		return e2;
	}
	
	public void setE2(String e2) {
		this.e2 = e2;
	}
	
	public String getE3() {
		return e3;
	}
	
	public void setE3(String e3) {
		this.e3 = e3;
	}
	
	public String getE4() {
		return e4;
	}
	
	public void setE4(String e4) {
		this.e4 = e4;
	}
	
	public String getW1() {
		return w1;
	}
	
	public void setW1(String w1) {
		this.w1 = w1;
	}
	
	public String getW2() {
		return w2;
	}
	
	public void setW2(String w2) {
		this.w2 = w2;
	}
	
	public String getW3() {
		return w3;
	}
	
	public void setW3(String w3) {
		this.w3 = w3;
	}
	
	public String getW4() {
		return w4;
	}
	
	public void setW4(String w4) {
		this.w4 = w4;
	}
	
	public String getW5() {
		return w5;
	}
	
	public void setW5(String w5) {
		this.w5 = w5;
	}
	
	public String getW6() {
		return w6;
	}
	
	public void setW6(String w6) {
		this.w6 = w6;
	}
	
	public String getW7() {
		return w7;
	}
	
	public void setW7(String w7) {
		this.w7 = w7;
	}
	
	public String getW8() {
		return w8;
	}
	
	public void setW8(String w8) {
		this.w8 = w8;
	}
	
	public String getW9() {
		return w9;
	}
	
	public void setW9(String w9) {
		this.w9 = w9;
	}
	
	public String getW10() {
		return w10;
	}
	
	public void setW10(String w10) {
		this.w10 = w10;
	}
	
	public String getM1() {
		return m1;
	}
	
	public void setM1(String m1) {
		this.m1 = m1;
	}
	
	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getEmws() {
		return emws;
	}

	public void setEmws(String emws) {
		this.emws = emws;
	}

	/**
	 * @return the jcaId
	 */
	public String getJcaId() {
		return jcaId;
	}

	/**
	 * @param jcaId the jcaId to set
	 */
	public void setJcaId(String jcaId) {
		this.jcaId = jcaId;
	}

	/**
	 * @return the emwDescription
	 */
	public String getEmwDescription() {
		return emwDescription;
	}

	/**
	 * @param emwDescription the emwDescription to set
	 */
	public void setEmwDescription(String emwDescription) {
		this.emwDescription = emwDescription;
	}
}
