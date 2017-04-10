import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

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
