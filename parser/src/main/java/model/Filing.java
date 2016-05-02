package model;

import java.util.Date;

public class Filing {
	private Date Dt;
	private Date FormVrsn;
	
	public Date getDt() {
		return Dt;
	}
	public void setDt(Date string) {
		Dt = string;
	}
	public Date getFormVrsn() {
		return FormVrsn;
	}
	public void setFormVrsn(Date formVrsn) {
		FormVrsn = formVrsn;
	}
	@Override
	public String toString() {
		return "Filing [Dt=" + Dt + ", FormVrsn=" + FormVrsn + "]";
	}

}
