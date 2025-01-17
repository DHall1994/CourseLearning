package demo.PrisonSim;

// Abstraction: Defining a base class (Person) with common properties and methods for Prisoner and Guard.
public abstract class Person {
    private String name;
    private String id;

    public Person(String name) {
        this.name = name;
        this.id = "ID" + System.nanoTime();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}