package CodeChef;

import java.util.Scanner;

public class Q1 {
    public static int getSum(int[] arr){
        int size = arr.length;
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static void rank(int[] dra, int[] slo){
        if (getSum(dra) > getSum(slo)) {
            System.out.println("DRAGON");
        } else if(getSum(dra) == getSum(slo)){
            if (dra[0] != slo[0]) {
                if (dra[0] > slo[0]) {
                    System.out.println("DRAGON");
                } else {
                    System.out.println("SLOTH");
                }
            } else if (dra[1] != slo[1]) {
                if (dra[1] > slo[1]) {
                    System.out.println("DRAGON");
                } else {
                    System.out.println("SLOTH");
                }
            } else {
                System.out.println("TIE");
            }
        }
        else{
            System.out.println("SLOTH");
        }
    }



    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        while (t != 0){
            int[] dra = new int[3];
            int[] slo = new int[3];

            dra[0] = sc.nextInt();
            dra[1] = sc.nextInt();
            dra[2] = sc.nextInt();

            slo[0] = sc.nextInt();
            slo[1] = sc.nextInt();
            slo[2] = sc.nextInt();

            rank(dra, slo);
            t--;
        }

    }
}
