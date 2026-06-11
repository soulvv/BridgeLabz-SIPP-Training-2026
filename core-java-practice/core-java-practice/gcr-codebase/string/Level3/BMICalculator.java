import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double[][] data = new double[10][2];
        for(int i=0; i<10; i++) { data[i][0] = s.nextDouble(); data[i][1] = s.nextDouble(); }
        display(process(data));
    }
    static String[][] calc(double h, double w) {
        double bmi = w / Math.pow(h/100, 2);
        String stat = bmi<18.5 ? "Underweight" : bmi<24.9 ? "Normal" : bmi<29.9 ? "Overweight" : "Obese";
        return new String[][]{{String.valueOf(Math.round(bmi*100.0)/100.0), stat}};
    }
    static String[][] process(double[][] data) {
        String[][] res = new String[10][4];
        for(int i=0; i<10; i++) {
            res[i][0] = String.valueOf(data[i][1]); res[i][1] = String.valueOf(data[i][0]);
            String[][] b = calc(data[i][1], data[i][0]);
            res[i][2] = b[0][0]; res[i][3] = b[0][1];
        }
        return res;
    }
    static void display(String[][] r) {
        for(String[] a : r) System.out.println(a[0]+"\t"+a[1]+"\t"+a[2]+"\t"+a[3]);
    }
}
