import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeInterval implements Comparable<TimeInterval>{
	private Time start;
	private Time end;
	
	public TimeInterval(String[] s){
		this.start = new Time(setTime(s[2],s[3],s[4]));
		this.end = new Time(setTime(s[5],s[6],s[7]));
	}
	
	private LocalDateTime setTime(String hour, String month, String day){
		return LocalDateTime.of(2017,
				Month.valueOf(month).getValue(),
				Integer.parseInt(day),
				Integer.parseInt(hour),
				0,0,0);
	}
	
	public Time getStart() {
		return start;
	}
	
	public Time getEnd() {
		return end;
	}
	
	public boolean isIntervalOverlapping(TimeInterval tI){
		if(		tI.start.getTime().isAfter(this.start.getTime()) &&
				tI.start.getTime().isBefore(this.end.getTime().plusHours(1)))
			return true;
		else if(tI.end.getTime().isAfter(this.start.getTime()) &&
				tI.end.getTime().isBefore(this.end.getTime().plusHours(1)))
			return true;
		else if(tI.start.getTime().isBefore(this.start.getTime()) &&
				tI.end.getTime().isAfter(this.end.getTime().plusHours(1)))
			return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return "TimeInterval{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
	
	@Override
	public int compareTo(TimeInterval o) {
		return Integer.compare(	(int)this.start.getTime().toEpochSecond(ZoneOffset.UTC),
								(int)o.start.getTime().toEpochSecond(ZoneOffset.UTC));
	}
	
	public static void main(String[] args) {
		String test1 = "Request 1 10 Mar 3 20 Mar 3 3 Automatic";
		String[] split1 = test1.split(" ");
		TimeInterval ti1 = new TimeInterval(split1);
		System.out.println(ti1);
		
		String test2 = "Request 1 1 Apr 3 20 Apr 3 3 Automatic";
		String[] split2 = test2.split(" ");
		TimeInterval ti2 = new TimeInterval(split2);
		System.out.println(ti2);
		
		String test3 = "Request 1 20 Mar 3 20 Apr 3 3 Automatic";
		String[] split3 = test3.split(" ");
		TimeInterval ti3 = new TimeInterval(split3);
		System.out.println(ti3);
		
		System.out.println(ti1.isIntervalOverlapping(ti2));
		
	}
}
