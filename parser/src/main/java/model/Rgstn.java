package model;

public class Rgstn {
	private String firmType;
	private String st;
	private String dt;
	
	public String getFirmType() {
		return firmType;
	}
	public void setFirmType(String firmType) {
		this.firmType = firmType;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String string) {
		this.dt = string;
	}
	@Override
	public String toString() {
		return "Rgstn [firmType=" + firmType + ", st=" + st + ", dt=" + dt + "]";
	}

}
