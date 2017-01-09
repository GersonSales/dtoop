package fj21_jdbc.my_own;

/**
 * Created by gersonsales on 05/01/17.
 */
public class Person {
    private static Long peopleId = 1l;

    private Long id;
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.id = peopleId;
        this.name = name;
        this.age = age;

        peopleId++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
