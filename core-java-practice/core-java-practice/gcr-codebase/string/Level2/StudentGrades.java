import java.util.Scanner;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] m = gen(n);
        double[][] cal = calc(m);
        String[] g = grade(cal);
        disp(m, cal, g);
    }
    static int[][] gen(int n) {
        int[][] m = new int[n][3];
        for(int i=0; i<n; i++) for(int j=0; j<3; j++) m[i][j] = (int)(Math.random()*90)+10;
        return m;
    }
    static double[][] calc(int[][] m) {
        double[][] r = new double[m.length][3];
        for(int i=0; i<m.length; i++) {
            r[i][0] = m[i][0]+m[i][1]+m[i][2];
            r[i][1] = Math.round((r[i][0]/3)*100.0)/100.0;
            r[i][2] = Math.round((r[i][0]/3)*100.0)/100.0;
        }
        return r;
    }
    static String[] grade(double[][] c) {
        String[] g = new String[c.length];
        for(int i=0; i<c.length; i++) {
            double p = c[i][2];
            if(p>=80) g[i]="A";
            else if(p>=70) g[i]="B";
            else if(p>=60) g[i]="C";
            else if(p>=50) g[i]="D";
            else if(p>=40) g[i]="E";
            else g[i]="R";
        }
        return g;
    }
    static void disp(int[][] m, double[][] c, String[] g) {
        for(int i=0; i<m.length; i++) {
            System.out.println(m[i][0]+"\t"+m[i][1]+"\t"+m[i][2]+"\t"+c[i][0]+"\t"+c[i][1]+"\t"+c[i][2]+"\t"+g[i]);
        }
    }
}
