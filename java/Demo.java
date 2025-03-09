import java.util.*;
import java.util.stream.Collectors;

class Person{
    String name;
    Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public void setAdult(Boolean adult) {
        isAdult = adult;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    Boolean isAdult;
    Double percentage;

    public Person(String name, Integer id, Boolean isAdult, Double percentage) {
        this.name = name;
        this.id = id;
        this.isAdult = isAdult;
        this.percentage = percentage;
    }

    public Person() {
    }

}

public class Demo {
    public static void main(String[] args) {
        System.out.println("hello world");
        List<String> names = new ArrayList<>();
        names.add("papun");
        names.add("virat");
        names.add("rohit");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(names.contains("papun"));
        names.remove("papun");
        System.out.println(names);
        Person p1 = new Person("saswat", 1, false, 88.99);
        Person p2 = new Person("papun", 2, true, 88.99);
        Person p3 = new Person("virat", 3, false, 48.99);
        Person p4 = new Person("rohit", 4, true, 88.99);
        Person p5 = new Person("rahul", 5, true, 48.99);
        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);
        List<String> list = personList.stream().map(person -> person.name).filter(s -> s.startsWith("sa")).collect(Collectors.toList());
        personList.stream().filter(person -> person.isAdult).map(person -> person.name).collect(Collectors.toList());
        System.out.println(personList.stream().filter(person -> person.isAdult).map(person -> person.name).collect(Collectors.toList()));
        Map<String, Person> personMap= new HashMap<>();
        String name = "saswat panda";
        System.out.println(name.length());
        System.out.println(name.charAt(1));
        System.out.println(name.contains("sas"));
        String[] split = name.split(",");
        for (String s : split) {
            if(s.length() > 1){
                System.out.println(s);
            }
        }
//        Integer n1 = 5;
//        List<Integer> list2 = Arrays.asList(1, 2, 3, 5);
//        for (int i = n1; i >= 1; i--) {
//            if(list2.get(i-1) != i){
//                System.out.println(list2.get(i-1));
//            }
//        }
        List<Person> list1 = personList.stream().filter(person -> person.percentage > 50.0).collect(Collectors.toList());
        list1.forEach(person -> System.out.println(person.name));

        Person p8 = new Person("saswathhh", 10, false, 18.99);
        System.out.println(p8.name);
        updateP1(p8);
        System.out.println(p8.name);
    }

    private static void updateP1(Person p8) {
        p8.setName("papun");
    }


}


