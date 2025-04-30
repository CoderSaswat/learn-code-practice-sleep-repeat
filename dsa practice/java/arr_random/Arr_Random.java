package arr_random;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Arr_Random {
    public static void main(String[] args) {
//        f1();
//        f2();
        f3();
    }

    //2nd largest element
    private static void f3() {
        Integer[] arr = {1,2,4,5,19,14,14,13};

        Integer max = arr[0];
        Integer secondMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax){
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);

    }

    private static void f2() {
        //two sum
        Integer[] arr = {1,3,7,4,3};
        Integer target = 11;
//        Map<Integer, Long> collect = Arrays.stream(arr).collect(Collectors.groupingBy(val -> val, Collectors.counting()));
//        System.out.println(collect);
        // map of value -> index
        //1->0

        Map<Integer,Integer> lookUpMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer temp = target - arr[i];
            if (lookUpMap.containsKey(temp)){
                System.out.println(lookUpMap.get(temp)+ " " + i);
            }else{
                lookUpMap.put(arr[i],i);
            }
        }

    }

    //first non repeating character in sring
    private static void f1() {
        String str = "racefcar";
        char[] charArray = str.toCharArray();
        Map<Character, Integer> lookUpMap = new LinkedHashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if(lookUpMap.containsKey(charArray[i])){
                Integer occurence = lookUpMap.get(charArray[i]);
                occurence++;
                lookUpMap.put(charArray[i],occurence);
            }else{
                lookUpMap.put(charArray[i],0);
            }
        }

        Optional<Character> res = lookUpMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .findFirst()
                .map(entry -> entry.getKey());

        for(Map.Entry<Character,Integer> entry:lookUpMap.entrySet()){
            if(entry.getValue() == 0){
                System.out.println(entry.getKey());
                break;
            }
        }
    }

}
