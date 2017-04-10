import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeInterval implements Comparable<TimeInterval>{
	private LocalDateTime start;
	private LocalDateTime end;
	
	public TimeInterval(int hour1, Month month1, int day1,
						int hour2, Month month2, int day2){
		this.start = LocalDateTime.of(2017,month1.val(),day1,hour1,0);
		this.end = LocalDateTime.of(2017,month2.val(),day2,hour2,0);
	}
	
	public LocalDateTime getStart() {
		return start;
	}
	
	public LocalDateTime getEnd() {
		return end;
	}
	
	public boolean isIntervalOverlapping(TimeInterval tI){
		if(		tI.start.isAfter(this.start) &&
				tI.start.isBefore(this.end.plusHours(1))) return true;
		else if(tI.end.isAfter(this.start) &&
				tI.end.isBefore(this.end.plusHours(1))) return true;
		else if(tI.start.isBefore(this.start) &&
				tI.end.isAfter(this.end.plusHours(1))) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH MMM dd");
		return "TimeInterval{" +
				"start=" + start.format(formatter) +
				", end=" + end.format(formatter) +
				'}';
	}
	
	@Override
	public int compareTo(TimeInterval o) {
		return Integer.compare(	(int)this.start.toEpochSecond(ZoneOffset.UTC),
								(int)o.start.toEpochSecond(ZoneOffset.UTC));
	}
}
