import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Person {
    static ArrayList<Person> people = new ArrayList<>();
    final static int MAX_AGE = 1000;
    final static int MAX_ENERGY = 10;
    final static int MIN_ENERGY = -10;

    String name;
    final Date dateOfBirth;
    String gender;
    double height = 0.50;
    double weight = 5;
    private String id;
    double energy = 0;
    boolean isAlive = true;

    Account account;

    // constructors
    private Person() {
        people.add(this);
        dateOfBirth = new Date();
    }

    private Person(String name) {
        this();
        this.name = name;
    }

    public Person(String name, String gender, String id) {
        this(name);
        this.id = id;
    }

    // static methods
    static int nOfAdults() {
        int i = 0;
        for (Person p : people) {
            if (p.getAge() >= 18) // more than 3 minutes old
                ++i;
        }
        return i;
    }

    static void updatePeople() {
        for (Person person : people) {
            if (person.isAlive())
                person.updatePerson();
        }
    }

    // methods
    public boolean hasAccount() {
        if (account == null)
            return false;
        return true;
    }

    public String getUsername() {
        if (hasAccount()) {
            return account.getUsername();
        } else {
            System.out.println("I don't have an account");
            return null;
        }
    }

    public void updatePerson() {
        if (energy > MAX_ENERGY) {
            int delta = (int) energy / MAX_ENERGY;
            weight += delta;
            energy -= delta * MAX_ENERGY;
        } else if (energy < MIN_ENERGY) {
            int delta = (int) energy / MIN_ENERGY;
            weight -= delta;
            energy -= delta * MIN_ENERGY;
        }
        if (this.getAge() > MAX_AGE)
            isAlive = false;
    }

    // overloading example
    public void eat() {
        ++energy;
        System.out.println("eating...");
    }

    public void eat(int food) {
        energy += food;
        System.out.println("eating...");
    }

    public void work() {
        --energy;
        System.out.println("working...");
    }

    public void work(int work) {
        energy -= work;
        System.out.println("working...");
    }

    public void talk() {
        System.out.println("Hi, My name is " + name);
        System.out.println("I'm " + getAge() + " years old");
    }

    public boolean isObese() {
        double BMI = getBMI();
        return BMI > 30;
    }

    public double getBMI() {
        return weight / Math.pow(height, 2);
    }

    public int getAge() {
        return (int) Main.getTimeDiff(Main.startingTime, dateOfBirth, TimeUnit.MINUTES) * 6;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getEnergy() {
        return energy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }
}
