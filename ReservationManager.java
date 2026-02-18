package library;
public class ReservationManager {

    private final ReservationBook book;

    private final Room[] rooms;
    private int roomCount;

    private final TimeSlot[] slots;
    private int slotCount;

    private int nextReservationId;

    public ReservationManager(int maxReservations, int maxRooms, int maxSlots) {

        book = new ReservationBook(maxReservations);

        rooms = new Room[maxRooms];
        roomCount = 0;

        slots = new TimeSlot[maxSlots];
        slotCount = 0;

        nextReservationId = 1;
    }

    public Room createRoom(String roomName, int capacity) {

        if (roomCount >= rooms.length) {
            throw new IllegalStateException("Room storage is full");
        }

        Room room = new Room(roomName, capacity);
        rooms[roomCount++] = room;

        return room;
    }

    public TimeSlot createTimeSlot(int hour) {

        if (slotCount >= slots.length) {
            throw new IllegalStateException("TimeSlot storage is full");
        }

        TimeSlot slot = new TimeSlot(hour);
        slots[slotCount++] = slot;

        return slot;
    }

    public Reservation createReservation(Room room, String studentName, TimeSlot slot) {

        int id = nextReservationId++;

        Reservation reservation = new Reservation(id, room, studentName, slot);
        book.add(reservation);

        return reservation;
    }

    public void cancelReservation(int id) {

        Reservation reservation = book.findById(id);

        if (reservation == null) {
            throw new IllegalArgumentException("No reservation found with id " + id);
        }

        reservation.cancel();
    }

    public void checkInReservation(int id) {

        Reservation reservation = book.findById(id);

        if (reservation == null) {
            throw new IllegalArgumentException("No reservation found with id " + id);
        }

        reservation.checkIn();
    }

    public void printAllReservations() {
        book.printAll();
    }

    public void printReservationsForRoom(Room room) {
        book.printForRoom(room);
    }
}