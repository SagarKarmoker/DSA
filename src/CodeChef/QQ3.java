package CodeChef;

import java.util.Scanner;

public class QQ3 {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t != 0)
        {
            int n, k, x;
            n = sc.nextInt();
            k = sc.nextInt();
            x = sc.nextInt();

            if(k < x){
                System.out.println("-1");
                continue;
            }

            int count = 0;
            while (n!= 0)
            {
                System.out.print( count % x + " ");
                count++;
                n--;
            }
            System.out.println();
            t--;
        }
    }
}
