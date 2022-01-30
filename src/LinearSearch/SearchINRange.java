package LinearSearch;

// Search for 3 in the range

public class SearchINRange {
    public static void main(String[] args) {
        int[] array = {18,  12, 3, 34, 29};

        // print index that found the target number
        System.out.println(linearSearch(array, 3, 1,4));

    }

    static int linearSearch(int[] array, int target, int startIndex, int endIndex){
        if(array.length == 0){
            return -1; // if the array length is 0
        }
        else {
            for(int i = startIndex; i < endIndex; i++){
                if(array[i] == target){
                    return i; // returning the index that found
                }
            }
        }

        return -1; // if not found in the array
    }

}
