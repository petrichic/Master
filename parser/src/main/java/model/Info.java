package model;

public class Info {
	private int id;
	private String sECRgnCD;
	private String firmCrdNb;
	private String sECNb;
	private String busNm;
	private String legalNm;
	    
	public Info( String sECRgnCD, String firmCrdNb, String sECNb, String busNm, String legalNm) {
	      super();
	      this.sECRgnCD = sECRgnCD;
	      this.firmCrdNb = firmCrdNb;
	      this.sECNb = sECNb;
	      this.busNm = busNm;
	      this.legalNm = legalNm;
	   }
	public Info(){};
	    public String getsECRgnCD() {
			return sECRgnCD;
		}
		public void setsECRgnCD(String sECRgnCD) {
			this.sECRgnCD = sECRgnCD;
		}
		public String getFirmCrdNb() {
			return firmCrdNb;
		}
		public void setFirmCrdNb(String firmCrdNb) {
			this.firmCrdNb = firmCrdNb;
		}
		public String getsECNb() {
			return sECNb;
		}
		public void setsECNb(String sECNb) {
			this.sECNb = sECNb;
		}
		public String getBusNm() {
			return busNm;
		}
		public void setBusNm(String busNm) {
			this.busNm = busNm;
		}
		public String getLegalNm() {
			return legalNm;
		}
		public void setLegalNm(String legalNm) {
			this.legalNm = legalNm;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		} 

	    @Override
		public String toString() {
			return "Info [sECRgnCD=" + sECRgnCD + ", firmCrdNb=" + firmCrdNb + ", sECNb=" + sECNb + ", busNm=" + busNm
					+ ", legalNm=" + legalNm + "]";
		}
  
	}