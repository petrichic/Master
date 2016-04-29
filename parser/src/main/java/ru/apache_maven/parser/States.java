package ru.apache_maven.parser;

public class States {
	private String rgltrCd;
	private String st;
	private String dt;
	
	public String getRgltrCd() {
		return rgltrCd;
	}
	public void setRgltrCd(String rgltrCd) {
		this.rgltrCd = rgltrCd;
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
	public void setDt(String dt) {
		this.dt = dt;
	}
	@Override
	public String toString() {
		return "States [rgltrCd=" + rgltrCd + ", st=" + st + ", dt=" + dt + "]";
	}

}
