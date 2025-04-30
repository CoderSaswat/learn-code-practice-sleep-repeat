package java02;

import java.util.*;

public class Test02 {

//    k smallest pairs with minium sum
//
//    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//
//    Output: [[1,2],[1,4],[1,6]]
//
//
//    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2

//    map of 2 -> [1,1]
//    3 -> [1,2]
//
//    Output: [[1,1],[1,1]]


    public static void main(String[] args) {

        int[] arr1 = {1,1,2};
        int[] arr2 = {1,2,3};
//        kSmallestPairs(arr1, arr2, 2);
        find(arr1,arr2,2);
    }


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<Integer>> lookUpMap = new TreeMap<>();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Integer sum = (Integer) (nums1[i] + nums2[j]);
                if (lookUpMap.containsKey(sum)){
                    list.add(List.of(nums1[i], nums2[j]));
                }
                lookUpMap.put(sum, List.of(nums1[i], nums2[j]));
                list.add(List.of(nums1[i], nums2[j]));
            }
        }
        System.out.println(list);
        return null;
    }

    public static void find(int[] nums1, int[] nums2, int k){
        List<Map.Entry<Integer, List<Integer>>> data = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                data.add(new AbstractMap.SimpleEntry<>(nums1[i]+nums2[j],List.of(nums1[i],nums2[j])));
            }
        }
        data.sort(Comparator.comparing(Map.Entry::getKey));
        System.out.println(data);
        List<Map.Entry<Integer, List<Integer>>> list = data.stream().limit(2).toList();
        System.out.println(list);
    }
}
