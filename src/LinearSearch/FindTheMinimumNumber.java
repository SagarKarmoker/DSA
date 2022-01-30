package LinearSearch;

public class FindTheMinimumNumber {
    public static void main(String[] args) {

        int[] array = {18, -23, 12, 3, 34, 29, -1};

        // calling the method
        // min
        System.out.println(min(array));
        // max
        System.out.println(max(array));

    }

    static int min(int[] array) {
        int ans = array[0]; // assuming that index 0's element is the min
        for(int i = 0; i < array.length; i++){
            if(array[i] < ans){ // checking element with index[0]
                ans = array[i]; // if it is less than that and ans to assign
            }
        }

        return ans; // returning the element that found minimum
    }

    static int max(int[] array) {
        int ans = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > ans){
                ans = array[i];
            }
        }

        return ans; // returning the element that found minimum
    }
}
