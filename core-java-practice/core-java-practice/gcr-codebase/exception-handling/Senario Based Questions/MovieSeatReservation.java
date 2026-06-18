public class MovieSeatReservation {
    public static void main(String[] args) {
        MovieSeatReservation reservation = new MovieSeatReservation();
        int seat = reservation.getSeat(8);
        System.out.println(seat);
    }

    public int getSeat(int index) {
        int[] seats = {101, 102, 103, 104, 105};
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
}
