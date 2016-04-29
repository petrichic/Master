package ru.apache_maven.parser;

public class MainAddr {
	private String strt1;
	private String strt2;
	private String city;
	private String state;
	private String cntry;
	private String postlCd;
	private String phNb;
	
	public String getStrt1() {
		return strt1;
	}
	public void setStrt1(String strt1) {
		this.strt1 = strt1;
	}
	public String getStrt2() {
		return strt2;
	}
	public void setStrt2(String strt2) {
		this.strt2 = strt2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCntry() {
		return cntry;
	}
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}
	public String getPostlCd() {
		return postlCd;
	}
	public void setPostlCd(String postlCd) {
		this.postlCd = postlCd;
	}
	public String getPhNb() {
		return phNb;
	}
	public void setPhNb(String phNb) {
		this.phNb = phNb;
	}
	@Override
	public String toString() {
		return "MainAddr [strt1=" + strt1 + ", strt2=" + strt2 + ", city=" + city + ", state=" + state + ", cntry="
				+ cntry + ", postlCd=" + postlCd + ", phNb=" + phNb + "]";
	}

}
