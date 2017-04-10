import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
	private final LocalDateTime localDateTime;
	
	public Time(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	
	public LocalDateTime getTime() {
		return localDateTime;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH MMM dd");
		return this.localDateTime.format(formatter);
	}
}
