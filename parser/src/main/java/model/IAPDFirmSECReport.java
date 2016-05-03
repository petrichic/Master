package model;

public class IAPDFirmSECReport {
	private String GenOn;
	private static Firms Firms;
	
	public String getGenOn() {
		return GenOn;
	}
	public void setGenOn(String genOn) {
		GenOn = genOn;
	}
	public static Firms getFirms() {
		return Firms;
	}
	public void setFirms(Firms firms) {
		Firms = firms;
	}
	@Override
	public String toString() {
		return "IAPDFirmSECReport [GenOn=" + GenOn + ", Firms=" + Firms + "]";
	}

}
