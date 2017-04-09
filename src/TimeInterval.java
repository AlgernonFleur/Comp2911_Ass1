import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by Algernon on 9/04/2017.
 */
public class TimeInterval implements Comparable<TimeInterval>{
	private LocalDateTime start;
	private LocalDateTime end;
	
	public TimeInterval(String[] s){
		this.start = setTime(s[2],s[3],s[4]);
		this.end = setTime(s[5],s[6],s[7]);
	}
	
	private LocalDateTime setTime(String hour, String month, String day){
		return LocalDateTime.of(2017,
				Month.valueOf(month).getValue(),
				Integer.parseInt(day),
				Integer.parseInt(hour),
				0,0,0);
	}
	
	public LocalDateTime getStart() {
		return start;
	}
	
	public LocalDateTime getEnd() {
		return end;
	}
	
	public boolean isIntervalOverlapping(TimeInterval tI){
		if(		tI.start.isAfter(this.start) &&
				tI.start.isBefore(this.end)) return true;	//start is in the middle
		else if(tI.end.isAfter(this.start) &&
				tI.end.isBefore(this.end)) return true;		//end is in the middle
		else if(tI.start.isBefore(this.start) &&
				tI.end.isAfter(this.end)) return true;		//this is in the middle
		else return false;
	}
	
	@Override
	public int compareTo(TimeInterval o) {
		return Integer.compare(	(int)this.start.toEpochSecond(ZoneOffset.UTC),
								(int)o.start.toEpochSecond(ZoneOffset.UTC));
	}
	
	public static void main(String[] args) {
		String testLine = "Request 1 10 Mar 3 20 Mar 3 3 Automatic";
		String[] split = testLine.split(" ");
		TimeInterval ti = new TimeInterval(split);
		System.out.println(ti.start);
		System.out.println(ti.end);
	}
}
