package stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee {
    private Integer id;
    private String name;
    private String department;
    private Double salary;
    private Integer age;
    private String gender;

    public Employee(){
    }
    public Employee(Integer id, String name, String department, Double salary, Integer age, String gender){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.gender =gender;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public String getDepartment(){
        return this.department;
    }
    
    public Double getSalary(){
        return this.salary;
    }
    
    public Integer getAge(){
        return this.age;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDepartment(String department){
        this.department = department;
    }
    
    public void setSalary(Double salary){
        this.salary = salary;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    

}

public class Stream02 {
    public static void main(String[] args) {
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

//        1. Employees with salary > 50,000

        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);
//🔹 2. Employees older than 30

        employees.stream()
                .filter(e -> e.getAge() > 30)
                .forEach(System.out::println);
//🔹 3. Employees from HR

        employees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .forEach(System.out::println);
//🔹 4. Names starting with 'A'

        employees.stream()
                .filter(e -> e.getName().startsWith("A"))
                .forEach(System.out::println);
//🔹 5. All male employees

        employees.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                .forEach(System.out::println);
//🔹 6. List of employee names

        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);
//🔹 7. List of employee ages

        List<Integer> ages = employees.stream()
                .map(Employee::getAge)
                .collect(Collectors.toList());
        System.out.println(ages);
//🔹 8. Names in uppercase

        employees.stream()
                .map(e -> e.getName().toUpperCase())
                .forEach(System.out::println);
//🔹 9. Name lengths

        employees.stream()
                .map(e -> e.getName().length())
                .forEach(System.out::println);
//🔹 10. Departments list

        List<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toList());
        System.out.println(departments);

// 21. Employee with highest salary
        Employee employee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);

//    🔹 25. Employee with max name length
        Optional<Employee> max1 = employees.stream().max(Comparator.comparing(emp -> emp.getName().length()));


//        Total number of employees
        long count = employees.stream().count();

//        Total number of it employees cout
        employees.stream().filter(emp-> emp.getDepartment().equalsIgnoreCase("IT")).count();

//        Employee names into a list
        employees.stream().map(Employee::getName).collect(Collectors.toList());

        //Salaries into a set
        employees.stream().map(Employee::getSalary).distinct().toList();
        employees.stream().map(Employee::getSalary).collect(Collectors.toSet());

//        🔹 33. Employees into Map (id as key)
        employees.stream().collect(Collectors.toMap(Employee::getId,emp->emp));

//        Names into a comma-separated string
        employees.stream().map(Employee::getName).collect(Collectors.joining(","));

//        Departments into a set
        employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
//        Uppercase names with semicolon
        employees.stream().map(emp->emp.getName().toUpperCase()).collect(Collectors.joining(""));

        //Names with prefix & suffix
        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "Names :[", "]"));
        System.out.println(collect);

//        Group by department
        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));


//        Group by gender
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

//        Count per department
        Map<Double, Long> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));


//        Average salary by department
        Map<String, Double> collect3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

//        Group names by department
        Map<String, List<String>> collect4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

//        Highest salary in each department
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

//        Employees grouped by age
        Map<Integer, List<Employee>> collect5 = employees.stream().
                collect(Collectors.groupingBy(Employee::getAge));
//        Distinct departments
        employees.stream()
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);
        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .forEach(System.out::println);
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .count();

//        Count of employees in each gender group
        Map<String, Long> collect6 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

//        Employee names grouped by department
        Map<String, List<String>> collect7 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));


//        Find the name of the highest-paid employee per department
        Map<String, Optional<Employee>> collect8 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)
                        ))
                );

//        Partition employees based on salary > 60000
        Map<Boolean, List<Employee>> collect9 = employees.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000));

        DoubleSummaryStatistics salaryStats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(salaryStats);

//        Average age of male and female employees
        employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));


//        8. Join all names in uppercase, separated by comma

        String joinedNames = employees.stream()
                .map(e -> e.getName().toUpperCase())
                .collect(Collectors.joining(", "));

//        Convert list to map with name as key and salary as value
        employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary));

//        Group employees by department and sort them by salary in each group
        Map<String, List<Employee>> collect10 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .collect(Collectors.toList())
        )));

//        . Find top 3 highest paid employees
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .toList();

//        Employees grouped by department, sorted by age (youngest first)
        Map<String, List<Employee>> collect11 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparing(Employee::getAge))
                        .toList()
        )));

//        Gender-wise names joined as comma string
        Map<String, String> collect12 = employees.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().map(Employee::getName).collect(Collectors.joining(",")))
        ));

//        Find department with the most employees
        Optional<String> s = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        //Find average salary of employees older than 30
        Double collect13 = employees.stream()
                .filter(emp -> emp.getSalary() >= 30)
                .collect(Collectors.averagingDouble(Employee::getSalary));

        //🔹 3. List of employee names sorted by department, then by name
        employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName))
                .map(Employee::getName)
                .toList();

//        count employees by age group (<=30, >30)
        Map<String, Long> collect14 = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getAge() <= 30 ? "<=30 employess" : ">30 employess", Collectors.counting()));


//        dept -> sum of salaries
        //Find the department with the highest total salary
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

//        Group employees by gender and count those earning above 50k
        employees.stream()
                .filter(emp-> emp.getSalary() > 50000)
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

//        Find names of the youngest employee(s) in each department
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.minBy(Comparator.comparing(Employee::getAge))
                ));

//        Group employees by department and gender
        Map<String, Map<String, List<Employee>>> collect15 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.groupingBy(Employee::getGender)
        ));

//        Count employees by department and gender
        Map<String, Map<String, Long>> deptGenderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(deptGenderCount);

//        Group employees by salary slab (<=50k, 50k–100k, >100k)
        Map<String, List<Employee>> collect16 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    if (emp.getSalary() <= 50000) {
                        return "<=50k";
                    } else if (emp.getSalary() > 50000 && emp.getSalary() <= 100000) {
                        return "50k-100k";
                    } else {
                        return ">100k";
                    }
                }
        ));
//        13. Get employee names as sorted set
        Set<String> sortedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sortedNames);

//        4. Average salary of each age group

        Map<Integer, Double> avgSalaryByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByAge);

//        15. Find all unique characters in employee names
        Set<Character> uniqueChars = employees.stream()
                .flatMap(e -> e.getName().chars().mapToObj(c -> (char)c))
                .collect(Collectors.toSet());
        System.out.println(uniqueChars);

//        17. Join employee names with a prefix/suffix
        String result = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);

//        Group by department, and count unique names in each
        Map<String, Integer> collect17 = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment,
                                Collectors.mapping(Employee::getName
                                ,Collectors.collectingAndThen(Collectors.toSet(), Set::size)))
                );

//        Total salary by gender
        Map<String, Double> totalSalaryByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.summingDouble(Employee::getSalary)));
        System.out.println(totalSalaryByGender);



    }
}
