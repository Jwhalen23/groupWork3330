package library;
public class ReservationBook {

    // Using a plain array
    private final Reservation[] reservations;
    private int count;

    public ReservationBook(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("maxCapacity must be positive");
        }

        reservations = new Reservation[maxCapacity];
        count = 0;
    }

    public void add(Reservation r) {
        if (r == null) {
            throw new IllegalArgumentException("reservation cannot be null");
        }

        if (count >= reservations.length) {
            throw new IllegalStateException("ReservationBook is full");
        }

        reservations[count] = r;
        count++;
    }

    // recursive search
    public Reservation findById(int id) {
        return findByIdRecursive(id, 0);
    }

    private Reservation findByIdRecursive(int id, int index) {
        if (index >= count) {
            return null;
        }

        if (reservations[index].getId() == id) {
            return reservations[index];
        }

        return findByIdRecursive(id, index + 1);
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("(no reservations)");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(reservations[i]);
        }
    }

    // Compare rooms using ==
    public void printForRoom(Room room) {

        if (room == null) {
            throw new IllegalArgumentException("room cannot be null");
        }

        boolean printed = false;

        for (int i = 0; i < count; i++) {
            if (reservations[i].getRoom() == room) {
                System.out.println(reservations[i]);
                printed = true;
            }
        }

        if (!printed) {
            System.out.println("(no reservations for " + room + ")");
        }
    }
}