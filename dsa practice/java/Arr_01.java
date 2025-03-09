import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arr_01 {
    public static void main(String[] args) {
//        f1();
    //    f2();
//        f3();
        // f4_2();
        // f5();
//        f6();
        f7_2();
    }

    /**
     * Remove Duplicates from Sorted Array
     */
    private static void f4() {
        int[] arr = {1, 2, 2, 3, 3, 5, 5};
        int uniqueIndex = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] != arr[uniqueIndex]){
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void f4_2() {
        int[] arr = {1,1,1,1,3,3,4,4,4,5};
        int uniqueIndex = 0;
        for (int i = 1; i<arr.length;i++){
            if (arr[i] != arr[uniqueIndex] ){
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        for (int i = 0; i <= uniqueIndex;i++){
            System.out.println(arr[i]);
        }
        
    }

    /**
     * Check if an Array is Sorted
     */
    private static void f3() {
        System.out.println(f3_1());
    }

    private static boolean f3_1() {
        int[] arr = {1, 3, 5, 7, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Find the Second Largest Element in an Array
     */
    private static void f2() {
        int[] arr = {1,10,2,5,10,10};
        Integer largest = Integer.MIN_VALUE;
        Integer secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }

    /**
     * Find the Largest Element in an Array
     */
    private static void f1() {
        int[] arr = {1, 2, 3, 4, 5, 100, 5, 7};
        Integer max = arr[0];
        for (Integer val : arr) {
            if (val > max) {
                max = val;
            }
        }
        System.out.println(max);
    }

    /**
     * 6.Left Rotate an Array by One Place
     */
    public static void f5(){
        int[] arr = {1,2,3,4,5};
        int temp = arr[0];
        for(int i = 1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.println(Arrays.toString(arr));
    }

    public static void f6(){
        int[] arr = {1,2,3,4,5};
        int d = 8;
        int length = arr.length;
        d = d% length;
        f6_rotate(arr,0,d-1);
        f6_rotate(arr,d,length-1);
        f6_rotate(arr,0,length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void f6_rotate(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    /**
     * 8.Move Zeros to End of Array
     */

    public static void f7(){
        int[] arr = {1,2,0,0,4,0,0};
        int nonZeroIndex = -1;
        for (int i=0; i<arr.length;i++){
            if(arr[i] != 0){
                nonZeroIndex++;
                arr[nonZeroIndex] = arr[i];
            }
        }

        for (int i = nonZeroIndex+1; i <arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void f7_2(){
        int[] arr =  {1,2,0,4,5};
//        3 4
        int j = 0;
//         j -> non zero
        for(int i = 0; i<arr.length; i++){
            if (arr[i] != 0){
                arr[j] = arr[i];
                if (i != j) {
                    arr[i] = 0; // Set the current element to zero
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 9.Find the Union of Two Sorted Arrays
     */
    public static void f8(){
    int[] arr1 = {2,4,5,7,9,11};
    int[] arr2 = {1,2,3,4};
    List<Integer> list = new ArrayList<>();
    int i = 0;
    int j= 0;
    while (i<arr1.length && j<arr2.length){
        if(arr1[i] < arr2[j]){
            list.add(arr1[i]);
            i++;
        }else if(arr1[i] > arr2[j]){
            list.add(arr2[j]);
            j++;
        }else{
            
        }
    }
    }

}
