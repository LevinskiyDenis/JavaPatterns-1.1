import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonBuilder implements IPersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String city;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[а-я]+$", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            this.name = name;
            return this;
        } else {
            throw new IllegalArgumentException("Укажите имя на русском языке");
        }
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[а-я]+$", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(surname);
        if (matcher.matches()) {
            this.surname = surname;
            return this;
        } else {
            throw new IllegalArgumentException("Укажите фамилию на русском языке");
        }
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age >= 0 && age <= 100) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Укажите возраст от 0 до 100 лет");
        }

    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public Person build() throws IllegalStateException {
        if (this.name == null || this.surname == null) throw new IllegalStateException
                ("Имя и фамилия обязательны для создания объекта Person");

        return new Person(this);
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
