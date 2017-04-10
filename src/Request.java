import java.util.ArrayList;
import java.util.Iterator;

public class Request {
	private int ID;
	private TimeInterval bookingTime;
	private boolean validity;
	
	public Request(	ArrayList<Depot> depotArrayList,
					int ID, TimeInterval bookingTime,
				   	int count1, Transmission type1) {
		int autoVans = 0;
		int manVans = 0;
		if(type1.name().equals(Transmission.Automatic.name())) autoVans = count1;
		else manVans = count1;
		
		this.ID = ID;
		this.bookingTime = bookingTime;
		this.validity = isTimeIntervalValid(autoVans,manVans,depotArrayList);
	}
	
	public Request(	ArrayList<Depot> depotArrayList,
				   	int ID, TimeInterval bookingTime,
				   	int count1, Transmission type1,
				   	int count2, Transmission type2) {
		int autoVans = 0;
		int manVans = 0;
		if(type1.name().equals(Transmission.Automatic.name())) autoVans = count1;
		manVans = count1;
		if(type2.name().equals(Transmission.Automatic.name())) autoVans = count2;
		manVans = count2;
		
		this.ID = ID;
		this.bookingTime = bookingTime;
		this.validity = isTimeIntervalValid(autoVans,manVans,depotArrayList);
	}
	
	private boolean isTimeIntervalValid(int autoVans,int manVans,
									   ArrayList<Depot> depotArrayList){
		int autoCount = 0;
		int manCount = 0;
		ArrayList<Van> validVans = new ArrayList<>();
		
		for(Depot depot:depotArrayList){
			if(autoVans==autoCount)break;
			Iterator<Van> iterator = depot.getVansList().iterator();
			while(iterator.hasNext()){
				if(autoVans==autoCount)break;
				Van van = iterator.next();
				if(		van.getTransmission().equals(Transmission.Automatic) &&
						van.isTimeIntervalValid(this.bookingTime)){
					validVans.add(van);
					autoCount++;
				}
			}
		}
		
		for(Depot depot:depotArrayList){
			if(manVans==manCount)break;
			Iterator<Van> iterator = depot.getVansList().iterator();
			while(iterator.hasNext()){
				if(manVans==manCount)break;
				Van van = iterator.next();
				if(		van.getTransmission().equals(Transmission.Manual) &&
						van.isTimeIntervalValid(this.bookingTime)){
					validVans.add(van);
					manCount++;
				}
			}
		}
		
		if(autoVans == autoCount && manVans == manCount) {
			for(Van van: validVans)van.addTimeSlot(this.bookingTime);
			return true;
		}
		return false;
	}
	
	public boolean isValidity() {
		return validity;
	}
	
	@Override
	public String toString() {
		return "Request{" +
				"ID=" + ID +
				", bookingTime=" + bookingTime +
				'}';
	}
}
