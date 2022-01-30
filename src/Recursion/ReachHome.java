package Recursion;

public class ReachHome {

    public static void reachHome(int step, int dest){
        System.out.println( "Step " + step + " to go " + dest);
        // base case
        if(step == dest){
            System.out.println("Reached Home");
            return;
        }
        // processing 1 step more
        step++;
        reachHome(step, dest); // recursive call
    }

    public static void main(String[] args) {
        int src = 1, dest = 10;
        reachHome(src, dest);
    }
}
