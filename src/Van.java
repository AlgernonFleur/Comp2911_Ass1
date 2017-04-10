import java.util.ArrayList;
import java.util.Collections;

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
	
	public Transmission getTransmission() {
		return transmission;
	}
	
	public boolean isTimeIntervalValid(TimeInterval timeInterval){
		for(TimeInterval time:this.bookedTimes){
			if(time.isIntervalOverlapping(timeInterval)) return false;
		}
		return true;
	}
	
	public void addTimeSlot(TimeInterval timeInterval){
		this.bookedTimes.add(timeInterval);
		Collections.sort(this.bookedTimes);
	}
}
