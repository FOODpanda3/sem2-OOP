/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sum.of.an.arithmetic.series;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class Sum {
      private int n;

    public Sum (int n) {
        this.n = n;
    }

    public int ArithmeticSeriesSum() {
        int sum = 0;
        for (int i = 1; i <= n; i++){
        sum += i;
        }
        return sum;
    }

    public void displayResult() {
       int sum = ArithmeticSeriesSum ();
        System.out.println("The sum of this arithmetic series from 1 to "+n+"\nis "+sum);
               
    }

}
