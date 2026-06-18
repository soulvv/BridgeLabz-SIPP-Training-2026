public class SmartLibrarySystem {
    public static void main(String[] args) {
        SmartLibrarySystem system = new SmartLibrarySystem();
        system.getBookLength(5);
        system.getBookLength(2);
        system.getBookLength(1);
    }

    public void getBookLength(int index) {
        String[] books = {"Java", "Python", null, "C++"};
        try {
            int length = books[index].length();
            System.out.println("Length: " + length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid book index.");
        } catch (NullPointerException e) {
            System.out.println("Error: Book entry is null.");
        }
    }
}
