package library;

public class TimeSlot {
	private final int hour;

	public TimeSlot(int hour) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("Hour must be between 0 and 24.") // make sure hours are between 0 and 24
		}
		this.hour = hour;
	}
	public int getHour() {  // getter 
		return hour;
	}
	@0verride 
	public String toString() {
		int displayHour = (hour == 0 || hour == 12) ? 12 : hour % 12;
		String dayTime = (hour < 12) ? "AM" : "PM";  // determine day or night 
		int nextHour = (hour + 1) % 24;
		int nextDisplayHour = (nextHour == 0 || nextHour == 12) ? 12 : nextHour % 12;
		String nextTime = (nextHour < 12) ? "AM" : "PM";
        return String.format("%d:00%s-%d:00%s", displayHour, dayTime, nextDisplayHour, nextTime);
	}
}
	
