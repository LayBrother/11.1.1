public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }

        if (address == null && age <= 0) {
            return new Person(name, surname);
        } else if (address == null) {
            return new Person(name, surname, age);
        } else {
            return new Person(name, surname, age, address);
        }
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(age + " - Недопустимый возраст");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}