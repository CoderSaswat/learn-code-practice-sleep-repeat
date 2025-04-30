package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Streams_random {
    public static void main(String[] args) {
        String[] arr = {"saswat", "121", "papun"};
        List<Integer> list = Arrays.stream(arr).map(val -> {
            try {
                return getSum(Integer.parseInt(val));
            } catch (NumberFormatException e) {
                return val.length();
            }
        }).toList();
        System.out.println(list);


        //map of emp name -> age
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 60000D, 30, "Female"),
                new Employee(2, "Bob", "IT", 75000D, 28, "Male"),
                new Employee(3, "Charlie", "Sales", 50000D, 35, "Male"),
                new Employee(4, "David", "IT", 80000D, 40, "Male"),
                new Employee(5, "Eva", "HR", 65000D, 32, "Female"),
                new Employee(6, "Frank", "IT", 45000D, 25, "Male"),
                new Employee(7, "Grace", "Sales", 70000D, 38, "Female"),
                new Employee(8, "Helen", "Marketing", 55000D, 29, "Female"),
                new Employee(9, "Ian", "Marketing", 48000D, 41, "Male"),
                new Employee(10, "Jack", "IT", 90000D, 36, "Male")
        );

        employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getAge));
        Map<String, Integer> collected = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getAge)));
        Map<String, Integer> collect = collected.entrySet().stream()
                .filter(entry -> entry.getValue() > 60)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        List<Integer> l1 = new Streams01().l1;
        Integer reduced = l1.stream().reduce(1, (a, b) -> a + b);

        Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee::getSalary));
        Map<String, Double> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));
        Map<String, List<String>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));



    }

//    121 -> 12
//    1 + 2 + 1
    private static int getSum(int val) {
        int sum = 0;
        while (val > 0){
            sum = sum+(val % 10);
            val /= 10;
        }
        return sum;
    }

}
