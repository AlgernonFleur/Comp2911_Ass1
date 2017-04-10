package vrs;

import java.util.ArrayList;

public class Van {
	private String depotName;
	private String vanName;
	private Transmission transmission;
	private ArrayList<TimeInterval> bookedTimes;
	
	public Van(String depotName, String vanName,Transmission transmission){
		this.depotName = depotName;
		this.vanName = vanName;
		this.transmission = transmission;
		this.bookedTimes = new ArrayList<>();
	}
}
