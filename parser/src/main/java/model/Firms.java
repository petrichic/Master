package model;

import java.util.ArrayList;

public class Firms {
	private ArrayList<Firm> listFirms = new ArrayList<Firm>();

	public ArrayList<Firm> getListFirms() {
		return listFirms;
	}
	public void setListFirms(ArrayList<Firm> listFirms) {
		this.listFirms = listFirms;
	}
	
	public boolean add(Firm firm) {
		return listFirms.add(firm);
	}

	public String toString() {
		return "\nFirm: " + listFirms;
	}

}
