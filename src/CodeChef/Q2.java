package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0){
            int n, x;
            n = sc.nextInt();
            x = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            if(x > sum){
                System.out.println("-1");
            }
            else {
                Arrays.sort(arr);
                int count = 0;
                int arrSum = 0;
                for(int i = arr.length-1; i >= 0; i--){
                    arrSum+= arr[i];
                    count++;
                    if(arrSum >= x){
                        break;
                    }
                }
                System.out.println(count);
            }

            t--;
        }
    }
}
