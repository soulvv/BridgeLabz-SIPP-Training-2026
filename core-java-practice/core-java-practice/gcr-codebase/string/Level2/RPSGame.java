import java.util.Scanner;
public class RPSGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[][] stats = new String[n][3];
        int uW = 0, cW = 0;
        for(int i=0; i<n; i++) {
            String u = s.next(), c = comp();
            String w = win(u, c);
            if(w.equals("User")) uW++;
            else if(w.equals("Computer")) cW++;
            stats[i][0] = u; stats[i][1] = c; stats[i][2] = w;
        }
        display(stats, getStats(uW, cW, n));
    }
    static String comp() {
        int r = (int)(Math.random()*3);
        return r==0 ? "rock" : r==1 ? "paper" : "scissors";
    }
    static String win(String u, String c) {
        if(u.equals(c)) return "Tie";
        if((u.equals("rock")&&c.equals("scissors"))||(u.equals("paper")&&c.equals("rock"))||(u.equals("scissors")&&c.equals("paper"))) return "User";
        return "Computer";
    }
    static String[][] getStats(int u, int c, int n) {
        return new String[][]{
            {"User", String.valueOf((double)u/n), String.valueOf((double)u/n*100)},
            {"Computer", String.valueOf((double)c/n), String.valueOf((double)c/n*100)}
        };
    }
    static void display(String[][] a, String[][] s) {
        for(String[] r : a) System.out.println(r[0]+"\t"+r[1]+"\t"+r[2]);
        for(String[] r : s) System.out.println(r[0]+"\t"+r[1]+"\t"+r[2]+"%");
    }
}
