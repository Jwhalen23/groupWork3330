package library;

public class Main {

	public static void Main(String[] args) {
		ReservationManager == new ReservationManager(10 ,5 10);
		
		// make rooms 
		System.out.println("---- 1. Creating Rooms and Time Slots ----");
		Room 101 = new Room("Room 101", 3);
		Room 102 = new Room("Room 102", 2);
		
		/ Creating time slots using 24-hour format
        TimeSlot morning = manager.createTimeSlot(9);   // 9:00AM
        TimeSlot noon = manager.createTimeSlot(12);     // 12:00PM
        TimeSlot afternoon = manager.createTimeSlot(14); // 2:00PM
        TimeSlot evening = manager.createTimeSlot(18);   // 6:00PM
        
        System.out.println("setup completed ");
        
       
		
		// reservations
        // Id's come from reservationManager
        System.out.println("---- 2. Creating Reservations ----");
        manager.createReservation(room101, "Jumpin Jack", morning);  // ID 1
        manager.createReservation(room102, "John Jones", morning);    // ID 2
        manager.createReservation(room101, "Tukey Tom", noon);     // ID 3
        manager.createReservation(room102, "Vito Spatafore", afternoon);// ID 4
        manager.createReservation(room101, "Edward Newgate", evening);// ID 5
		
        System.out.println("Initial Reservation List:");
        manager.printAllReservations(); 
        System.out.println();
        
        System.out.println("---- 3. Testing Check-in and Cancellation ----");
        // Check in 
        System.out.println("Checking in Jack (ID 1)...");
        manager.checkInReservation(1);
        
        // Cancel 
        System.out.println("Canceling Vito (ID 4)...");
        manager.cancelReservation(4); 
        System.out.println();
        
        // Display reservation for a single room
        System.out.println("----4. Reporting Functionality----");
        System.out.println("Displaying reservations for Room 101:");
        manager.printReservationsForRoom(room101);
        
        // Show all reservations 
        System.out.println("\nFinal Global Reservation Report:");
        manager.printAllReservations();
        System.out.println();
        
        System.out.println("---- 5. Invariant & Validation Tests ----");
        // Testing if you can check in when cancled 
        try {
            System.out.println("Attempting to check in Vito (already CANCELED)...");
            manager.checkInReservation(2);
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        // Capacity error handeling 
        try {
            System.out.println("Attempting to create a room with 0 capacity...");
            manager.createRoom("Invalid Room", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }

	}

}
