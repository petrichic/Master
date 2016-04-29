package ru.apache_maven.parser;

public class Filing {
	private String Dt;
	private String FormVrsn;
	
	public String getDt() {
		return Dt;
	}
	public void setDt(String dt) {
		Dt = dt;
	}
	public String getFormVrsn() {
		return FormVrsn;
	}
	public void setFormVrsn(String formVrsn) {
		FormVrsn = formVrsn;
	}
	@Override
	public String toString() {
		return "Filing [Dt=" + Dt + ", FormVrsn=" + FormVrsn + "]";
	}

}
