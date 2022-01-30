package Recursion;

public class TowerOfHanoi {

    public static void tower(int totalDisk, String src, String help, String dest){
        //base case
        if(totalDisk == 1){
            System.out.println("transfer disk " + totalDisk + " from (" + src + " to " + dest+ ")");
            return;
        }

        tower(totalDisk-1, src, dest, help); // src -> dest when 1 disk
        System.out.println("disk transfing "+ totalDisk + " from (" + src + " to " + dest + ")");
        tower(totalDisk-1, help, src, dest);

    }

    public static void main(String[] args) {
        int totalDisk = 3;
        //tower(totalDisk, "A", "B", "C");
        tower(totalDisk, "S", "H", "D");
    }
}
