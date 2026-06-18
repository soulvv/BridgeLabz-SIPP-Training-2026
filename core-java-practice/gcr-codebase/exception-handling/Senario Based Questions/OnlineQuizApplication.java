public class OnlineQuizApplication {
    public static void main(String[] args) {
        String[] answers = {"A", "B", "C", "D", null};
        
        for (int i = 0; i <= 6; i++) {
            try {
                if (answers[i].equals("A")) {
                    System.out.println("Answer " + i + " is A");
                } else {
                    System.out.println("Answer " + i + " is not A");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index " + i + " is out of bounds.");
            } catch (NullPointerException e) {
                System.out.println("Error: Answer at index " + i + " is null.");
            }
        }
    }
}
