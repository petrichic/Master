package model;

import java.util.Date;

public class Rgstn {
	private String firmType;
	private String st;
	private Date dt;
	private int info_id;
	private int id_rgstn;
	
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
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	@Override
	public String toString() {
		return "Rgstn [firmType=" + firmType + ", st=" + st + ", dt=" + dt + "]";
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public int getId_rgstn() {
		return id_rgstn;
	}
	public void setId_rgstn(int id_rgstn) {
		this.id_rgstn = id_rgstn;
	}

}
