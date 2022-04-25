import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public boolean hasAge() {
        if (age.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAddress() {
        if (address != null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        try {
            return age;
        } catch (NoSuchElementException e) {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (hasAddress()) {
            System.out.println("Адрес уже известен");
        } else {
            this.address = address;
        }
    }

    public void setAge(int age) {
        if (hasAge()) {
            System.out.println("Возрас уже известен");
        } else {
            this.age = OptionalInt.of(age);
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
        } else {
            System.out.println("Возраст еще неизвестен, необходимо его установить");
        }

    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(5)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge().getAsInt() +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}