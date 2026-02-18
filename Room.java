package library;

public class Room {
	private final String roomName; 
	private final int capacity; 


	public Room(String roomName, int capacity) {
		if (roomName == null || roomName.trim().isEmpty()) {
			throw new IllegalArgumentException("Room Must have a name!")
			// Make Sure Room has a name. 
		}
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive!")
			// Ensuring no negatives for capacity 
		}
		this.roomName = roomName;
		this.capacity = capacity;
	}
	
	public String getRoomname() { // getter
		return roomName;
	}
	
	@Override // Checks for spelling
	public String toString() {
		return roomName + "(capacity:" + capacity + ")";
	}
		
		

}
