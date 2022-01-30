package CodeChef;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0){
            int balls = sc.nextInt();
            int[] red = new int[3];
            int[] green = new int[3];
            int[] blue = new int[3];

            for (int i = 0; i < 3; i++) {
                red[i] = sc.nextInt();
                green[i] = sc.nextInt();
                blue[i] = sc.nextInt();
            }

            int count = 0;
            if(red[0] == balls && green[1] == balls && blue[2] == balls){
                System.out.println(count);
            }
            else {
                /**
                 * 2 1 2
                 * 1 4 0
                 * 2 0 3
                 */
                do{
                    if(red[1] < green[1]){
                        red[1]--;
                        green[1]++;
                        green[0]--;
                        red[0]++;

                        count++;
                    }
                    else if(red[2] < blue[2]){
                        red[2]--;
                        blue[2]++;
                        blue[0]--;
                        red[0]++;

                        count++;
                    }
                }while (red[0] != balls || green[1] != balls || blue[2] != balls);
                System.out.println(count);
            }
            t--;
        }
    }
}
