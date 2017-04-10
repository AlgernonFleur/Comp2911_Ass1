package vrs;

import java.util.ArrayList;

public class Depot {
	private String depotName;
	private ArrayList<Van> vanArrayList;
	
	public Depot(String depotName) {
		this.depotName = depotName;
		this.vanArrayList = new ArrayList<>();
	}
}
