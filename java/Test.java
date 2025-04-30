import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@AllArgsConstructor
class People {
    int id;
    String name;
    int age;
}

public class Test {
    public static void main(String[] args) {
//        Find Even Numbers
        List<Integer> nums = List.of(2, 4, 7, 8, 10);
        List<Integer> list = nums.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(list);

//        Square Each Number and Find Sum
        Integer reduced = nums.stream()
                .map(s -> s * 2)
                .reduce(0, Integer::sum);
        System.out.println(reduced);

//      Convert Strings to Uppercase
        List<String> names = List.of("java", "javascript");
        List<String> nameUpdated = names.stream().map(String::toUpperCase).toList();
        System.out.println(nameUpdated);

        //Count Names Starting with ‘A’
        List<String> sList1 = List.of("Aava", "Javascript");
        List<String> sList1r = sList1.stream().filter(s -> s.startsWith("A")).toList();
        System.out.println(sList1r);

        //Find Maximum Number in a List
        List<Integer> nums1 = List.of(2, 41, 7, 8, 10);
        nums1.stream().max(Integer::compare).ifPresent(System.out::println);
//        nums1.stream().sorted().toList();
//        nums1.stream().distinct().toList();
//        nums1.stream().findFirst();
//        nums1.stream().findAny();
        String collect = names.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        List<People> peoples = List.of(
                new People(1,"Alice", 25),
                new People(2,"Bob", 30),
                new People(3,"Charlie", 25),
                new People(4,"David", 30),
                new People(5,"Eve", 40)
        );
        Map<Integer, List<People>> collect1 = peoples.stream().collect(Collectors.groupingBy(people -> people.age));
        System.out.println(collect1);
    }
}
