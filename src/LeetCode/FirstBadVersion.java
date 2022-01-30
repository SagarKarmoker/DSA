package LeetCode;

public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }

    static int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low <= high){
            int mid = high + (low - high)/2;

            if(mid == n){
                return mid;
            }else if(mid > n){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

//    static boolean isBadVersion(int version){
//
//    }
}
