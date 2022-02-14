package Solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraySolve {
    public static void findIndexs(){
        int[] arr = {1, 2, 3, 3, 3};
        int target = 3;
        ArrayList<Integer> a = new ArrayList<>();
        for(int i =0;i < arr.length; i++){
            if(arr[i] != target){
                continue;
            }


            a.add(i);
        }

        int i = (int) (Math.random() * a.size());
        System.out.println(a.get(i));

        System.out.println(Arrays.toString(new ArrayList[]{a}));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < list1.length; i++){
            hashSet.add(list1[i]);
        }
        ArrayList<String> a = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            if(hashSet.contains(list2[i])){
                a.add(list2[i]);
            }
            else{
                hashSet.add(list2[i]);
            }
        }
        String[] arr = new String[a.size()];
        arr = a.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 2-1;
        int i = (int) ((Math.random() * (max - min)) + min);
        System.out.println(i);
    }
}
