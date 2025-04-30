package java01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(findMissingNumber());
        System.out.println(toSum());
        getOccurenceOne();
    }

    //    1. Find the missing number in an array
    public static int findMissingNumber() {
        int[] arr = {1, 2, 4, 5};
        int length = arr.length + 1;
        int target = length * (length + 1) / 2;
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        return target - sum;
    }

    //    Problem: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    public static List<Integer> toSum() {
        int[] arr = {1, 4, 6, 7};
        int target = 8;
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                list.add(map.get(diff));
                list.add(i);
                return list;
            } else {
                map.put(arr[i], i);
            }
        }
        return list;
    }

    public static void getOccurenceOne() {
        String str = "racecar";
        char[] arr=str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.get(arr[i])+1);
        }

//        for(Map.Entry<Character,Integer> entry:map.entrySet()){
//            if(entry.getValue()==1){
//                System.out.println(entry.getKey());
//                return;
//            }
//        }

        map.forEach((character, integer) -> {
            if(integer ==1){
                System.out.println(character);
            }
        });
    }


}
