package vrs;

import java.util.ArrayList;

public class Depot {
	private String depotName;
	private ArrayList<Van> vansList;
	
	public Depot(String depotName) {
		this.depotName = depotName;
		this.vansList = new ArrayList<>();
	}
	
	public String getDepotName() {
		return depotName;
	}
	
	public ArrayList<Van> getVansList() {
		return vansList;
	}
	
	public void addVan(Van van){
		this.vansList.add(van);
	}
}
