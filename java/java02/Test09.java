package java02;


import java.util.*;
import java.util.stream.Collectors;

class Emp{
    public Emp(Integer id, String name, String department, Integer salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    private String name;
    private String department;
    private Integer salary;
}

public class Test09 {

    public static void main(String[] args) {
        //total salary

//        dept to  emps
        /**
         * List<Emp> emps = new ArrayList<>();
         * Double totalSalary = emps.stream().sum(Employee::getSalary)
         * emp.stream().max(Coparator.comparing(Employee.getSalary));
         *  Map<String, Emp> map= emp.stream().groupBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
         *
         *
         *
         *  table - employee
         * columns - name, salary, deptId
         *
         * table - department
         * columns - id, name
         *
         * 1. Fetch name of departments with more than 30 employees
         * 2. Increase salary of employees in HR and IT department by 1000
         *
         * select d.name from departments d
         * join employee e on d.id = e.deptId
         * group by e.deptId
         * having count(*) > 30
         *
         *
         *
         * update employees e
         * join department d on e.dept_id = d.id
         * set e.salary = e.salary + 1000
         * where d.department IN = ('IT','SALES')
         *
         *
         */


        List<Emp> list = List.of(new Emp(1, "saswat", "It",10000), new Emp(2, "virat", "Sales",20000));
        int sum = list.stream().mapToInt(Emp::getSalary).sum();
        list.stream().max(Comparator.comparing(Emp::getSalary));
        Map<String, Optional<Emp>> optionalMap = list.stream().collect(Collectors.groupingBy(Emp::getDepartment, Collectors.maxBy(Comparator.comparing(Emp::getSalary))));
        list.stream().collect(Collectors.groupingBy(Emp::getDepartment,Collectors.mapping(Emp::getName,Collectors.toList())));

    }
}
