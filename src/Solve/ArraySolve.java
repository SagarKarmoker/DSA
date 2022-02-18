package Solve;

import java.util.*;

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

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        for(int i = 0; i < n; i++){
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
        for(int num : nums1){
            System.out.print(num + " ");
        }

        /** this one also correct
         *         int[] nums = new int[m+n];
         *
         *         if (m >= 0) System.arraycopy(nums1, 0, nums, 0, m);
         *
         *         for(int i = 0; i < n; i++){
         *             nums[m++] = nums2[i];
         *         }
         *
         *         Arrays.sort(nums);
         *         nums1 = nums;
         *         for(int num : nums1){
         *             System.out.print(num + " ");
         *         }
         */
    }

    public static int[] sortedSquares(int[] nums) {
        int[] a = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            a[i] = (int) Math.pow(nums[i], 2);
        }
        nums = a;
        Arrays.sort(nums);
        return nums;
    }


    public static void main(String[] args) {
//        int min = 0;
//        int max = 2-1;
//        int i = (int) ((Math.random() * (max - min)) + min);
//        System.out.println(i);


        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        //merge(nums1, 3, nums2, 3);

//        System.out.println(Arrays.toString(sortedSquares(nums2)));

        //System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
