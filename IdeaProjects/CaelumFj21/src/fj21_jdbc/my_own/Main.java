package fj21_jdbc.my_own;

import java.util.List;

/**
 * Created by gersonsales on 05/01/17.
 */
public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();

        printTable(dao.getPeople());

        Person gerson = new Person("Maria", 21);
        Person sales = new Person("Sales", 22);
        Person araujo = new Person("Araujo", 23);

        dao.addPerson(gerson);
        dao.addPerson(sales);
        dao.addPerson(araujo);

        printTable(dao.getPeople());

        dao.deletePerson(sales);

        printTable(dao.getPeople());

        gerson.setName("Gerson Sales");
        dao.updatePerson(gerson);

        printTable(dao.getPeople());
    }

    private static void printTable(List<Person> people) {
        System.out.println("Table");
        System.out.println("------------------------------------------");
        for (Person person : people) {
            System.out.println("ID: " + person.getId() + " Name: " + person.getName() + " Age: " +
                    person.getAge());
        }
        System.out.println("------------------------------------------");

    }
}
