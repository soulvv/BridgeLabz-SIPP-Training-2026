import java.util.Scanner;
public class DeckOfCards {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        print(dist(shuf(init()), s.nextInt(), s.nextInt()));
    }
    static String[] init() {
        String[] s = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] r = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] d = new String[52];
        int idx = 0;
        for(String x : s) for(String y : r) d[idx++] = y + " of " + x;
        return d;
    }
    static String[] shuf(String[] d) {
        for(int i=0; i<52; i++) {
            int r = i + (int)(Math.random() * (52 - i));
            String t = d[i]; d[i] = d[r]; d[r] = t;
        }
        return d;
    }
    static String[][] dist(String[] d, int n, int x) {
        if(n * x > 52) return null;
        String[][] p = new String[x][n];
        int idx = 0;
        for(int i=0; i<x; i++) for(int j=0; j<n; j++) p[i][j] = d[idx++];
        return p;
    }
    static void print(String[][] p) {
        if(p == null) return;
        for(int i=0; i<p.length; i++) {
            System.out.print("Player " + (i+1) + ": ");
            for(String c : p[i]) System.out.print(c + ", ");
            System.out.println();
        }
    }
}
