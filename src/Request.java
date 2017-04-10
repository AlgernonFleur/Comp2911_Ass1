import java.util.ArrayList;

public class Request {
	private int ID;
	private TimeInterval bookingTime;
	private boolean validity;
	
	public Request(	ArrayList<Depot> depotArrayList,
					int ID, TimeInterval bookingTime,
				   	int count1, Transmission type1) {
		this.ID = ID;
		this.bookingTime = bookingTime;
		int autoVans;
		int manVans;
		if(type1.name().equals(Transmission.Automatic.name())) autoVans = count1;
		else manVans = count1;
	}
	
	public Request(	ArrayList<Depot> depotArrayList,
				   	int ID, TimeInterval bookingTime,
				   	int count1, Transmission type1,
				   	int count2, Transmission type2) {
		this.ID = ID;
		this.bookingTime = bookingTime;
		int autoVans;
		int manVans;
		if(type1.name().equals(Transmission.Automatic.name())) autoVans = count1;
		manVans = count1;
		if(type2.name().equals(Transmission.Automatic.name())) autoVans = count2;
		manVans = count2;
	}
	
	@Override
	public String toString() {
		return "Request{" +
				"ID=" + ID +
				", bookingTime=" + bookingTime +
				'}';
	}
}
