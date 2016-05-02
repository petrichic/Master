package model;

import java.util.Date;

public class States {
	private String rgltrCd;
	private String st;
	private Date dt;
	private int infoid;
	
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
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	@Override
	public String toString() {
		return "States [rgltrCd=" + rgltrCd + ", st=" + st + ", dt=" + dt + "]";
	}
	public int getInfoid() {
		return infoid;
	}
	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}

}
