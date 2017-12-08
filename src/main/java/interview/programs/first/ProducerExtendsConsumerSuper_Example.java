package interview.programs.first;

import java.util.ArrayList;
import java.util.List;

/*
    Note: great explanation here: https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
 */
public class ProducerExtendsConsumerSuper_Example {

    public static void main(String[] args) {

        final List<Engineer> engineers = new ArrayList<>();

        engineers.add(new Engineer("engineer1", 3));
        engineers.add(new Engineer("engineer2", 2));
        engineers.add(new Engineer("engineer3", 5));

        foo(engineers);

        System.out.println();

        bar(engineers);

    }


    /*
        Note: this is a producer method, you want to go through the collection and do things with each item.
     */
    private static void foo(List<? extends Employee> employees) {

        //employees.add(new Employee("some someone")); // Note: this is not valid because is a producer.

        employees.forEach(System.out::println);
    }


    /*
        Note: this is a consumer method, you want to add things to the collection.
     */
    private static void bar(List<? super Engineer> employees) {

        employees.add(new Engineer("george georgiou", 1)); // Note: this is a valid operation because is a consumer.

        employees.forEach(System.out::println);

    }

}


class Employee {
    protected String fullname;

    public Employee() {
    }

    public Employee(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullname='" + fullname + '\'' +
                '}';
    }
}

class Engineer extends Employee {

    private int seniorityLevel;

    public Engineer(int seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public Engineer(String fullname, int seniorityLevel) {
        super(fullname);
        this.seniorityLevel = seniorityLevel;
    }

    public int getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(int seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "fullname='" + fullname + '\'' +
                ", seniorityLevel=" + seniorityLevel +
                '}';
    }
}

class Analyst extends Employee {

    private String domainExpertise;

    public Analyst(String domainExpertise) {
        this.domainExpertise = domainExpertise;
    }

    public Analyst(String fullname, String domainExpertise) {
        super(fullname);
        this.domainExpertise = domainExpertise;
    }

    public String getDomainExpertise() {
        return domainExpertise;
    }

    public void setDomainExpertise(String domainExpertise) {
        this.domainExpertise = domainExpertise;
    }

    @Override
    public String toString() {
        return "Analyst{" +
                "fullname='" + fullname + '\'' +
                ", domainExpertise='" + domainExpertise + '\'' +
                '}';
    }
}
