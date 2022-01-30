package LinearSearch;

public class LinearS {
    public static void main(String[] args) {

        // Search in the array: return the index

        int[] array = {1, 2, 54, 93, 92, 3, 2};

        int target = 93;

        /**
         * time complexity is O(n) at Worst case [the loop can iterate till the array length or NOT found the element in array]
         * time complexity is O(1) is the Best because it can be found at first index of the array
         */

        // using simple code or using method

//        for(int i = 0; i < array.length; i++){
//            if(array[i] == target){
//                System.out.println(i); // printing the index that found
//            }
//        }

        System.out.println(linearSearch(array, 110));

    }

    static int linearSearch(int[] array, int target){
        if(array.length == 0){
            return -1;
        }
        else {
            for(int i = 0; i < array.length; i++){
                if(array[i] == target){
                    return i; // printing the index that found
                }
            }
        }

        return -1;
    }


}
