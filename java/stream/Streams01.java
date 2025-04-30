package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams01 {
    List<Integer> l1 = List.of(1, 4, 4, 7, 9);
    public static void main(String[] args) {
//        Find even numbers from a list.
        List<Integer> l1 = new Streams01().l1;
        List<Integer> list = l1.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(list);

//        Convert all strings to uppercase.
        List<String> l2 = List.of("saswat", "virat");
        List<String> list1 = l2.stream().map(String::toUpperCase).toList();
//        System.out.println(list1);

//        Count elements greater than 10.
        long count = l1.stream().filter(num -> num > 5).count();
        System.out.println(count);

//        Find the sum of all numbers.
        Integer reduced = l1.stream().reduce(0, Integer::sum);
        System.out.println(reduced);
        int sum = l1.stream().mapToInt(Integer::intValue).sum();

//        Sort list in descending order.
        List<Integer> list2 = l1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list2);

//        Find the maximum value in a list.
        Optional<Integer> first = l1.stream().max(Comparator.comparing(Integer::intValue));
        System.out.println(first.get());


        Optional<Integer> min = l1.stream().min(Comparator.comparing(Integer::intValue));
        System.out.println(min.get());

//        Remove duplicates from a list.
        List<Integer> list3 = l1.stream().distinct().toList();
        System.out.println(list3);

        //Concatenate strings with commas. (reverse order)
//        String collect = l2.stream().collect(Collectors.joining(","));
        String collect = String.join(",", l2);
        String collect1 = l2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(","));
        System.out.println(collect1);

//        Group strings by length.
        Map<Integer, List<String>> collect2 = l2.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect2);

//        Count frequency of elements.
        Map<Integer, Long> collect3 = l1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);

//        Sum of even numbers only.
        int sum1 = l1.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

//        Check if all elements are positive.
        boolean b = l1.stream().allMatch(num -> num % 2 == 0);
        System.out.println(b);

//        Check if any element is negative.
        list.stream().anyMatch(n -> n < 0);

        //Skip first 5 elements.
        List<Integer> list4 = l1.stream().skip(5).toList();


//        Limit to first 3 elements.
        l1.stream().limit(3).toList();

        //Find second highest number.
        Optional<Integer> first1 = l1.stream().sorted().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(first1.get());

//        Get average of numbers.
        OptionalDouble average = l1.stream().mapToInt(Integer::intValue).average();

//        Flatten a list of lists.
        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(2, 3, 4));
        List<Integer> list5 = lists.stream().flatMap(List::stream).toList();

//        Group employees by department.
//        l1.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        Sort employees by name.
//        l1.stream().sorted(Comparator.comparing(Employee::getName)).toList();

        //no of even and odd values
        Map<Boolean, List<Integer>> collect4 = l1.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(collect4);

//        Join names of employees into one string.
//        l1.stream().map(Employee::getName).collect(Collectors.joining(","));

//        Find longest string.
        l2.stream().max(Comparator.comparing(String::length));

//        Reverse sort of strings by length.
        l2.stream().sorted(Comparator.comparing(String::length).reversed());

        boolean b1 = l2.stream().anyMatch(val -> val.equalsIgnoreCase("saswat"));
        System.out.println(b1);

//        Map of string lengths.
        Map<String, Integer> collect5 = l2.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect5);

//        Sum using reduce.
        Integer reduced1 = l1.stream().reduce(0, (a, c) -> a + c);

//        Sum using reduce.
        Integer reduced2 = l1.stream().reduce(1, (d, e) -> d * e);
        System.out.println(reduced2);

//        Group employees by gender and count.
//        l1.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

//        Find employee with max salary.
//        l1.stream().max(Comparator.comparing(Employee::getSalary));

//        Get department-wise average salary.
//        l1.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

//        Find common elements between two lists.
        List<Integer> list6 = l1.stream().filter(l2::contains).toList();
        System.out.println(list6);

//        Find youngest employee.
//        l1.stream().min(Employee::getAge).orElse(null);

//        Total salary of all employees.
//        double sum2 = l1.stream().mapToDouble(Employee::getSalary).sum();

//        Convert list to set.
        Set<Integer> collect6 = l1.stream().collect(Collectors.toSet());



    }

}
