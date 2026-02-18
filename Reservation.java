package library;
public class Reservation {

    private final int id;
    private final Room room;
    private final String studentName;
    private final TimeSlot timeSlot;

    private boolean canceled;
    private boolean checkedIn;

    // fail fast
    public Reservation(int id, Room room, String studentName, TimeSlot timeSlot) {

        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }
        if (room == null) {
            throw new IllegalArgumentException("room cannot be null");
        }
        if (timeSlot == null) {
            throw new IllegalArgumentException("timeSlot cannot be null");
        }
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("student name cannot be blank");
        }

        this.id = id;
        this.room = room;
        this.studentName = studentName.trim();
        this.timeSlot = timeSlot;

        this.canceled = false;
        this.checkedIn = false;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public boolean canCancel() {
        return !canceled && !checkedIn;
    }

    public boolean canCheckIn() {
        return !canceled && !checkedIn;
    }

    public void cancel() {
        if (!canCancel()) {
            throw new IllegalStateException("Cannot cancel this reservation");
        }
        canceled = true;
    }

    public void checkIn() {
        if (!canCheckIn()) {
            throw new IllegalStateException("Cannot check in this reservation");
        }
        checkedIn = true;
    }

    private String statusText() {
        if (canceled) return "CANCELED";
        if (checkedIn) return "CHECKED IN";
        return "ACTIVE";
    }

    @Override
    public String toString() {
        return "ID " + id
                + " | " + studentName
                + " | " + room
                + " | " + timeSlot
                + " | " + statusText();
    }
}