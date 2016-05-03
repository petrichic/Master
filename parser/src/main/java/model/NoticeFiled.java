package model;

import java.util.ArrayList;

public class NoticeFiled {
	private ArrayList<States> listStates = new ArrayList<States>();

	public ArrayList<States> getListStates() {
		return listStates;
	}

	public void setListStates(ArrayList<States> listStates) {
		this.listStates = listStates;
	}
	
	
	public boolean add(States states){
		return listStates.add(states);
	}
	public String toString() {
        return "\nStates: "+listStates;
	}

}
